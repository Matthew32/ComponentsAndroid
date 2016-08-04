package com.example.matthew.componentsandroid.View;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matthew.componentsandroid.R;

/**
 * Created by matthew on 04/08/2016.
 */
public class FragmentComponents extends Fragment {
    private View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_components, container, false);
        return v;
    }
}
