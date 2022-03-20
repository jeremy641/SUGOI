package com.droideve.apps.sugoi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.droideve.apps.sugoi.appconfig.AppConfig;
import com.droideve.apps.sugoi.controllers.SettingsController;
import com.droideve.apps.sugoi.fragments.V2MainFragment;
import com.droideve.apps.sugoi.navigationdrawer.NavigationDrawerFragment;
import com.droideve.apps.sugoi.utils.Tools;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class QR extends AppCompatActivity {
    private ImageView ivCode;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);

        toolbar = findViewById(R.id.mycoupon_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.booking));
        Tools.setSystemBarColor(this);

        get_QR();
    }//onCreate()
    private  void  get_QR(){
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String info_id = intent.getStringExtra("info_id");
        String user_id = intent.getStringExtra("user_id");
        String store_id = intent.getStringExtra("store_id");
        String time_use_end = intent.getStringExtra("time_use_end");
        String qr_data = id +"," + info_id +"," + user_id +","+ store_id +"," + time_use_end;

        ivCode=(ImageView)findViewById(R.id.imageView);
        BarcodeEncoder encoder = new BarcodeEncoder();
        try{
            Bitmap bit = encoder.encodeBitmap(qr_data, BarcodeFormat.QR_CODE,1280,1280);
            ivCode.setImageBitmap(bit);
        }
        catch (WriterException e){
            e.printStackTrace();
        }



    }//get_QR

    @Override
    public void onBackPressed() {

        if (NavigationDrawerFragment.getInstance() != null)
            NavigationDrawerFragment.getInstance().closeDrawers();

        V2MainFragment mf = (V2MainFragment) getSupportFragmentManager().findFragmentByTag(V2MainFragment.TAG);

        if (mf.ifFirstFragment()) {
            if (AppConfig.RATE_US_FORCE) {
                if (SettingsController.rateOnApp(this)) {
                    super.onBackPressed();
                }
            } else {
                super.onBackPressed();
            }

        } else {
            mf.setCurrentFragment(0);
        }

    }
}//main()