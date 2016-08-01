package com.example.matthew.componentsandroid.View.ViewUtils;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by matthew on 01/08/2016.
 */


public class DrawerClick implements ListView.OnItemClickListener {
    private IntentsProvider provider;

    public DrawerClick(IntentsProvider intents) {
        this.provider = intents;
    }

    public DrawerClick() {
    }

    @Override
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        selectItem(position);
    }


    /**
     * Swaps fragments in the main content view
     */
    private void selectItem(int position) {
    provider.switchMenuFragment(position);
    }
}
