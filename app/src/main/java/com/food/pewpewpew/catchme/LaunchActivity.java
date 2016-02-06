package com.food.pewpewpew.catchme;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class LaunchActivity extends AppCompatActivity {
    Button lead, follow;

    ParseQuery<ParseObject> query;
    TextView tv;
    String text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        //tv = (TextView) findViewById(R.id.tv);

        final ProgressDialog pgDialog = new ProgressDialog(LaunchActivity.this);
        pgDialog.setMessage("Getting Data.");
        pgDialog.show();
        query = ParseQuery.getQuery("testTable");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {

                pgDialog.hide();
                //tv.setText(objects.get(0).getString("sex"));
                //text = objects.get(0).getString("UserID");
                objects.get(0).put("UserID", 12345);
                objects.get(0).put("Lat", 15);
                objects.get(0).put("Long", 20);
                objects.get(0).saveInBackground();
                objects.get(1).put("UserID", 12346);
                objects.get(1).put("Lat", 35);
                objects.get(1).put("Long", 45);
                objects.get(1).saveInBackground();
            }
        });
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
