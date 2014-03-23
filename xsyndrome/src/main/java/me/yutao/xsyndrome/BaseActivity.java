package me.yutao.xsyndrome;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

public class BaseActivity extends Activity {

    public void showSolutionFragment(int resId) {
        Fragment fragment = new SolutionFragment_();
        Bundle bundle = new Bundle();
        bundle.putInt("resId", resId);
        fragment.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .add(android.R.id.content, fragment, SolutionFragment_.class.getSimpleName())
                .addToBackStack(SolutionFragment_.class.getSimpleName())
                .commitAllowingStateLoss();

    }
}
