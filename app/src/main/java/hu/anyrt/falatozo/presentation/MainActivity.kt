package hu.anyrt.falatozo.presentation

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hu.anyrt.falatozo.R
import hu.anyrt.falatozo.data.Dao
import hu.anyrt.falatozo.data.Day
import hu.anyrt.falatozo.data.ObjectBox
import hu.anyrt.falatozo.presentation.adapter.DayRecyclerAdapter


class MainActivity : AppCompatActivity() {

    // Lista nézetek
    private lateinit var recyclerViewDays: RecyclerView
    private lateinit var recyclerViewMenu: RecyclerView

    // Képek a gombokhoz
    private lateinit var imageViewAddToBasket: ImageView
    private lateinit var imageViewClearBasket: ImageView
    private var menuDayList: ArrayList<Day> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ObjectBox.init(this)
        setSupportActionBar(findViewById(R.id.toolbarMain))

        initViews()
    }

    override fun onResume() {
        super.onResume()
        test()
        populateList()
    }

    private fun test() {
        Dao().clearDays()
        Dao().addDay(
            Day(
                0,
                "Hétfő",
                "2022.05.23",
                21,
                true
            )
        )
        Dao().addDay(
            Day(
                day = "Kedd",
                date = "2022.05.24",
                weekNumber = 21,
                isSelected = false
            )
        )
        Dao().addDay(
            Day(
                day = "Szerda",
                date = "2022.05.25",
                weekNumber = 21,
                isSelected = false
            )
        )
        Dao().addDay(
            Day(
                day = "Csütörtök",
                date = "2022.05.26",
                weekNumber = 21,
                isSelected = false
            )
        )
        Dao().addDay(
            Day(
                day = "Péntek",
                date = "2022.05.27",
                weekNumber = 21,
                isSelected = false
            )
        )
    }


    private fun populateList() {
        // Minta lista elemek hozzáadása
        menuDayList.addAll(Dao().getDays())

        // lista feltöltése
        recyclerViewDays.adapter = DayRecyclerAdapter(
            this@MainActivity, menuDayList
        )
    }

    /**
     * Beállítja a nézeteket a Fragmenthez
     * */
    private fun initViews() {
        // A fragmentekben kell a fő nézet az összekapcsoláshoz
        // ezért használjuk itt a rootView változót
        recyclerViewDays = findViewById(R.id.listViewDays)
        recyclerViewDays.layoutManager =
            LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
        recyclerViewMenu = findViewById(R.id.listViewMenu)
        imageViewAddToBasket = findViewById(R.id.imageViewAddToBasketMain)
        imageViewClearBasket = findViewById(R.id.imageViewClearBasketMain)

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
        } else if (id == R.id.settingsMenu) {
            startActivity(Intent(this@MainActivity, SettingsActivity::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}