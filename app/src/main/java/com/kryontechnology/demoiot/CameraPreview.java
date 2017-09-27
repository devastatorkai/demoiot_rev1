package com.kryontechnology.demoiot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.widget.ImageView;
import android.content.Context;
import android.content.pm.PackageManager;
import java.io.IOException;
import android.hardware.Camera;
import android.util.Log;
import android.widget.FrameLayout;



public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private SurfaceHolder mHolder;
    private Camera mCamera;


    public CameraPreview(Context context) {
        super(context);
        mCamera = getCameraInstance();
        // Install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed.
        mHolder = getHolder();
        mHolder.addCallback(this);
        // deprecated setting, but required on Android versions prior to 3.0
        mHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
    }

    public void surfaceCreated(SurfaceHolder holder) {
        // The Surface has been created, now tell the camera where to draw the preview.
        try {
            mCamera.reconnect();
            mCamera.setPreviewDisplay(holder);
            //mCamera.startPreview();
        } catch (IOException e) {
            // TODO: LOGGING
        }
    }

    public void startCamera() {
        try {
            mCamera.startPreview();

        } catch (Exception e) {
            // TODO
        }

    }

    public void stopCamera() {
        try {
            if(mCamera!=null){
                mCamera.stopPreview();
                mCamera.setPreviewCallback(null);
                mCamera.release();
                //mCamera = null;
            }

        } catch (Exception e) {
            // TODO
        }

    }


    public void surfaceDestroyed(SurfaceHolder holder) {
        if(mCamera!=null){
            mCamera.stopPreview();
            mCamera.setPreviewCallback(null);
            mCamera.release();
            mCamera = null;


    }}

    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        // If your preview can change or rotate, take care of those events here.
        // Make sure to stop the preview before resizing or reformatting it.

        if (mHolder.getSurface() == null) {
            // preview surface does not exist
            return;
        }

        // stop preview before making changes
        try {
            //mCamera.stopPreview();
        } catch (Exception e) {
            // ignore: tried to stop a non-existent preview
        }

        // set preview size and make any resize, rotate or
        // reformatting changes here

        // start preview with new settings
        try {
            mCamera.setPreviewDisplay(mHolder);
            //mCamera.startPreview();

        } catch (Exception e) {
            // TODO: LOGGING
        }
    }


    /**
     * A safe way to get an instance of the Camera object.
     */
    public static Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open(); // attempt to get a Camera instance
        } catch (Exception e) {
            // Camera is not available (in use or does not exist)
            Log.e("Error", e.getMessage());
        }
        return c; // returns null if camera is unavailable
    }

    /**
     * Check if this device has a camera
     */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            // this device has a camera
            return true;
        } else {
            // no camera on this device
            return false;
        }
    }


}