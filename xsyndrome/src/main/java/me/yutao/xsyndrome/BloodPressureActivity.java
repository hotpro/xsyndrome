package me.yutao.xsyndrome;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.blood_pressure_activity)
public class BloodPressureActivity extends BaseActivity {

    @ViewById
    TextView systolic, diastolic, result, suggest;

    @ViewById
    Button submit, solution;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Click
    void submit(View view) {

        int bpSystolic = 0;
        try {
            bpSystolic = Integer.parseInt(systolic.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        int bpDiastolic = 0;
        try {
            bpDiastolic = Integer.parseInt(diastolic.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (bpSystolic < 120 && bpDiastolic < 80) {
            result.setText(R.string.bp_normal);
        } else if (bpSystolic >= 180 || bpDiastolic >= 110) {
            result.setText(R.string.bp_high_level_3);
        } else if (bpSystolic >= 160 || bpDiastolic >= 100) {
            result.setText(R.string.bp_high_level_2);
        } else if (bpSystolic >= 140 || bpDiastolic >= 90) {
            result.setText(R.string.bp_high_level_1);
        } else if (bpSystolic >= 120 || bpDiastolic >= 80) {
            result.setText(R.string.bp_high_normal);
        }
        solution.setVisibility(View.VISIBLE);
    }

    @Click
    void solution() {
        showSolutionFragment(R.string.bp_advice);
    }

}
