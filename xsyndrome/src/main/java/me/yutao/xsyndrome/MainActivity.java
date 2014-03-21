package me.yutao.xsyndrome;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends EntryActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public void onClickMenu1() {
		
	}

	@Override
	public void onClickMenu2() {
		Intent intent = new Intent(this, SubActivity.class);
		startActivity(intent);
	}

	@Override
	public void onClickMenu3() {

	}

	@Override
	public void onClickMenu4() {

	}
	
	
}
