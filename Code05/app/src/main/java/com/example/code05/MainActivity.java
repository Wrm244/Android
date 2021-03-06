package com.example.code05;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Boolean bPwdSwitch = false;
    private EditText etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView ivPwdSwitch = findViewById(R.id.iv_pwd_switch);
        etPwd = findViewById(R.id.et_pwd);

        //修改密码的显示与隐藏
        ivPwdSwitch.setOnClickListener(view -> {

            if (!bPwdSwitch) {
                ivPwdSwitch.setImageResource(
                        R.drawable.ic_baseline_visibility_off_24);
                etPwd.setInputType(
                        InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
            } else {
                ivPwdSwitch.setImageResource(
                        R.drawable.ic_baseline_visibility_24);
                etPwd.setInputType(
                        InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                etPwd.setTypeface(Typeface.DEFAULT);
            }
            bPwdSwitch = !bPwdSwitch;
        });


    }
}