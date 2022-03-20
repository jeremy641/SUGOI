package com.droideve.apps.sugoi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.droideve.apps.sugoi.appconfig.Constances;
import com.droideve.apps.sugoi.utils.Tools;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.gson.JsonObject;
import org.apache.http.util.EncodingUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import butterknife.BindView;

public class ChartAnalysisActivity extends AppCompatActivity {
    private Spinner spinner;

    @BindView(R.id.toolbar_title)
    TextView APP_TITLE_VIEW;
    @BindView(R.id.toolbar_subtitle)
    TextView APP_DESC_VIEW;
    @BindView(R.id.app_bar)
    Toolbar toolbar;
    String chart_month;

    private BarChart barChart;
    private BarData barData;
    private BarDataSet barDataSet;
    private ArrayList barEntries;

    // 图表
    private LineChart mMainChart;
    // 表格默认缩放比例
    private float scaleX = 1;

    private Context mContext;
    private Matrix mMatrix;

    private List<Entry> entryList = new ArrayList<>();
    private List<Integer> colorList = new ArrayList<>();

    String store_id = null;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_analysis);

        store_id = Integer.toString(getIntent().getIntExtra("id_store",0));

        /*if(store_id==null){
            Log.v("store_id=======","空");
        }else{
            Log.v("store_id=======",store_id);
        }*/

        toolbar = findViewById(R.id.mycoupon_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.chart_anal));
        Tools.setSystemBarColor(this);
        set_spinner();

//        init_bar_chart();
    }


    private  void  init_bar_chart(){
        barChart= findViewById(R.id.chart_bar);
        barChart.setBackgroundColor(Color.WHITE);
        //不显示图表网格
        barChart.setDrawGridBackground(false);
        //背景阴影
        barChart.setDrawBarShadow(false);
        barChart.setHighlightFullBarEnabled(false);
        //显示边框
        barChart.setDrawBorders(true);
        //设置动画效果
        //getEntries();
        barDataSet = new BarDataSet(barEntries, "顏色指標");
        barData = new BarData(barDataSet);
        barChart.setData(barData);
        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(25f);
        barData.setBarWidth(0.5f);
        barChart.getXAxis().setTextSize(14);

        //增加的部分
        // 获取图标Matrix参数
        mMatrix = barChart.getViewPortHandler().getMatrixTouch();
        // 设置平移距离（这里是平移到图标的最右边）
        float distance = barChart.getContentRect().width() * (scaleX - 1);
        mMatrix.setTranslate(-distance, 0);
        //两个参数分别是x,y轴的缩放比例。
        mMatrix.preScale(scaleX, 1f);
        // 刷新
        mMatrix = barChart.getViewPortHandler().refresh(mMatrix, barChart, true);

        //增加止

    }//init_bar_chart()

    private void getEntries() {

        String str = read("RES.txt");
        String[] tokens = str.split(" ");
        barEntries = new ArrayList<>();
        final ArrayList<String> xAxisLabel = new ArrayList<>();
        for(int i =0 ; i <tokens.length; i++){
            xAxisLabel.add("值"+i);//x軸標籤設定
            barEntries.add(new BarEntry(Float.valueOf(String.valueOf(i)),Float.valueOf(tokens[i])));
        }//for

        /*x軸設定*/
        XAxis xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisLabel));
        barChart.invalidate();




    }//getEntries()


    private  String read(String filename) {

        String res = "";
        try {
            //得到資源中的asset資料流
            InputStream in = getResources().getAssets().open(filename);
            int length = in.available();
            byte[] buffer = new byte[length];
            in.read(buffer);
            in.close();
            res = EncodingUtils.getString(buffer, "UTF-8");

        }//try
        catch (Exception e) {
            e.printStackTrace();

        }//catch
        return res;
    }//read()


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
    private void  set_spinner(){
        spinner = (Spinner)findViewById(R.id.spinner3);
        GregorianCalendar now = new GregorianCalendar();
        SimpleDateFormat fmtrq = new SimpleDateFormat("yyyy-MM");//"yyyy-MM-dd"
        DateFormat df = DateFormat.getDateInstance();
        Vector<String> ITEM = new Vector<String>();
        //ITEM.add(fmtrq.format(now.getTime()));
        JSONArray jsonArray =  new JSONArray();

        for(int i = 1 ; i<=6; i++){

            String str=fmtrq.format(now.getTime());
            ITEM.add(str);
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("year",now.get(Calendar.YEAR));
                jsonObject.put("month",now.get(Calendar.MONTH)+1);
                jsonArray.put(jsonObject);
            }catch (Exception e){
                e.printStackTrace();
            }

            now.add(GregorianCalendar.MONTH, -1); //可以是天数或月数  数字自定 -6前6个月


        }//for(-1~-6)
        ArrayAdapter adapter = new ArrayAdapter(ChartAnalysisActivity.this, android.R.layout.simple_spinner_item, ITEM);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(ChartAnalysisActivity.this, "您選擇"+adapterView.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                chart_month = adapterView.getSelectedItem().toString();
                SharedPreferences sharedPreferences= getSharedPreferences("peter_jeremy641_shiyuan55555", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("chart_month", String.valueOf(chart_month));
                editor.apply();

                try {
                    JSONObject json_ym_object =jsonArray.getJSONObject(i);
                    String json_year = json_ym_object.getString("year");
                    String json_month = json_ym_object.getString("month");
                    Log.v("擇年",json_year);
                    Log.v("擇月",json_month);

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            mysql selop = new mysql();
                            selop.run();
                            mysql.getChartLabel get = selop.getChartData(store_id,json_year, json_month);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    barEntries = get.getBarEntries();
                                    init_bar_chart();
                                    try {
                                        Log.v("getChartLabel==========",get.getBarLabel().get(0)+" "+get.getBarEntries().get(0).toString());
                                    }catch(Exception e){
                                        e.printStackTrace();
                                    }

                                    XAxis xAxis = barChart.getXAxis();
                                    xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
                                    xAxis.setGranularity(1);
                                    xAxis.setDrawGridLines(false);
                                    xAxis.setValueFormatter(new IndexAxisValueFormatter(get.getBarLabel()));
                                    barChart.invalidate();
                                }
                            });


                        }
                    }).start();
                }catch (Exception e)
                {
                    e.printStackTrace();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });








    }//set_spinner()
}