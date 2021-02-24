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
                if(ShopHelpManager.isOpenAccessiblity(MainActivity.this)){
                    Log.e(TAG, "已经开启辅助模式");

                }else{
                    Log.e(TAG, "为开启辅助模式");
                    ShopHelpManager.startAccessiblity(MainActivity.this);
                }

            }
        });
    }
}
