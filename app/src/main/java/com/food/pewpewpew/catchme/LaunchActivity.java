package com.food.pewpewpew.catchme;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LaunchActivity extends AppCompatActivity {
    Button lead, follow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        lead = (Button) findViewById(R.id.btnLead);
        follow = (Button) findViewById(R.id.btnFollow);
       // setListener();
        final Toast t = Toast.makeText(this, "HALO", Toast.LENGTH_SHORT);
        lead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent i = new Intent("com.pewpewpew.saket.QRACTIVITY");
                    startActivity(i);
                }catch (Exception e){
                    t.show();
                }
            }
        });


        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent("com.google.zxing.client.android.SCAN");
                    startActivityForResult(intent, 0);

                }catch(Exception e){
                    t.show();
                }
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        if(requestCode == 0){
            if(resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                Toast.makeText(this, contents, Toast.LENGTH_SHORT).show();
            }
        }
    }

}
