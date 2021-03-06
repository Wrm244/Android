package com.example.code02;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int count = 0;
    TextView tvCount;
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d("onRestoreInstanceState","onRestoreInstanceStateStart");
        //这里如果不是强制退出的，就会自动运行
        super.onRestoreInstanceState(savedInstanceState);
        count=savedInstanceState.getInt(COUNT_VALUE);
        if(tvCount!=null){
            tvCount.setText(Integer.toString(count));
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnShowToast = findViewById(R.id.btnShowToast);
        btnShowToast.setOnClickListener(view ->
                Toast.makeText(MainActivity.this,"Hello Word",Toast.LENGTH_SHORT).show());
        tvCount = findViewById(R.id.tvCount);
        Button btnCount = findViewById(R.id.btnCount);
        btnCount.setOnClickListener(view ->
                tvCount.setText(Integer.toString(++count)));

    }
    private static final String COUNT_VALUE = "count_value";
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("onRestoreInstanceState","onSaveInstanceStateStart");
        outState.putInt(COUNT_VALUE,count);
        super.onSaveInstanceState(outState);
    }

}