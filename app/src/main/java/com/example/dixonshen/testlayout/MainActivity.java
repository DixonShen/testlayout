package com.example.dixonshen.testlayout;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String testJson = "";

    private static int CURRENT_DEPTH = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View imgView = findViewById(R.id.arrow);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfo(v);
            }
        });


        Map<String, Object> jsonMap = getMapFromJson(getJsonFromFile());


    }

    public void init() {

        final ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView1);

        final Button btn1 = new Button(this);
        btn1.setText("Get Json");
        scrollView.addView(btn1);
        final Map<String, Object> map = new HashMap<>();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.removeView(btn1);
                changePage(v, 1);
            }
        });

    }

    public void changePage(View v, int flag){

        if (flag == 1){
            this.CURRENT_DEPTH += 1;

            showInfo(v);
        } else {

        }
    }

    public void showInfo(View v){

        LinearLayout layout1 = (LinearLayout) findViewById(R.id.linearLayout1);

        LinearLayout linearLayout = (LinearLayout)getLayoutInflater().inflate(R.layout.text_view1, null);
        TextView attr = (TextView) linearLayout.findViewById(R.id.attr);
        attr.setText("RAM");
        TextView val = (TextView) linearLayout.findViewById(R.id.val);
        val.setText("2G");

        layout1.addView(linearLayout);

        LinearLayout linearLayout2 = (LinearLayout)getLayoutInflater().inflate(R.layout.text_view2, null);
        TextView attr2 = (TextView) linearLayout2.findViewById(R.id.attrs);
        attr2.setText("RAM");
        ImageView arrow = (ImageView) linearLayout2.findViewById(R.id.arrow);
        arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfo(v);
            }
        });

        layout1.addView(linearLayout2);

    }


    public Map<String, Object> getMapFromJson(String json) {
        Map<String, Object> result = new Gson().fromJson(json, new TypeToken<Map<String, Object>>(){}.getType());
        return result;
    }

    public String getJsonFromFile() {
        String resJson = "";
        try {
            AssetManager am = this.getAssets();
            InputStream file = am.open("json1.txt");
            InputStreamReader reader = new InputStreamReader(file);
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            while ((line = br.readLine()) != null) {
                resJson += line;
            }
            System.out.println(resJson);
            reader.close();
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (resJson.equals("")) return null;
            return resJson;
        }
    }

}
