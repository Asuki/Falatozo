package hu.anyrt.falatozo.presentation

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.switchmaterial.SwitchMaterial
import hu.anyrt.falatozo.R

class SettingsActivity : AppCompatActivity() {

    private lateinit var switchMenuNotification: SwitchMaterial
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var sharedEditor: SharedPreferences.Editor
    private val TAG = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        init()
    }

    private fun init() {
        sharedPreferences = getSharedPreferences("falatozo_shared_pref", MODE_PRIVATE)
        sharedEditor = sharedPreferences.edit()
        initViews()
        initEvents()
    }

    private fun initViews() {
        // switch kódjának összekapcsolása a nézettel
        switchMenuNotification = findViewById(R.id.switchMenuNotificationSettings)
        // elmentett switch pozíció beállítása
        switchMenuNotification.isChecked =
            sharedPreferences.getBoolean(getString(R.string.menu_notification_pref),
                false)
    }

    private fun initEvents() {
        // Event: Ha klikkel a felhasználó és változik a switch true->fals vagy false->true
        switchMenuNotification.setOnCheckedChangeListener { buttonView, isChecked ->
            // mentjük a beállítás
            // Ezzel tesszük bele a beállítások fájlba
            sharedEditor.putBoolean(getString(R.string.menu_notification_pref), isChecked)
            // Az apply-al aszinkron módon mentjük. Ez kell ahhoz,
            // hogy utána maradandó legyen a változtatás
            sharedEditor.apply()
            // Egyszerű üzenet a felhasználónak
            Toast.makeText(this@SettingsActivity,
                "Feliratkozás változtatva ${isChecked}",
                Toast.LENGTH_SHORT).show()
        }
    }
}