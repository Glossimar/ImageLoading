package com.bignerdranch.android.imageloading;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private  ImageLoad imageLoad;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        android.os.Debug.waitForDebugger();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=(ImageView)findViewById(R.id.image);
        imageLoad=new ImageLoad();
        Log.d(TAG, "onCreate: ...................");
        try {
            Bitmap bitmap=imageLoad.getIamge("http://news-at.zhihu.com/api/4/start-image/1080*1776");
            Log.d(TAG, "onCreate: "+bitmap);
            imageView.setImageBitmap(bitmap);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
