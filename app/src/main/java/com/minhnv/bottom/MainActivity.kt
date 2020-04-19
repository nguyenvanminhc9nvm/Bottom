package com.minhnv.bottom

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),BlockDrawer {
    private var currentNavController : LiveData<NavController>?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            setUpBottomNavigation()

        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Now that BottomNavigationBar has restored its instance state
        // and its selectedItemId, we can proceed with setting up the
        // BottomNavigationBar with Navigation
        setUpBottomNavigation()

    }

    private fun setUpBottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.nav_view)
        val navGraphIds = listOf(R.navigation.home,R.navigation.dash_broad,R.navigation.noti)
        val controller = bottomNavigationView.setupWithNavControllers(
            navGraphIds,
            supportFragmentManager,
            R.id.navHostMain,
            intent
        )
        controller.observe(this, Observer { navController ->
            val appBarConfiguration = AppBarConfiguration(navController.graph,drawar_layout)
            NavigationUI.setupWithNavController(toolbar,navController,appBarConfiguration)
            NavigationUI.setupWithNavController(navigation_view,navController)
            navController.addOnDestinationChangedListener { nc: NavController, nd: NavDestination, args: Bundle? ->
                if (nd.id == nc.graph.startDestination) {
                    drawar_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
                } else {
                    drawar_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
                }
            }
            btnMenu.setOnClickListener {
                navController.navigate(R.id.action_homeFragment_to_secondFragment)
            }
        })
        currentNavController = controller

    }


    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    /**
     * Overriding popBackStack is necessary in this case if the app is started from the deep link.
     */
    override fun onBackPressed() {
        if (currentNavController?.value?.popBackStack() != true) {
            super.onBackPressed()
        }
    }

    override fun lockDrawer() {
        drawar_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    override fun unlockDrawer() {
        drawar_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }


}
