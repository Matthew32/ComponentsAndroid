package com.example.matthew.componentsandroid.View;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import com.example.matthew.componentsandroid.R;
import com.example.matthew.componentsandroid.View.ViewUtils.StyledDialog;

import java.util.Calendar;

/**
 * Created by matthew on 04/08/2016.
 */
public class FragmentDialogs extends Fragment implements View.OnClickListener {
    private View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_dialog, container, false);
        setResources();
        setResourcesFormat();
        setResourcesEvents();
        return v;
    }

    private void setResourcesEvents() {
        btn_styled.setOnClickListener(this);
        btn_yon.setOnClickListener(this);
        btn_Date.setOnClickListener(this);
        btn_makeBar.setOnClickListener(this);
    }

    private void setResourcesFormat() {

    }

    private void setResources() {
        btn_Date = (Button) v.findViewById(R.id.fd_btn_date);
        btn_yon = (Button) v.findViewById(R.id.fd_btn_dyn);
        btn_styled = (Button) v.findViewById(R.id.fd_btn_styled);
        btn_makeBar = (Button) v.findViewById(R.id.fd_btn_snack_bar);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fd_btn_date:
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dpd = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                            }
                        }, mYear, mMonth, mDay);
                dpd.show();
                break;
            case R.id.fd_btn_dyn:
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(getActivity(), R.style.AppCompatAlertDialogStyle);
                builder.setTitle("Dialog");
                builder.setMessage("\"At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.\"");
                builder.setPositiveButton("OK", null);
                builder.setNegativeButton("Cancel", null);
                builder.show();
                break;
            case R.id.fd_btn_styled:
                StyledDialog dialog = new StyledDialog();
                dialog.show(getFragmentManager(), "");
                break;
            case R.id.fd_btn_snack_bar:

                CoordinatorLayout coordinator = new CoordinatorLayout(getActivity());
                Snackbar snackbar = Snackbar
                        .make(coordinator, "I'm a SnackBar it's a pleasure user", Snackbar.LENGTH_LONG);


                snackbar.show();
                break;
        }
    }

    private Button btn_yon;
    private Button btn_styled;
    private Button btn_makeBar;
    private Button btn_Date;
}
