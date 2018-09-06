package com.example.ninefourone.nutritionmaster.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

/**
 * Created by ScorpioMiku on 2018/9/3.
 */

public class PermissionUtils {
    public static final int REQUEST_CAMERA = 1056;

    /**
     * 动态获取相机权限
     *
     * @param activity
     */
    public static void requestCameraPermission(Activity activity) {
        if (ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            /**
             * 直接请求四个权限
             */
            ActivityCompat.requestPermissions(activity,
                    new String[]{
                            Manifest.permission.CAMERA,
                            Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_PHONE_STATE
                    }, REQUEST_CAMERA);
//            MessageUtils.MakeToast("权限赋予成功");
        } else {
            /**
             * 否则
             */
        }

    }
}
