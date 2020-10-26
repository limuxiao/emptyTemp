package com.temp.tools;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;

public class CommonTool {

    /**
     * 获取数组
     * @param activity
     * @param a
     * @return
     */
    public static ArrayList<String> getArray(Context activity, int a){
        ArrayList<String> lists = new ArrayList<>();
        lists.addAll(Arrays.asList(activity.getResources().getStringArray(a)));
        return lists;
    }

}
