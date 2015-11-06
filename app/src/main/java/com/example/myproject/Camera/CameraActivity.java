package com.example.myproject.Camera;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.myproject.R;

/**
 * Created by student on 2015-11-06.
 */
public class CameraActivity extends AppCompatActivity {

    private Camera mCamera;
    private CameraPreview mCameraPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (!checkCameraHardware(this)) {
            Toast.makeText(CameraActivity.this, "카메라 없음", Toast.LENGTH_SHORT).show();
            finish();
        }
        setContentView(R.layout.activity_camera);

        // 카메라 인스턴스 얻기기
       mCamera = getCameraInstance();
        // 카메라를 프리뷰를 보여줄 SurfaceView 상속한 View
        mCameraPreview = new CameraPreview(this, mCamera);

        //동적으로 view를 추가
        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.surface_view);
        frameLayout.addView(mCameraPreview);
    }

    /** Check if this device has a camera */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }

    /** A safe way to get an instance of the Camera object. */
    public static Camera getCameraInstance(){
        Camera c = null;
        try {

            c = Camera.open(); // attempt to get a Camera instance
        }
        catch (Exception e){
            // Camera is not available (in use or does not exist)
        }
        return c; // returns null if camera is unavailable
    }
}
