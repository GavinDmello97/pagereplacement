package com.imperials.osmp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebView_fifo_program extends AppCompatActivity {
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_fifo_program);

        wv = (WebView)findViewById(R.id.web2);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl("http://www.geeksforgeeks.org/program-page-replacement-algorithms-set-2-fifo/");//loads url...url is in the form of string...https:// should always be applied!!!!NOTE
        wv.getSettings().setJavaScriptEnabled(true);//activate any java Script in the app
    }
}
