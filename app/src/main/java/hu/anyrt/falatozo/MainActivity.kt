package hu.anyrt.falatozo

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    //region view items
    private lateinit var imageButtonBrowser: ImageButton
    private lateinit var imageButtonSettings: ImageButton
    private lateinit var imageButtonExit: ImageButton
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initEvents()
    }

    /**
     * Nézetek alap beállítása
     * */
    private fun initViews() {
        imageButtonBrowser = findViewById(R.id.imageViewBrowser)
        imageButtonSettings = findViewById(R.id.imageViewSettings)
        imageButtonExit = findViewById(R.id.imageViewExit)
    }

    /**
     * Kattintások és további események beállítása
     * */
    private fun initEvents() {
        // BrowserActivity megnyitása kattintásra
        imageButtonBrowser.setOnClickListener {
            // Új intentet készítünk. Itt állítjuk be, hogy milyen activity-t akarunk majd kezelni
            val browserIntent = Intent(this@MainActivity, BrowserActivity::class.java)
            // Activity indítása
            startActivity(browserIntent)
        }
        imageButtonExit.setOnClickListener {
            finish()
        }
    }
}