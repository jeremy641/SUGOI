package com.droideve.apps.sugoi;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


import java.util.Vector;

import com.droideve.apps.sugoi.appconfig.AppConfig;
import com.droideve.apps.sugoi.controllers.SettingsController;
import com.droideve.apps.sugoi.fragments.V2MainFragment;
import  com.droideve.apps.sugoi.mysql.*;
import com.droideve.apps.sugoi.navigationdrawer.NavigationDrawerFragment;
import com.droideve.apps.sugoi.utils.Tools;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class user_coupon_list extends AppCompatActivity {
     private ListView show;
     private JSONArray coupon_baggu_list = null;
     Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_coupon_list);
        setTitle("使用者優惠劵清單");
        show=(ListView)findViewById(R.id.user_coupon_ListView);

        toolbar = findViewById(R.id.mycoupon_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.booking));
        Tools.setSystemBarColor(this);

        new Thread(new Runnable(){
            @Override
            public void run(){
                mysql con = new mysql();
                con.run();
                coupon_baggu_list = con.get_user_coupon_Data(user_coupon_list.this);

                runOnUiThread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void run() {

                        Vector<String>all = new Vector<>();
                        JSONArray new_json_array = new JSONArray();

                        if(coupon_baggu_list.length() != 0){
                            for(int i = 0; i < coupon_baggu_list.length(); i++ ){
                                String data = "";
                                try {
                                    JSONObject a_obj  =coupon_baggu_list.getJSONObject(i);
                                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                                    if(a_obj.getString("use_TF").equals("0") &&
                                            a_obj.getString("time_use_end").compareTo(dtf.format(LocalDateTime.now())) > 0 ){
                                            new_json_array.put(a_obj);

                                    data = "名稱: "+a_obj.getString("label") +"\n" +
                                            "發行店家: "+a_obj.getString("name") +"\n"+
                                            "獲得日期: "+a_obj.getString("get_dt") +"\n"+
                                            "有效日期: "+a_obj.getString("time_use_end");
                                             all.add(data);
                                    }


                                }
                                catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }//for()
                        }//if()


                        ArrayAdapter<String> adapter=
                                new ArrayAdapter<String>(user_coupon_list.this,android.R.layout.simple_list_item_1,all);
                        show.setAdapter(adapter);
                        //show.setOnItemClickListener(listPairedClickItem);
                        show.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                try {
                                    JSONObject a_obj  =new_json_array.getJSONObject(position);
                                    Intent intent = new Intent(user_coupon_list.this, QR.class);
                                    intent.putExtra("id", a_obj.getString("id"));
                                    intent.putExtra("info_id", a_obj.getString("info_id"));
                                    intent.putExtra("user_id", a_obj.getString("user_id"));
                                    intent.putExtra("store_id", a_obj.getString("store_id"));
                                    intent.putExtra("time_use_end",a_obj.getString("time_use_end"));
                                    startActivity(intent);

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }



                            }
                        });


                    }
                });

            }
        }).start();
    }//onCreate
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