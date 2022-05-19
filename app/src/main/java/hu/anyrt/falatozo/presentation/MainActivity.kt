package hu.anyrt.falatozo.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import hu.anyrt.falatozo.R


class MainActivity : AppCompatActivity() {

    // Navigációhoz kell - vezérlő. Ez tartalmazza a fragmentek nézetét
    private lateinit var navController: NavController
    // Navigációhoz kell - navigáció a fragment váltáshoz
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Navigációhoz kell - fragment összekapcsolása akóddal
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
                as NavHostFragment
        // Navigációhoz kell - fragmentek hozzákapcsolása a conrollerhez
        navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.secondFragment,
            )
        )

        // Navigációhoz kell - alsó navigáció nézetének összekapcsolása a kóddal
        bottomNavigation = findViewById(R.id.bottomNavigationMain)
        // Navigációhoz kell - alsó navigáció összekapcsolása a controllerrel
        bottomNavigation.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    // Navigációhoz kell - navigáció beállítása
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}