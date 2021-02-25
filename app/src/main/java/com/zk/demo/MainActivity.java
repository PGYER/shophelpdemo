package com.zk.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.pgyer.help_shop_library.ShopHelpManager;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ShopHelpManager.isOpenAccessiblity(MainActivity.this)) {
                    Log.e(TAG, "�Ѿ���������ģʽ");

                } else {
                    Log.e(TAG, "Ϊ��������ģʽ");
                    ShopHelpManager.startAccessiblity(MainActivity.this);
                }

            }
        });
        findViewById(R.id.tv_open_course).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShopHelpManager.startAccessiblityByCourse(MainActivity.this);
            }
        });
    }
}
