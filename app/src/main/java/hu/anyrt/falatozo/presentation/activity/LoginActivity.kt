package hu.anyrt.falatozo.presentation.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import hu.anyrt.falatozo.R
import hu.anyrt.falatozo.data.Dao
import hu.anyrt.falatozo.data.entity.User
import hu.anyrt.falatozo.data.response.user.LoginUserResponse
import hu.anyrt.falatozo.network.controller.UserController
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    private val TAG = this::class.java.simpleName
    private lateinit var textInputEditTextUserName: TextInputEditText
    private lateinit var textInputEditTextPassword: TextInputEditText
    private lateinit var buttonLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initViews()
        initEvents()
    }

    private fun initViews() {
        textInputEditTextUserName = findViewById(R.id.textInputEditTextUserName)
        textInputEditTextPassword = findViewById(R.id.textInputEditTextPassword)
        buttonLogin = findViewById(R.id.buttonLogin)
    }

    private fun initEvents() {
        buttonLogin.setOnClickListener {
            login(
                textInputEditTextUserName.text.toString(),
                textInputEditTextPassword.text.toString(),
                it
            )
        }
    }


    /**
     * A felhasználónév és jelszó beviteli mezők alapján bejelentkezteti a felhasználót
     * @param username: felhasználónév
     * @param password: jelszó
     * @param view: a gomb
     * */
    private fun login(username: String, password: String, view: View? = null) {
        val userController = UserController()
        // meghívjuk a loginUser-t ami elvégzi az API hívást
        userController.loginUser(
            username,
            password
        )
            // Feliratkozunk a fő szálra. Ha megjött az API response, akkor fut le a kód belseje
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { lr: Response<LoginUserResponse> ->
                    Log.d(TAG, "api login: start")
                    // Itt történik meg a bejelentkezési adatok szerializálása
                    val loginUserResponse = LoginUserResponse(
                        lr.body()!!.Data,
                        lr.body()!!.HttpResultCode,
                        lr.body()!!.Message
                    )
                    Dao().addUser(
                        User(
                            0,
                            loginUserResponse.Data.id.toString(),
                            loginUserResponse.Data.azonosito,
                            textInputEditTextUserName.getText().toString(),
                            loginUserResponse.Data.vezeteknev,
                            loginUserResponse.Data.keresztnev,
                            loginUserResponse.Data.email,
                            null,
                            null
                        )
                    )
                    Log.d(
                        TAG,
                        "login: user response = $loginUserResponse"
                    )
                    Log.d(TAG, "api header: " + lr.headers())
                    Log.d(TAG, "login: api body: " + lr.body())
                }
            ) { error: Throwable ->
                Log.e(TAG, error.toString())
                if (view != null) {
                    showSnack(view, getString(R.string.invalid_login_data))
                }
            }
    }

    private fun showSnack(view: View, snackMessage: String) {
        val snack = Snackbar.make(
            view, snackMessage,
            Snackbar.LENGTH_LONG
        ).setAction("Action", null)
        snack.setActionTextColor(Color.WHITE)
        snack.setBackgroundTint(Color.WHITE)
        val snackView = snack.view
        val textView =
            snackView.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        textView.textSize = 16f
        textView.setTextColor(ContextCompat.getColor(this@LoginActivity, R.color.any_brown_100))
        snack.show()
    }

}