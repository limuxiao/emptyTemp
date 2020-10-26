package com.temp.ui.activitys;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.temp.adapters.ViewPagerHomeAdapter;
import com.temp.tools.CommonTool;

import java.util.HashMap;
import java.util.List;

import com.temp.R;
import com.temp.databinding.ActyMainBinding;


public class MainActivity extends BaseActivity {


    ActyMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.acty_main);
        initMenu();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    private void initMenu(){
        joinViewPager();
        joinMenu();
    }

    public void joinMenu() {
        List<String> menus = CommonTool.getArray(this,R.array.bottom_menu_title);
        TypedArray ar = getApplicationContext().getResources().obtainTypedArray(R.array.bottom_menu_icon);

        Menu menu = mainBinding.mainBottom.getMenu();

        for (int i = 0; i < menus.size(); i++) {
            menu.add(1, i, i, menus.get(i));
            MenuItem item = menu.findItem(i);
            item.setIcon(ar.getDrawable(i));
        }

        mainBinding.mainBottom.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case 0:
                        mainBinding.mainViewpage.setCurrentItem(0);
                        break;
                    case 1:
                        mainBinding.mainViewpage.setCurrentItem(1);
                        break;
                    case 2:
                        mainBinding.mainViewpage.setCurrentItem(2);
                        break;
                    case 3:
                        mainBinding.mainViewpage.setCurrentItem(3);
                        break;
                    case 4:
                        mainBinding.mainViewpage.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }


    public void joinViewPager() {
        ViewPagerHomeAdapter adapter = new ViewPagerHomeAdapter(getSupportFragmentManager());
        mainBinding.mainViewpage.setAdapter(adapter);
        mainBinding.mainViewpage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                mainBinding.mainBottom.setSelectedItemId(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });
    }

}
