package com.example.matthew.componentsandroid.View.ViewUtils;

import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.matthew.componentsandroid.R;
import com.example.matthew.componentsandroid.View.FragmentListVIew;

/**
 * Created by matthew on 01/08/2016.
 */
public class IntentsProvider {
    private FragmentManager ft;
    private Activity activity;

    public IntentsProvider(FragmentManager ft, Activity activity) {
        this.ft = ft;
        this.activity = activity;
    }

    public IntentsProvider() {
    }

    public void switchMenuFragment(int position) {
        //ListView
        switch (position) {
            case 0:
                openListView();
                break;
        }
    }

    private FragmentTransaction beginTransaction() {
        return ft.beginTransaction();
    }

    private void endTransaction(FragmentTransaction trans) {

        trans.commitAllowingStateLoss();
    }

    private void openListView() {
        FragmentTransaction trans = beginTransaction();
        FragmentListVIew frLv = new FragmentListVIew();
        trans.replace(R.id.main_content, frLv);
        endTransaction(trans);
    }


    public Activity getActivity() {
        return activity;
    }
}
