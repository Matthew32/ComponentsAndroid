package com.example.matthew.componentsandroid.View.ViewUtils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matthew.componentsandroid.R;

/**
 * Created by matthew on 04/08/2016.
 */
public class StyledDialog extends AppCompatDialogFragment {
    private View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.dialog_fragment, container, false);
        getDialog().setTitle("Custom Dialog");
        return v;
    }
}
