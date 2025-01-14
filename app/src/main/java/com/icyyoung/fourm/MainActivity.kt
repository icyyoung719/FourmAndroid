package com.icyyoung.fourm

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import com.icyyoung.fourm.R
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView = findViewById(R.id.webview)
        webView.webViewClient = WebViewClient()

        // 设置WebView属性
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // 加载Django应用的URL
        webView.loadUrl("http://123.60.191.197:8000")
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}