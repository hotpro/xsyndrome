package me.yutao.xsyndrome;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 3/23/14
 */
@EActivity(R.layout.blood_fat_activity)
public class BloodFatActivity extends BaseActivity {

    @ViewById
    EditText bf_zongdanguchun, bf_sanxianganyou, bf_ldc;

    @ViewById
    TextView result;

    @ViewById
    Button solution;

    @Click
    void submit(View view) {
        StringBuilder sb = new StringBuilder();
        double valuezongdanguchun = 0;
        try {
            valuezongdanguchun = Double.parseDouble(bf_zongdanguchun.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        double valuesanxianganyou = 0;
        try {
            valuesanxianganyou = Double.parseDouble(bf_sanxianganyou.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        double valueldc = 0;
        try {
            valueldc = Double.parseDouble(bf_ldc.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if (valuezongdanguchun > 5.17) {
            sb.append(getString(R.string.bf_gaodanguchun)).append('，');
        }
        if (valuesanxianganyou > 2.3) {
            sb.append(getString(R.string.bf_gaosanxianganyou)).append('，');
        }
        if (valueldc > 3.37) {
            sb.append(getString(R.string.bf_zhidanbai)).append('，');
        }

        sb.append("谢谢。");
        result.setText(sb.toString());

        solution.setVisibility(View.VISIBLE);
    }

    @Click
    void solution() {
        showSolutionFragment(R.string.bf_advice);
    }
}
