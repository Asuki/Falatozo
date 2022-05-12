package hu.anyrt.falatozo

import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var mainWebView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainWebView = findViewById(R.id.mainWebView)

        doSomething()
    }

    private fun doSomething() {
        mainWebView.settings.javaScriptEnabled = true
        mainWebView.setWebViewClient(object : WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                view.loadUrl(request.url.toString())
                return false
            }
        })
        /*
        * myWebView.setWebViewClient(new WebViewClient() {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        view.loadUrl(request.getUrl().toString());
        return false;
    }
});
        * */

        mainWebView.loadUrl("https://www.anyrt.hu")
    }
}