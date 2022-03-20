package com.droideve.apps.sugoi;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.droideve.apps.sugoi.appconfig.Constances;
import com.droideve.apps.sugoi.utils.Tools;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import butterknife.BindView;

public class ChartActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_title)
    TextView APP_TITLE_VIEW;
    @BindView(R.id.toolbar_subtitle)
    TextView APP_DESC_VIEW;
    @BindView(R.id.app_bar)
    Toolbar toolbar;
    String store_get;

    private ListView show;
    private JSONArray coupon_chart_list = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);

        setTitle("營運分析");
        show=(ListView)findViewById(R.id.user_chart_ListView);

        toolbar = findViewById(R.id.mycoupon_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.chart_anal));
        Tools.setSystemBarColor(this);

        new Thread(new Runnable(){
            @Override
            public void run(){
                mysql con = new mysql();
                con.run();
                coupon_chart_list = con.get_user_chart_Data(ChartActivity.this);

                runOnUiThread(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void run() {

                        Vector<String> all = new Vector<>();
                        Vector<Integer> store = new Vector<>();
                        JSONArray new_json_array = new JSONArray();

                        if(coupon_chart_list.length() != 0){
                            for(int i = 0; i < coupon_chart_list.length(); i++ ){
                                String data = "";
                                try {
                                    JSONObject a_obj  =coupon_chart_list.getJSONObject(i);

                                    new_json_array.put(a_obj);

                                    data = a_obj.getString("name");
                                    store.add(a_obj.getInt("id_store"));
                                    all.add(data);

                                }
                                catch (JSONException e) {
                                    e.printStackTrace();
                                }


                            }//for()
                        }//if()


                        ArrayAdapter<String> adapter=
                                new ArrayAdapter<String>(ChartActivity.this,android.R.layout.simple_list_item_1,all);
                        show.setAdapter(adapter);
                        //show.setOnItemClickListener(listPairedClickItem);
                        show.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                try {
                                    JSONObject a_obj  =new_json_array.getJSONObject(position);
                                    Intent intent = new Intent(ChartActivity.this,ChartAnalysisActivity.class);
                                    intent.putExtra("id_store", store.get(position));
                                    Toast.makeText(ChartActivity.this, "id_store "+ position+" "+ store.get(position), Toast.LENGTH_SHORT).show();
                                    /*store_get = store.get(position).toString();
                                    SharedPreferences sharedPreferences= context.getSharedPreferences("peter_jeremy641_shiyuan", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();
                                    editor.putString("serviceid", String.valueOf(serviceID));
                                    editor.apply();*/
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