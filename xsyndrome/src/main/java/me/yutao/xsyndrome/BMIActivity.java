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
import android.widget.TextView;
import android.widget.Toast;

public class BMIActivity extends Activity {
	private static final String TAG = "Bmi";
    
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.v(TAG,"onCreate");
		setContentView(R.layout.bmi_layout);

		findViews();
		setListensers();
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
//		SharedPreferences settings = getSharedPreferences(PREF, 0);
//		Editor editor = settings.edit();
//		editor.putString(PREF_HEIGHT, field_height.getText().toString());
//		editor.commit();
		
//        settings.edit()
//            .putString(PREF_HEIGHT, field_height.getText().toString())
//            .commit();
		
		Pref.setHeight(this, field_height.getText().toString());
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

	private Button button_calc;
	private EditText field_height;
	private EditText field_weight;
	private TextView view_result;
	private TextView view_suggest;

	private void findViews() {
		if(Debug.On) Log.d(TAG, "find Views");
		button_calc = (Button) findViewById(R.id.submit);
	    field_height = (EditText) findViewById(R.id.height);
	    field_weight = (EditText) findViewById(R.id.weight);
	    view_result = (TextView) findViewById(R.id.result);
	    view_suggest = (TextView) findViewById(R.id.suggest);
	}

	// Restore preferences
    private void restorePrefs() {
//        SharedPreferences settings = getSharedPreferences(PREF, 0);
//        String pref_height = settings.getString(PREF_HEIGHT, "");
    	String pref_height = Pref.getHeight(this);
    	if(! "".equals(pref_height)) {
            field_height.setText(pref_height);
            field_weight.requestFocus();
        }
    }
    
	//Listen for button clicks
	private void setListensers() {
		if(Debug.On) Log.d(TAG, "set Listensers");
		button_calc.setOnClickListener(calcBMI);
	}
	
	private OnClickListener calcBMI = new OnClickListener() {
		public void onClick(View v) {
			DecimalFormat nf = new DecimalFormat("0.00");
			try {
				double height = Double
						.parseDouble(field_height.getText().toString()) / 100;
				double weight = Double
						.parseDouble(field_weight.getText().toString());
				double BMI = weight / (height * height);
	
				//Present result
				view_result.setText(getText(R.string.bmi_result) + nf.format(BMI));
	
				// Give health advice
				if (BMI > 25) {
					view_suggest.setText(R.string.advice_heavy);
				} else if (BMI < 20) {
					view_suggest.setText(R.string.advice_light);
				} else {
					view_suggest.setText(R.string.advice_average);
				}
				
			} catch(Exception err) {
				Log.e(TAG, "error: " + err.toString());
				Toast toast = Toast.makeText(BMIActivity.this, R.string.input_error, Toast.LENGTH_SHORT);
				toast.show();
			}
		}
	};

	
	protected static final int MENU_ABOUT = Menu.FIRST;
	protected static final int MENU_QUIT = Menu.FIRST+1;
}