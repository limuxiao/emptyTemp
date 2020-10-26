package com.temp.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.temp.ui.fragments.HomeFragment;
import com.temp.ui.fragments.MyFragment;
import com.temp.ui.fragments.RecommendFragment;
import com.temp.ui.fragments.ShopCartFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/23.
 * 首页viewPage适配
 */

public class ViewPagerHomeAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments =  new ArrayList<>();

    public ViewPagerHomeAdapter(FragmentManager fm) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        fragments.clear();
        fragments.add(new HomeFragment());
        fragments.add(new RecommendFragment());
        fragments.add(new ShopCartFragment());
        fragments.add(new MyFragment());
    }

    @Override
    public Fragment getItem(int pos) {
        return fragments.get(pos);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
