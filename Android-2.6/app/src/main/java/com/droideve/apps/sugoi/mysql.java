package com.droideve.apps.sugoi;


import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import com.droideve.apps.sugoi.Scan_Qr.*;
import com.droideve.apps.sugoi.classes.User;
import com.github.mikephil.charting.data.BarEntry;

public class mysql {
    String mysql_ip = "163.30.84.23";
    int mysql_port = 3306; // Port 預設為 3306
    String db_name = "im_final_db";
    String url = "jdbc:mysql://"+mysql_ip+":"+mysql_port+"/"+db_name;
    String db_user = "yuang";
    String db_password = "123456";

    public void run() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Log.v("DB", "加載驅動成功");
        }//try()
        catch (ClassNotFoundException e) {
            Log.e("DB", "加載驅動失敗");
            return;
        }//catch()


        try {
            Connection con = DriverManager.getConnection(url, db_user, db_password);
            Log.v("DB", "遠端連接成功");
        }//try()
        catch (SQLException e) {
            Log.e("DB", "遠端連接失敗");
            Log.e("DB", e.toString());
        }//catch()
    }//run()


    public String getData() {
        String data = "";
        try {
            Connection con = DriverManager.getConnection(url, db_user, db_password);
            String sql = "SELECT * FROM country";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next())
            {
                String id = rs.getString("Code");
                String name = rs.getString("Name");
                //String continent = rs.getString(" Continent");
                String region = rs.getString("Region");
                data = id + ", " + name + ","  + region + "\n";
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }



    public JSONArray get_user_coupon_Data(Context context) {
        JSONArray a_array = new JSONArray();


        SharedPreferences sharedPreferences2 = context.getSharedPreferences("peter_jeremy641_shiyuan2", Context.MODE_PRIVATE);
        String UserID = sharedPreferences2.getString("userid","未存任何資料");




        try {
            Connection con = DriverManager.getConnection(url, db_user, db_password);
            String sql = "SELECT a.id, a.info_id, a.coupon_number, a.user_id, a.Randamu_number, a.get_dt, a.use_TF,b.store_id, b.label, b.description, b.value, b.parent_id, b._order, b.option_type, b.hidden, b.updated_at, b.created_at, b.parsed_quantity, b.Sold_out, b.time_post_start, b.time_post_end, b.time_use_end, b.parsed_time, b.value_variety, c.id_store, c.name \n" +
                    "FROM coupon_baggu AS a,service AS b,store AS c \n" +
                    "WHERE(a.info_id=b.id)AND(a.user_id=?)AND(b.store_id=c.id_store);";
            //Statement st = con.createStatement();
            //ResultSet rs = st.executeQuery(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,UserID);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                JSONObject a_object = new JSONObject();

                a_object.put("id",rs.getString("id"));
                a_object.put("info_id",rs.getString("info_id"));
                a_object.put("coupon_number",rs.getString("coupon_number"));
                a_object.put("user_id",rs.getString("user_id"));
                a_object.put("Randamu_number",rs.getString("Randamu_number"));
                a_object.put("get_dt",rs.getString("get_dt"));
                a_object.put("use_TF",rs.getString("use_TF"));
                a_object.put("store_id",rs.getString("store_id"));
                a_object.put("label",rs.getString("label"));
                a_object.put("description",rs.getString("description"));
                a_object.put("value",rs.getString("value"));
                a_object.put("parent_id",rs.getString("parent_id"));
                a_object.put("_order",rs.getString("_order"));
                a_object.put("option_type",rs.getString("option_type"));
                a_object.put("hidden",rs.getString("hidden"));
                a_object.put("updated_at",rs.getString("updated_at"));
                a_object.put("created_at",rs.getString("created_at"));
                a_object.put("parsed_quantity",rs.getString("parsed_quantity"));
                a_object.put("Sold_out",rs.getString("Sold_out"));
                a_object.put("time_post_start",rs.getString("time_post_start"));
                a_object.put("time_post_end",rs.getString("time_post_end"));
                a_object.put("time_use_end",rs.getString("time_use_end"));
                a_object.put("parsed_time",rs.getString("parsed_time"));
                a_object.put("value_variety",rs.getString("value_variety"));
                a_object.put("name", rs.getString("name"));
                a_array.put(a_object);


            }
            //st.close();
             rs.close();
             ps.close();
             con.close();


        } catch (SQLException | JSONException e) {
            e.printStackTrace();

        }

        return  a_array;
    }

    public JSONArray get_user_chart_Data(Context context) {
        JSONArray a_array = new JSONArray();


        SharedPreferences sharedPreferences2 = context.getSharedPreferences("peter_jeremy641_shiyuan2", Context.MODE_PRIVATE);
        String UserID = sharedPreferences2.getString("userid","未存任何資料");




        try {
            Connection con = DriverManager.getConnection(url, db_user, db_password);
            String sql = "SELECT * FROM store WHERE user_id=?;";
            //Statement st = con.createStatement();
            //ResultSet rs = st.executeQuery(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,UserID);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                JSONObject a_object = new JSONObject();
                a_object.put("user_id",rs.getString("user_id"));
                a_object.put("id_store",rs.getString("id_store"));
                a_object.put("name", rs.getString("name"));
                a_array.put(a_object);


            }
            //st.close();
            rs.close();
            ps.close();
            con.close();


        } catch (SQLException | JSONException e) {
            e.printStackTrace();

        }

        return  a_array;
    }

    public getChartLabel getChartData(String store_id,String t_year,String t_month){
        JSONArray b_array = new JSONArray();
        getChartLabel getChartLabel = null;


        try {
            Connection con = DriverManager.getConnection(url, db_user, db_password);
            String sql = "SELECT p_info_id,count(id) AS count_id,label \n" +
                         "FROM coupon_analysis_view \n" +
                         "WHERE (YEAR(record_time)=?)AND(store_id=?)AND((Month(record_time)=?))\n" +
                         "GROUP BY p_info_id";
            //Statement st = con.createStatement();
            //ResultSet rs = st.executeQuery(sql);
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,t_year);
            ps.setString(2,store_id);
            ps.setString(3,t_month);
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                JSONObject a_object = new JSONObject();
                a_object.put("p_info_id",rs.getString("p_info_id"));
                a_object.put("count_id",rs.getString("count_id"));
                a_object.put("label",rs.getString("label"));
                b_array.put(a_object);


            }
            ArrayList<BarEntry> barEntries = new ArrayList<>();
            ArrayList<String> barLabel = new ArrayList<>();
            for(int i = 0;i < b_array.length(); i++){

                JSONObject job = b_array.getJSONObject(i);

                barEntries.add(new BarEntry( (float)i,Float.parseFloat(job.getString("count_id") ) ));
                barLabel.add(job.getString("label"));


            }//for()
            //st.close();
            rs.close();
            ps.close();
            con.close();

            getChartLabel = new getChartLabel(barEntries,barLabel);



        } catch (SQLException | JSONException e) {
            e.printStackTrace();

        }
        return getChartLabel;
    }

    public class getChartLabel {

        private ArrayList<BarEntry> barEntries;
        private ArrayList<String> barLabel;




        public getChartLabel(ArrayList<BarEntry> barEntries, ArrayList<String> barLabel){
            this.barEntries = barEntries;
            this.barLabel = barLabel;

        }

        public ArrayList<BarEntry> getBarEntries() {
            return this.barEntries=barEntries;
        }

        public ArrayList<String> getBarLabel() {
            return this.barLabel=barLabel;
        }
    }

    public  int  db_update(Context context,String p_id,String p_user_id){

        /*SharedPreferences sharedPreferences2 = context.getSharedPreferences("peter_jeremy641_shiyuan2", Context.MODE_PRIVATE);
        String UserID = sharedPreferences2.getString("userid","未存任何資料");
        Log.v("jeremy641", UserID);*/
        try {
            Connection con = DriverManager.getConnection(url, db_user, db_password);
            String sql = "UPDATE coupon_baggu  SET use_TF = '1' WHERE (id = ?) AND (user_id =?);";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p_id);
            ps.setString(2, p_user_id);
            Log.v("p_id","GGGG========"+p_id);
            Log.v("p_user_id","FFFF========"+p_user_id);
            //Log.v(" ps","UUUU=========="+ps.toString());
            //Log.v(" temp","CCCC=========="+Scan_Qr.temp);
            //Log.v(" UserID","DDDD=========="+UserID);
            int updateValue = ps.executeUpdate();
            if(updateValue>0){
                sql = "INSERT INTO coupon_analysis(`id`, `record_time`) VALUES (?,now());";
                ps = con.prepareStatement(sql);
                ps.setString(1, p_id);
                ps.executeUpdate();
            }
            return updateValue;
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }


    }



}//mysql
