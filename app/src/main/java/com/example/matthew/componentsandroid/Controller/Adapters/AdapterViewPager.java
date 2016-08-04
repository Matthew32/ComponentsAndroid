package com.example.matthew.componentsandroid.Controller.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.matthew.componentsandroid.View.FragmentCardView;
import com.example.matthew.componentsandroid.View.FragmentComponents;
import com.example.matthew.componentsandroid.View.FragmentDialogs;

import java.util.HashMap;

/**
 * Created by matthew on 03/08/2016.
 */
public class AdapterViewPager extends FragmentStatePagerAdapter {
    private HashMap<Integer, Fragment> cachedFragment;
    private String tabTitles[] = new String[]{"CardView", "Components", "Dialogs"};

    public AdapterViewPager(FragmentManager fm) {
        super(fm);
        if (cachedFragment == null) {
            setupFragment();
        }
    }

    private void setupFragment() {
        cachedFragment = new HashMap<>();
        cachedFragment.put(0, new FragmentCardView());
        cachedFragment.put(1, new FragmentComponents());
        cachedFragment.put(2, new FragmentDialogs());

    }

    @Override
    public Fragment getItem(int position) {
        return cachedFragment.get(position);
    }

    @Override
    public int getCount() {
        return cachedFragment.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
