package com.sakusai.project8429;


import android.os.Bundle;
import android.os.Environment;
import android.text.format.Time;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Build;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.opencv.android.Utils;
import android.util.Log;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
//import org.opencv.highgui.Highgui;
//import org.opencv.highgui.VideoCapture;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.imgproc.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
//import com.example.app_opencv.*;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Time t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        InputStream is = this.getResources().openRawResource(R.mipmap.testb);
        Bitmap footbm = BitmapFactory.decodeStream(is);

        ImageView iv = (ImageView)findViewById(R.id.imageView);
//        iv.setImageBitmap(footbm);
//        Mat img = new Mat();
        Mat img = Imgcodecs.imread(getClass().getResource("/Test.jpg").getPath());
//        Utils.bitmapToMat(footbm, img);

        Size dsize = new Size(img.width(),img.height());
        Mat img2 = new Mat(dsize, CvType.CV_8SC1);
        Mat img3 = new Mat();

        img.convertTo(img2, CvType.CV_8SC1);

        Imgproc.Canny(img, img3, 123, 250);

        if(Imgcodecs.imwrite("/mnt/sdcard/new.jpg", img3)){
            File f = new File("/mnt/sdcard/new.jpg");
            if(f.exists()){
                Bitmap bm = BitmapFactory.decodeFile("/mnt/sdcard/new.jpg");
                //設置ImageView的顯示圖片
                iv.setImageBitmap(bm);
            }
        }

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
//測試測試
