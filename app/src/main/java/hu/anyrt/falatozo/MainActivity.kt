package hu.anyrt.falatozo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun x(){
        var x = 1
        x = 3
        Log.d("MainActivity", "x: ${x}")
    }
}