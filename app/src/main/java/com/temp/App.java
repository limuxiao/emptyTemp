package com.temp;

import androidx.multidex.MultiDexApplication;

import com.temp.tools.SPTool;

public class App extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }


    public void init(){
        SPTool.init(this);
    }

}
