package io.github.template.ui.modules

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import dagger.hilt.android.AndroidEntryPoint
import io.github.template.R
import io.github.template.databinding.ActivityMainBinding
import io.github.template.util.hideSoftInput
import io.github.template.util.navigateSafe

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment
        navController = navHostFragment.navController

        initializeNavController()
    }

    private fun initializeNavController() {
        viewModel.navCommand.observe(this) { navController.navigateSafe(it) }

        navController.addOnDestinationChangedListener { _, destination, arguments ->
            hideSoftInput()
        }
    }
}
