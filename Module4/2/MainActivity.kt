package tops.tech.testapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class MainActivity : AppCompatActivity()
{
    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webView_id)
        webView.getSettings().setJavaScriptEnabled(true)
        webView.loadUrl("file:///android_asset/index.html")


    }
}