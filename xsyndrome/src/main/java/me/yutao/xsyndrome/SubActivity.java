package me.yutao.xsyndrome;

import android.content.Intent;
import android.os.Bundle;

public class SubActivity extends EntryActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		menu1.setText("血压");
		menu2.setText("肥胖");
		menu3.setText("血糖");
		menu4.setText("血脂");
	}

	@Override
	public void onClickMenu1() {
        Intent intent = new Intent(this, BloodPressureActivity_.class);
        startActivity(intent);
		
	}

	@Override
	public void onClickMenu2() {
		Intent intent = new Intent(this, BMIActivity_.class);
		startActivity(intent);
	}

	@Override
	public void onClickMenu3() {

	}

	@Override
	public void onClickMenu4() {

	}
}
