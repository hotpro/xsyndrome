package me.yutao.xsyndrome;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 3/23/14
 */
@EActivity(R.layout.blood_sugar_activity)
public class BloodSugarActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    @ViewById
    RadioGroup type;
    @ViewById
    TextView result;
    @ViewById
    EditText kongfu_bs, suiji_bs;
    @ViewById
    TextView label_kongfu, label_suiji;
    @ViewById
    Button solution;

    @AfterViews
    void init() {
        type.setOnCheckedChangeListener(this);
        type.check(R.id.rb_kongfu_bs);
    }

    @Click
    void submit(View view) {
        StringBuilder sb = new StringBuilder();

        if (type.getCheckedRadioButtonId() == R.id.rb_kongfu_bs) {
            double bsKongfu= 0;
            try {
                bsKongfu = Double.parseDouble(kongfu_bs.getText().toString());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (bsKongfu > 7.0) {
                sb.append(getString(R.string.bs_diabetes));
            } else if (bsKongfu > 6.2) {
                sb.append(getString(R.string.bs_kongfu_bs_shousun));
            } else {
                sb.append(getString(R.string.bs_normal));
            }

            result.setText(sb.toString());
        } else if (type.getCheckedRadioButtonId() == R.id.rb_suiji_bs) {
            int bsSuiji = 0;
            try {
                bsSuiji= Integer.parseInt(suiji_bs.getText().toString());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (bsSuiji > 11.1) {
                sb.append(getString(R.string.bs_diabetes));
            } else if (bsSuiji > 7.8) {
                sb.append(getString(R.string.bs_nailing_yichang));
            } else {
                sb.append(getString(R.string.bs_normal));
            }
            result.setText(sb.toString());
        } else {

        }

        solution.setVisibility(View.VISIBLE);
    }

    @Click
    void solution() {
        showSolutionFragment(R.string.bs_advice);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (checkedId == R.id.rb_kongfu_bs) {

            label_kongfu.setVisibility(View.VISIBLE);
            kongfu_bs.setVisibility(View.VISIBLE);
            label_suiji.setVisibility(View.GONE);
            suiji_bs.setVisibility(View.GONE);

        } else if (checkedId == R.id.rb_suiji_bs) {

            label_kongfu.setVisibility(View.GONE);
            kongfu_bs.setVisibility(View.GONE);
            label_suiji.setVisibility(View.VISIBLE);
            suiji_bs.setVisibility(View.VISIBLE);
        }
    }
}
