package com.temp.ui.activitys;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;

import com.temp.R;
import com.temp.databinding.ActyLoginBinding;

public class LoginActivity extends BaseActivity {


    ActyLoginBinding loginBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this, R.layout.acty_login);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
