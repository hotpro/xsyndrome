package me.yutao.xsyndrome;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

/**
 * Created with Android Studio
 * User: Chris.Hou
 * Date: 3/23/14
 */
@EFragment(R.layout.solution_fragment)
public class SolutionFragment extends Fragment {

    @ViewById
    TextView content;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @AfterViews
    void init() {
        int resId = getArguments().getInt("resId");
        content.setText(resId);
    }
}
