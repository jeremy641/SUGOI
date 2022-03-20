package com.droideve.apps.sugoi;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.appcompat.widget.Toolbar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Size;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.droideve.apps.sugoi.appconfig.AppConfig;
import com.droideve.apps.sugoi.controllers.SettingsController;
import com.droideve.apps.sugoi.fragments.V2MainFragment;
import com.droideve.apps.sugoi.navigationdrawer.NavigationDrawerFragment;
import com.droideve.apps.sugoi.utils.Tools;
import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

public class Scan_Qr extends AppCompatActivity {
    private SurfaceView surfaceView;
    private TextView textView;
    private TextView textView2;
    private CameraSource cameraSource;
    private BarcodeDetector barcodeDetector;
    Toolbar toolbar;
    private Button check;
    public  static   qr_data send;
    public  static  String temp ="";
    private  mysql con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr);

        toolbar = findViewById(R.id.scanQR_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.qr_scan));
        Tools.setSystemBarColor(this);

        surfaceView=(SurfaceView)findViewById(R.id.surfaceView);
        textView=(TextView)findViewById(R.id.textView);
        textView2=(TextView)findViewById(R.id.textView2);


        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.QR_CODE).build();



        cameraSource = new CameraSource.Builder(this,barcodeDetector)
                .setFacing(CameraSource.CAMERA_FACING_BACK)
                .setRequestedPreviewSize(1920, 1080)
                .setRequestedFps(60.0f)
                .setAutoFocusEnabled(true)
                .build();

        surfaceView.getHolder().addCallback(new SurfaceHolder.Callback(){
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED)
                    return;
                try{
                    cameraSource.start(holder);
                }
                catch (IOException e){
                    e.printStackTrace();
                }

            }


            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                cameraSource.stop();

            }
        });



        barcodeDetector.setProcessor(new Detector.Processor<Barcode>(){


            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qrCodes=detections.getDetectedItems();
                if(qrCodes.size()!=0){
                    textView.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(qrCodes.valueAt(0).displayValue);
                        }
                    });
                }

            }
        });

        new Thread(new Runnable(){
            @Override
            public void run(){
                //con = new mysql();
                //con.run();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        check = findViewById(R.id.check);
                        check.setOnClickListener(new View.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void onClick(View view) {
                                if(!textView.getText().toString().trim().equals("") ){
                                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                                    String[] tokens = textView.getText().toString().split(",");

                                    if(tokens[4].compareTo(dtf.format(LocalDateTime.now())) > 0){
                                        send = new qr_data(tokens);
                                        Log.v("errpr","aaaaaaaa========="+send.data_array[0]+ "\n"+
                                                                   send.data_array[1]+"\n"+
                                                                    send.data_array[2]+"\n"+
                                                                    send.data_array[3] +"\n"+
                                                                    send.data_array[4]
                                                );
                                               temp  = send.data_array[0];
                                               new Thread(new Runnable() {
                                                   @Override
                                                   public void run() {
                                                       mysql accd = new mysql();
                                                       accd.run();
                                                       int res = accd.db_update(Scan_Qr.this,send.data_array[0],send.data_array[2]);
                                                       runOnUiThread(new Runnable() {
                                                           @Override
                                                           public void run() {
                                                             //  Toast.makeText( Scan_Qr.this, "資料庫執行結果"+ res , Toast.LENGTH_SHORT).show();
                                                               if(res == 1){
                                                                   Toast.makeText( Scan_Qr.this, "優惠券過刷成功，優惠券已被使用" , Toast.LENGTH_SHORT).show();
                                                                   textView2.setText("優惠券過刷成功，優惠券已被使用");
                                                               }else{
                                                                   Toast.makeText( Scan_Qr.this, "優惠券過刷失敗" , Toast.LENGTH_SHORT).show();
                                                                   textView2.setText("優惠券過刷失敗");
                                                               }
                                                           }
                                                       });

                                                   }
                                               }).start();

                                    }//if(有效期大)
                                    else{
                                        Toast toast = Toast.makeText( Scan_Qr.this, "過有效期", Toast.LENGTH_SHORT);
                                        toast.show();
                                    }

                                }//if(如果textView有值)


                            }
                        });//check

                    }
                });





            }
        }).start();





    }//onCreate()









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




    public class qr_data {

        private  String[]data_array;




        public qr_data(String data_array[]){
            this.data_array = data_array;

        }

        public String[]getData_array(){
            return this.data_array=data_array;
        }


    }


}//main()