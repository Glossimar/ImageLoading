package com.bignerdranch.android.imageloading;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by LENOVO on 2017/4/4.
 */

public class ImageLoad {

    public Bitmap getIamge(String  imgAddress) throws Exception{
        URL url=new URL(imgAddress);
        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(8000);
        ByteArrayOutputStream bos =new ByteArrayOutputStream();
        try{

            InputStream is=connection.getInputStream();
            byte [] buffer=new byte[1024];
            int len=is.read(buffer);
            while(len!=-1){
                bos.write(buffer,0,len);
            }
            is.close();
            bos.flush();
        }catch (Exception e){
            e.printStackTrace();
        }
        byte [] imageBytes =bos.toByteArray();
        Bitmap bitmap= BitmapFactory.decodeByteArray(imageBytes,0,imageBytes.length);
        return bitmap;
    }

}
