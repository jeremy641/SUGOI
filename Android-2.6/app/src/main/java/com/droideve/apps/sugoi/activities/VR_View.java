package com.droideve.apps.sugoi.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;


import com.droideve.apps.sugoi.R;
import com.droideve.apps.sugoi.appconfig.Constances;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VR_View extends AppCompatActivity {

    @BindView(R.id.toolbar_title)
    TextView APP_TITLE_VIEW;
    @BindView(R.id.toolbar_subtitle)
    TextView APP_DESC_VIEW;
    @BindView(R.id.app_bar)
    Toolbar toolbar;
    String StoreID;

    private WebView webView;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vr_view);

        ButterKnife.bind(this);
        initToolbar();

        APP_TITLE_VIEW.setText(getResources().getString(R.string.vr_view));
        APP_TITLE_VIEW.setVisibility(View.VISIBLE);


        webView = findViewById(R.id.merchant_web);


        //storeID 傳值
        SharedPreferences sharedPreferences= getSharedPreferences("peter_jeremy641_shiyuan333", Context.MODE_PRIVATE);
        StoreID = sharedPreferences.getString("storeid","未存任何資料");
        Log.v("storeid","aaaaaaaa========="+StoreID);

        switch (StoreID){
            case "7":
                webView.loadUrl("http://163.30.84.23/360vr_upload/examples/Good_tree_Good_life.html");//加载url
                break;
            case "10":
                webView.loadUrl("http://163.30.84.23/360vr_upload/examples/Good_dream.html");//加载url
                break;
            case "8":
                webView.loadUrl("http://163.30.84.23/360vr_upload/examples/Good_beautiful.html");//加载url
                break;
            case "9":
                webView.loadUrl("http://163.30.84.23/360vr_upload/examples/Good_warm.html");//加载url
                break;
            default:
                webView.loadUrl("http://163.30.84.23/360vr_upload/examples/nashi.html");//加载url

        }
        webView.setWebViewClient(webViewClient);

        WebSettings webSettings = webView.getSettings();
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        webSettings.setJavaScriptEnabled(true);
        //支持屏幕缩放
//        webSettings.setSupportZoom(true);
//        webSettings.setBuiltInZoomControls(true);
        //不显示webview缩放按钮
//      webSettings.setDisplayZoomControls(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.righttoleft_enter, R.anim.righttoleft_exit);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.righttoleft_enter, R.anim.righttoleft_exit);
    }

    //WebViewClient主要帮助WebView处理各种通知、请求事件
    private WebViewClient webViewClient = new WebViewClient() {

    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i("ansen", "是否有上一个页面:" + webView.canGoBack());
        if (webView.canGoBack() && keyCode == KeyEvent.KEYCODE_BACK) {//点击返回按钮的时候判断有没有上一页
            webView.goBack(); // goBack()表示返回webView的上一页面
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void initToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayUseLogoEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        APP_DESC_VIEW.setVisibility(View.GONE);

        String about = Constances.initConfig.AppInfos.ABOUT_CONTENT;

        APP_DESC_VIEW.setVisibility(View.GONE);

    }


}