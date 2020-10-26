package com.temp.ui.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import androidx.databinding.DataBindingUtil;
import com.temp.R;
import com.temp.consts.Global;
import com.temp.dao.PersonInfo;
import com.temp.databinding.ActySplashBinding;
import com.temp.tools.IntentTool;
import com.temp.tools.SPTool;

/**
 * 引导页
 */
public class SplashActivity extends BaseActivity {

    private static final String TAG = SplashActivity.class.getSimpleName();

    ActySplashBinding actySplashBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //去除title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //去掉Activity上面的状态栏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN , WindowManager.LayoutParams. FLAG_FULLSCREEN);

        actySplashBinding = DataBindingUtil.setContentView(this, R.layout.acty_splash);
        // 获取本地的用户信息
        checkPerson();
    }

    /**
     * 检查是否已经登录
     */
    private void checkPerson(){

        PersonInfo currentPerson = SPTool.getBeanWithKey(SPTool.Key.CURRENT_PERSON, PersonInfo.class);

        if(currentPerson != null){
            Log.e(TAG, currentPerson.nickName);
            Global.setCurrentPerson(currentPerson);
        }

        toTagetPage(MainActivity.class);

    }

    private void toTagetPage(Class<? extends Activity>  targetClass){
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                IntentTool.toActivity(SplashActivity.this, targetClass, true);
                finish();
            }
        }).start();

    }
}
