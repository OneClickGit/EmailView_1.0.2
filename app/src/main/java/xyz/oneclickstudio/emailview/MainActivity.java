package xyz.oneclickstudio.emailview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView web_view;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web_view = findViewById(R.id.web_layout);
        web_view.getSettings().setJavaScriptEnabled(true);
        web_view.loadUrl(getResources().getString(R.string.url_webview));
        web_view.setWebViewClient(new MyWebClient());

        // Инициализация AppMetrica SDK
        //YandexMetrica.activate(getApplicationContext(), API_key);

    }

    private class MyWebClient extends WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        if(web_view.canGoBack()) {
            web_view.goBack();
        } else {
            super.onBackPressed();
        }
    }


}
