package com.food.pewpewpew.catchme;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.content.ClipboardManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.net.URLEncoder;

public class QrActivity extends AppCompatActivity {
    ImageLoader imgLoad;
    ImageView imgQR;
    String lol;

    String BASE_URL = "http://chart.apis.google.com/chart?cht=qr&chs=400x400&chld=M&choe=UTF-8&chl=";
    String compURL = BASE_URL;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this).build();
        imgLoad = ImageLoader.getInstance();
        imgLoad.init(config);
        imgQR = (ImageView) findViewById(R.id.QRcode);
        pb = (ProgressBar) findViewById(R.id.prgBar);
        pb.setVisibility(View.GONE);
        Toast picError = Toast.makeText(this, "URL error", Toast.LENGTH_SHORT);
        lol = new String("SAKET");
        try {
            pb.setVisibility(View.VISIBLE);
            compURL += URLEncoder.encode(lol, "UTF-8");
            imgLoad.displayImage(compURL, imgQR);
        }catch(Exception e){
            picError.show();
        }


    }
}
