package com.droideve.apps.sugoi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.droideve.apps.sugoi.activities.CustomSearchActivity;
import com.droideve.apps.sugoi.activities.StoreDetailActivity;
import com.droideve.apps.sugoi.booking.modals.Option;
import com.droideve.apps.sugoi.booking.modals.Service;
import com.droideve.apps.sugoi.classes.User;
import com.droideve.apps.sugoi.parser.Parser;
import com.droideve.apps.sugoi.parser.api_parser.UserParser;
import com.droideve.apps.sugoi.booking.views.fragments.ServiceOptionsFragment;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CouponActivity extends AppCompatActivity {
    private CustomDialog customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coupon_deal);

        customDialog = new CustomDialog(CouponActivity.this);
        customDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    Thread.sleep(0);
                    try {
                        Option option = new Option();
                        User user = new User();
                        URL url = new URL("http://163.30.84.23:27027/get_coupon/get_coupon.jsp");
                        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("POST");
                        connection.setDoOutput(true);
                        connection.setDoInput(true);
                        connection.setUseCaches(false);
                        connection.connect();

                        //serviceID 傳值
                        SharedPreferences sharedPreferences= getSharedPreferences("peter_jeremy641_shiyuan", Context.MODE_PRIVATE);
                        String ServiceID = sharedPreferences.getString("serviceid","未存任何資料");
                        Log.v("serviceid","aaaaaaaa========="+ServiceID);

                        //UserID 傳值
                        SharedPreferences sharedPreferences2= getSharedPreferences("peter_jeremy641_shiyuan2", Context.MODE_PRIVATE);
                        String UserID = sharedPreferences2.getString("userid","未存任何資料");
                        Log.v("Userid","bbbbbbbbb========="+UserID);

                        //String body = "p_info_id=10&user_id=10&guichi_model=0";
                        String body = "p_info_id="+ServiceID+"&user_id="+UserID+"&guichi_model=0";
                        Log.v("faasdf","body========="+body);

                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
                        writer.write(body);
                        writer.close();

                        int responseCode = connection.getResponseCode();
                        if(responseCode == HttpURLConnection.HTTP_OK){
                            InputStream inputStream = connection.getInputStream();
                            String result = is2String(inputStream);//将流转换为字符串。
                            Log.d("kwwl","result============="+result);

                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    set_example(result);
                                    customDialog.dismiss();
                                }
                            });
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
    public void set_example(String vien){
        TextView example = (TextView)findViewById(R.id.textview_example);
        //example.setText(vien);

        //過期優惠券訊息框
        if(vien.contains("time_pass")){
            AlertDialog.Builder dialog = new AlertDialog.Builder(CouponActivity.this);
            dialog.setTitle("優惠券狀態");
            dialog.setMessage("已經過期了!");
            dialog.setPositiveButton(R.string.confirm,
                    new DialogInterface.OnClickListener(){
                        public void onClick(
                                DialogInterface dialoginterface, int i){
                            finish();
                        }
                    });
            dialog.show();
        }

        //成功獲得優惠券訊息框(一)
        if(vien.contains("win")){
            AlertDialog.Builder dialog = new AlertDialog.Builder(CouponActivity.this);
            dialog.setTitle("優惠券狀態");
            dialog.setMessage("恭喜您獲得此優惠券!");
            dialog.setPositiveButton(R.string.confirm,
                    new DialogInterface.OnClickListener(){
                        public void onClick(
                                DialogInterface dialoginterface, int i){
                            finish();
                        }
                    });
            dialog.show();
        }


        //未獲得優惠券訊息框
        if(vien.contains("not_get")){
            AlertDialog.Builder dialog = new AlertDialog.Builder(CouponActivity.this);
            dialog.setTitle("優惠券狀態");
            dialog.setMessage("您未獲得此優惠券!");
            dialog.setPositiveButton(R.string.confirm,
                    new DialogInterface.OnClickListener(){
                        public void onClick(
                                DialogInterface dialoginterface, int i){
                            finish();
                        }
                    });
            dialog.show();
        }

        //時間未到優惠券訊息框
        if(vien.contains("time_before")){
            AlertDialog.Builder dialog = new AlertDialog.Builder(CouponActivity.this);
            dialog.setTitle("優惠券狀態");
            dialog.setMessage("此優惠券尚未開放");
            dialog.setPositiveButton(R.string.confirm,
                    new DialogInterface.OnClickListener(){
                        public void onClick(
                                DialogInterface dialoginterface, int i){
                            finish();
                        }
                    });
            dialog.show();
        }

        //時間過期優惠券訊息框
        if(vien.contains("time_pass")){
            AlertDialog.Builder dialog = new AlertDialog.Builder(CouponActivity.this);
            dialog.setTitle("優惠券狀態");
            dialog.setMessage("此優惠券已經結束");
            dialog.setPositiveButton(R.string.confirm,
                    new DialogInterface.OnClickListener(){
                        public void onClick(
                                DialogInterface dialoginterface, int i){
                            finish();
                        }
                    });
            dialog.show();
        }

        //錯誤優惠券訊息框
        if(vien.contains("error")){
            AlertDialog.Builder dialog = new AlertDialog.Builder(CouponActivity.this);
            dialog.setTitle("優惠券狀態");
            dialog.setMessage("系統錯誤");
            dialog.setPositiveButton(R.string.confirm,
                    new DialogInterface.OnClickListener(){
                        public void onClick(
                                DialogInterface dialoginterface, int i){
                            finish();
                        }
                    });
            dialog.show();
        }

        //可能優惠券訊息框
        if(vien.contains("maybe")){
            AlertDialog.Builder dialog = new AlertDialog.Builder(CouponActivity.this);
            dialog.setTitle("優惠券狀態");
            dialog.setMessage("請再操作一次!");
            dialog.setPositiveButton(R.string.confirm,
                    new DialogInterface.OnClickListener(){
                        public void onClick(
                                DialogInterface dialoginterface, int i){
                            finish();
                        }
                    });
            dialog.show();
        }

        //已經擁有優惠券訊息框
        if(vien.contains("kurikaesu")){
            AlertDialog.Builder dialog = new AlertDialog.Builder(CouponActivity.this);
            dialog.setTitle("優惠券狀態");
            dialog.setMessage("已經擁有此優惠券!");
            dialog.setPositiveButton(R.string.confirm,
                    new DialogInterface.OnClickListener(){
                        public void onClick(
                                DialogInterface dialoginterface, int i){
                            finish();
                        }
                    });
            dialog.show();
        }

        //傳值問題優惠券訊息框
        if(vien.contains("un_gi")){
            AlertDialog.Builder dialog = new AlertDialog.Builder(CouponActivity.this);
            dialog.setTitle("優惠券狀態");
            dialog.setMessage("系統錯誤!(傳值失敗)");
            dialog.setPositiveButton(R.string.confirm,
                    new DialogInterface.OnClickListener(){
                        public void onClick(
                                DialogInterface dialoginterface, int i){
                            finish();
                        }
                    });
            dialog.show();
        }

        //傳值問題優惠券訊息框
        if(vien.contains("un_u")){
            AlertDialog.Builder dialog = new AlertDialog.Builder(CouponActivity.this);
            dialog.setTitle("優惠券狀態");
            dialog.setMessage("系統錯誤!(無用戶資料)");
            dialog.setPositiveButton(R.string.confirm,
                    new DialogInterface.OnClickListener(){
                        public void onClick(
                                DialogInterface dialoginterface, int i){
                            finish();
                        }
                    });
            dialog.show();
        }

        //傳值問題優惠券訊息框
        if(vien.contains("un_p")){
            AlertDialog.Builder dialog = new AlertDialog.Builder(CouponActivity.this);
            dialog.setTitle("優惠券狀態");
            dialog.setMessage("系統錯誤!(無資料庫資料)");
            dialog.setPositiveButton(R.string.confirm,
                    new DialogInterface.OnClickListener(){
                        public void onClick(
                                DialogInterface dialoginterface, int i){
                            finish();
                        }
                    });
            dialog.show();
        }

        //資料庫連線問題優惠券訊息框
        if(vien.contains("un_k")){
            AlertDialog.Builder dialog = new AlertDialog.Builder(CouponActivity.this);
            dialog.setTitle("優惠券狀態");
            dialog.setMessage("系統錯誤!(資料庫連線失敗)");
            dialog.setPositiveButton(R.string.confirm,
                    new DialogInterface.OnClickListener(){
                        public void onClick(
                                DialogInterface dialoginterface, int i){
                            finish();
                        }
                    });
            dialog.show();
        }
    }


    public String is2String(InputStream is) {

        //连接后，创建一个输入流来读取response
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new
                    InputStreamReader(is, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String line = "";
        StringBuilder stringBuilder = new StringBuilder();
        String response = "";
        //每次读取一行，若非空则添加至 stringBuilder
        while (true) {
            try {
                if (!((line = bufferedReader.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            stringBuilder.append(line);
        }
        //读取所有的数据后，赋值给 response
        response = stringBuilder.toString().trim();
        return response;
    }
}