package io.github.template.ui.modules

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.github.template.R
import com.github.template.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import io.github.template.util.hideSoftInput
import io.github.template.util.navigateSafe

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by viewModels()

    lateinit var binding: ActivityMainBinding

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        navController = findNavController(R.id.main_nav_host)

        initializeNavController()
    }

    private fun initializeNavController() {
        viewModel.navCommand.observe(this) { navController.navigateSafe(it) }

        navController.addOnDestinationChangedListener { _, destination, arguments ->
            hideSoftInput()
        }
    }
}
