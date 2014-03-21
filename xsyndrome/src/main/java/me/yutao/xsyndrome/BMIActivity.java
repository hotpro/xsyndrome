package me.yutao.xsyndrome;

import java.text.DecimalFormat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.bmi_layout)
public class BMIActivity extends Activity {
	private static final String TAG = "Bmi";
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	protected void onDestroy() {
		
		super.onDestroy();
		Log.v(TAG,"onDestroy");
	}

	@Override
	protected void onPause() {
		
		super.onPause();
		Log.v(TAG,"onPause");
		
		Pref.setHeight(this, height.getText().toString());
	}

	@Override
	protected void onRestart() {
		
		super.onRestart();
		Log.v(TAG,"onReStart");
	}

	@Override
	protected void onResume() {
		
		super.onResume();
		Log.v(TAG,"onResume");
		restorePrefs();
	}

	@Override
	protected void onStart() {
		
		super.onStart();
		Log.v(TAG,"onStart");
	}

	@Override
	protected void onStop() {
		
		super.onStop();
		Log.v(TAG,"onStop");
	}

    @ViewById
	Button submit;

    @ViewById
	EditText height, weight, waist;

    @ViewById
	TextView result, suggest;

    @ViewById
    RadioGroup gender;

	// Restore preferences
    private void restorePrefs() {
    	String pref_height = Pref.getHeight(this);
    	if(! "".equals(pref_height)) {
            height.setText(pref_height);
            weight.requestFocus();
        }
    }

    @Click
    void submit(View view) {
        DecimalFormat nf = new DecimalFormat("0.00");
        try {
            double height = Double
                    .parseDouble(this.height.getText().toString()) / 100;
            double weight = Double
                    .parseDouble(this.weight.getText().toString());
            double BMI = weight / (height * height);

            //Present result
            result.setText(getText(R.string.bmi_result) + nf.format(BMI));

            StringBuilder sb = new StringBuilder();
            // Give health advice
            if (BMI > 25) {
                sb.append(getString(R.string.advice_heavy));
            } else if (BMI < 20) {
                sb.append(getString(R.string.advice_light));
            } else {
                sb.append(getString(R.string.advice_average));
            }

            int w = Integer.parseInt(this.waist.getText().toString());
            switch (gender.getCheckedRadioButtonId()) {
                case  R.id.male:
                    if (w > 90) {
                        sb.append(getString(R.string.bmi_waist_heavy));
                    }
                    break;
                case R.id.female:
                    if (w > 80) {
                        sb.append(getString(R.string.bmi_waist_heavy));
                    }
                    break;
            }

            suggest.setText(sb.toString());


        } catch(Exception err) {
            Log.e(TAG, "error: " + err.toString());
            Toast toast = Toast.makeText(BMIActivity.this, R.string.input_error, Toast.LENGTH_SHORT);
            toast.show();
        }
    }

	protected static final int MENU_ABOUT = Menu.FIRST;
	protected static final int MENU_QUIT = Menu.FIRST+1;
}