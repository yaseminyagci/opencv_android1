package com.mathheals.opencv_android1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceView;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.JavaCameraView;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class MainActivity extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2 {
private static final String TAG ="MainActivity";



    JavaCameraView javacamera;
     Mat rdgba;



BaseLoaderCallback mLoaderCallBack=new BaseLoaderCallback(this) {
@Override
    public void onManagerConnected(int status){
switch(status){
    case BaseLoaderCallback.SUCCESS:{
        javacamera.enableView();
        break;

    }
    default:{

        super.onManagerConnected(status);
        break;
    }
}


}



};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    javacamera=(JavaCameraView)findViewById(R.id.camera);
        javacamera.setVisibility(SurfaceView.VISIBLE);
        javacamera.setCvCameraViewListener(this);


    }
    @Override
    protected void onPause(){
        super.onPause();
        if(javacamera!=null)
            javacamera.disableView();

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();;
        if(javacamera!=null)
            javacamera.disableView();

    }
    @Override
    protected void onResume(){
        super.onResume();;

            if (OpenCVLoader.initDebug()) {
                Log.i(TAG, "static initializer: okey oldıuuuu");
                mLoaderCallBack.onManagerConnected(LoaderCallbackInterface.SUCCESS);


            }else {
                Log.i(TAG, "static initializer: olmadııı yaaaa");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_2_4_2,this,mLoaderCallBack);
            }
    }

    @Override
    public void onCameraViewStarted(int width, int height) {
rdgba=new Mat(height,width, CvType.CV_8UC4);
    }

    @Override
    public void onCameraViewStopped() {
rdgba.release();
    }

    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
        rdgba=inputFrame.rgba();

        return rdgba;
    }
}
