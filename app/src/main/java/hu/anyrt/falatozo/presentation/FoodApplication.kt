package hu.anyrt.falatozo.presentation

import android.app.Application
import android.content.Intent
import hu.anyrt.falatozo.data.ObjectBox
import hu.anyrt.falatozo.presentation.activity.LoginActivity


class FoodApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ObjectBox.init(this)

        val loginIntent = Intent(this, LoginActivity::class.java)
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(loginIntent)
    }
}