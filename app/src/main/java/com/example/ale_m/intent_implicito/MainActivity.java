package com.example.ale_m.intent_implicito;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
        case R.id.btn1:
            Intent it1= new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"));
            startActivity(it1);
            break;
        case R.id.btn2:
            Intent itc= new Intent(Intent.ACTION_CALL, Uri.parse("tel:8711250869"));
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                //TODO: Consider calling;
                return;
            }
            startActivity(itc);
            break;
    }

    }
}
