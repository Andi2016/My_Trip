package com.android.andi.mytrip.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Andi Xu on 3/31/18.
 */

public class GetImageByUrl {

    private PicHandler pic_hdl;
    private ImageView imageView;
    private String url;

    public void setImage(ImageView imageView, String url){
        this.url = url;
        this.imageView = imageView;
        pic_hdl = new PicHandler();
        Thread t = new LoadPicThread();
        t.start();
    }


    class PicHandler extends Handler {

        @Override
        public void handleMessage(Message msg) {
            Bitmap myimg = (Bitmap) msg.obj;
            imageView.setImageBitmap(myimg);
        }
    }

    class LoadPicThread extends Thread {
        @Override
        public void run() {
            Bitmap img = getUrlImage(url);
            System.out.println(img + "---");
            Message msg = pic_hdl.obtainMessage();
            msg.what = 0;
            msg.obj = img;
            pic_hdl.sendMessage(msg);
        }
    }

    public Bitmap getUrlImage(String url) {
        Bitmap img = null;
        try {
            URL picurl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) picurl
                    .openConnection();
            conn.setConnectTimeout(6000);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.connect();
            InputStream is = conn.getInputStream();
            img = BitmapFactory.decodeStream(is);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return img;
    }

}
