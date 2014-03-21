package me.yutao.xsyndrome;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class EntryActivity extends BaseActivity implements OnClickListener {

	TextView menu1;
	TextView menu2;
	TextView menu3;
	TextView menu4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		init();
		getView();
		setListener();
	}

	@Override
	public void init() {

	}

	@Override
	public void getView() {
		menu1 = (TextView)findViewById(R.id.menu1);
		menu2 = (TextView)findViewById(R.id.menu2);
		menu3 = (TextView)findViewById(R.id.menu3);
		menu4 = (TextView)findViewById(R.id.menu4);
	}

	@Override
	public void setListener() {
		menu1.setOnClickListener(this);
		menu2.setOnClickListener(this);
		menu3.setOnClickListener(this);
		menu4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.menu1:
			onClickMenu1();
			break;

		case R.id.menu2:
			onClickMenu2();
			break;
			
		case R.id.menu3:
			onClickMenu3();
			break;
			
		case R.id.menu4:
			onClickMenu4();
			break;

		default:
			break;
		}
	}

	public void onClickMenu1() {

	}

	public void onClickMenu2() {

	}

	public void onClickMenu3() {

	}

	public void onClickMenu4() {

	}

}
