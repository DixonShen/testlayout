package com.example.dixonshen.testlayout;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout1 = new LinearLayout(this);
        LinearLayout.LayoutParams llLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        TextView attr = new TextView(this);
        attr.setText("RAM");
        if (Build.VERSION.SDK_INT >= 23) {
            attr.setTextAppearance(R.style.attr_text);
        } else {
            attr.setTextAppearance(this, R.style.attr_text);
        }
        linearLayout1.addView(attr);
        TextView val = new TextView(this);
        val.setText("2G");
        if (Build.VERSION.SDK_INT >= 23) {
            val.setTextAppearance(R.style.val_text);
        } else {
            val.setTextAppearance(this, R.style.val_text);
        }
        linearLayout1.addView(val);
        LinearLayout layout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        layout1.addView(linearLayout1, llLayoutParams);
    }

    public Map<String, Object> getMapFromJson(String json) {
        Map<String, Object> result = new Gson().fromJson(json, new TypeToken<Map<String, Object>>(){}.getType());
        return result;
    }
}
