package com.temp.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.google.gson.GsonBuilder;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class SPTool{

    public static final String TAG = SPTool.class.getSimpleName();

    private static Context context;

    public static final String NORMAL_SAVE_NAME = "tempPreferences";


    private static final Long ID_NULL = -10001L;

    public static void init(Context mContext) {
        context = mContext;
    }

    /**
     *
     * @param key
     * @param value
     */
    public static void saveInfoWithKey(String key, String value){
        saveInfoWithKey(key, value, ID_NULL);
    }


    /**
     * 根据key-value保存
     *
     * @param key
     * @param value
     */
    public static void saveInfoWithKey(String key, String value, Long personId) {
        SharedPreferences sp = context.getSharedPreferences(NORMAL_SAVE_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(joinKey(key, personId), value);
        editor.commit();
    }

    /**
     *
     * @param key
     * @return
     */
    public static String getInfoByKey(String key){
        return getInfoByKey(key, ID_NULL);
    }

    /**
     * 根据key取出保存的value
     *
     * @param key
     * @return
     */
    public static String getInfoByKey(String key, Long personId) {
        SharedPreferences sp = context.getSharedPreferences(NORMAL_SAVE_NAME, Context.MODE_PRIVATE);
        return sp.getString(joinKey(key, personId), null);
    }

    /**
     *
     * @param key
     */
    public static void removeInfoWithKey(String key){
        removeInfoWithKey(key, ID_NULL);
    }

    /**
     *
     * @param key
     * @param personId
     */
    public static void removeInfoWithKey(String key, Long personId) {
        SharedPreferences sp = context.getSharedPreferences(NORMAL_SAVE_NAME, Context.MODE_PRIVATE);
        sp.edit().remove(joinKey(key, personId)).commit();
    }

    /**
     *
     * @param key
     * @param obj
     */
    public static void saveBeanWithKey(String key, Object obj){
        saveBeanWithKey(key, obj, ID_NULL);
    }

    /**
     * 根据key-obj保存
     *
     * @param key
     * @param obj
     */
    public static void saveBeanWithKey(String key, Object obj, Long personId) {
        try {
            saveInfoWithKey(key, new GsonBuilder().create().toJson(obj), personId);
        } catch (Exception e) {

        }

    }

    /**
     *
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getBeanWithKey(String key, Class<T> clazz){
        return getBeanWithKey(key, clazz, ID_NULL);
    }

    /**
     * @param key
     * @param clazz
     * @return
     */
    public static <T> T getBeanWithKey(String key, Class<T> clazz, Long personId) {
        String str = getInfoByKey(key, personId);
        if (str == null) return null;
        return (T) new GsonBuilder().create().fromJson(str, clazz);
    }

    /**
     *
     * @param key
     */
    public static void removeBeanWithKey(String key){
        removeInfoWithKey(key, ID_NULL);
    }


  /**
  * @param key
  */
    public static void removeBeanWithKey(String key, Long personId) {
        removeInfoWithKey(key, personId);
    }


    private static String joinKey(String key, Long personId) {
        return key + personId;
    }

    public final class Key {

        // 当前用户
        public static final String CURRENT_PERSON = "CURRENT_PERSON";

    }


}