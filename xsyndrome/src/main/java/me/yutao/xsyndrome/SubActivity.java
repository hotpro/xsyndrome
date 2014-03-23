package me.yutao.xsyndrome;

import android.content.Intent;
import android.os.Bundle;

public class SubActivity extends EntryActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menu1.setText(getString(R.string.blood_pressure));
        menu2.setText(getString(R.string.fat));
        menu3.setText(getString(R.string.blood_sugar));
        menu4.setText(getString(R.string.blood_fat));
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
        Intent intent = new Intent(this, BloodSugarActivity_.class);
        startActivity(intent);
    }

    @Override
    public void onClickMenu4() {

        Intent intent = new Intent(this, BloodFatActivity_.class);
        startActivity(intent);
    }
}
