package com.zk.demo;

import android.app.Application;

import com.pgyer.help_shop_library.ShopHelpManager;

/**
 * Created by liuqiang 2021-02-23 .
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new ShopHelpManager.InitSdk().setContext(this).build();
    }
}
