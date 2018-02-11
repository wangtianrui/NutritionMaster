package com.example.ninefourone.nutritionmaster.camera;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceView;
import android.view.SurfaceHolder;


import com.orhanobut.logger.Logger;

import java.io.IOException;

/**
 * Created by ScorpioMiku on 2018/9/3.
 */

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder mHolder;
    private Camera camera;

    public CameraPreview(Context context, Camera camera) {
        super(context);
        this.camera = camera;
        mHolder = getHolder();
        mHolder.addCallback(this);
//        mHolder.setType();
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {
            camera.setPreviewDisplay(holder);
            camera.startPreview();
        } catch (IOException e) {
            Logger.e(e.getMessage());
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if (mHolder.getSurface() == null) {
            return;
        }
        try {
            camera.stopPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            camera.setPreviewDisplay(mHolder);
            camera.startPreview();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
