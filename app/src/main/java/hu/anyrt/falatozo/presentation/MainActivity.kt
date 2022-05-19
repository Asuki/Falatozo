package hu.anyrt.falatozo.presentation

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
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

        setSupportActionBar(findViewById(R.id.toolbarMain))

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

    /**
     * Hozzáadja a menüt a felső részen lévő action bar-hoz
     * @param menu: A hozzáadni kívánt menü
     * */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Actionbar összekapcsolása a menüvel
        menuInflater.inflate(R.menu.action_bar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    /**
     * A felső action bar-ban beállított menü eseményeit kezeli let
     * @param item: az adott menü eleme (item)
     * */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        // Ha a kijelentkezés gombot megnyomja a felhasználó, kilép
        if (id == R.id.logoutMenu) {
            finishAffinity()
        }
        else if (id == R.id.settingsMenu){
            startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}