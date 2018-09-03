package com.example.ninefourone.nutritionmaster.camera;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.utils.MessageUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ScorpioMiku on 2018/9/3.
 */

public class FoodMaterialCamera extends AppCompatActivity {
    @BindView(R.id.camera_preview)
    FrameLayout mCameraLayout;
    @BindView(R.id.results_text_view)
    TextView resultsTextView;
    @BindView(R.id.more_take_photo_button_capture)
    ImageView moreTakePhotoButtonCapture;
    @BindView(R.id.more_takephoto_ok)
    ImageView moreTakephotoOk;
    @BindView(R.id.more_camera_cover_linearlayout)
    FrameLayout moreCameraCoverLinearlayout;

    private Camera mCamera;
    private CameraPreview mPreview;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //取消toolbar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //注意：上面两个设置必须写在setContentView前面
        setContentView(R.layout.cameras_layout);
        ButterKnife.bind(this);

        if (!checkCameraHardware(this)) {
            MessageUtils.MakeToast("不支持相机");
        } else {
            openCamera();
        }
    }

    /**
     * 检查当前设备是否有相机
     *
     * @param context
     * @return
     */
    private boolean checkCameraHardware(Context context) {
        if (context.getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA)) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 打开相机
     */
    private void openCamera() {
        if (null == mCamera) {
            mCamera = getCameraInstance();
            mPreview = new CameraPreview(this, mCamera);
//            mPreview.setOnTouchListener(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    mCamera.autoFocus(null);
//                    return false;
//                }
//            });
            mCameraLayout.addView(mPreview);
            mCamera.startPreview();
        }
    }

    /**
     * 获取相机
     *
     * @return
     */
    private Camera getCameraInstance() {
        Camera c = null;
        try {
            c = Camera.open();
            Camera.Parameters mParameters = c.getParameters();
            mParameters.setPictureSize(720, 1280);
            c.setParameters(mParameters);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return c;
    }

    /**
     * 对焦回调,对焦完成后进行拍照
     */
    private Camera.AutoFocusCallback mAutoFocusCallback = new Camera.AutoFocusCallback() {
        @Override
        public void onAutoFocus(boolean success, Camera camera) {
            if (success) {
                mCamera.takePicture(null, null, mPictureCallback);
            }
        }
    };

    /**
     * 拍照回调
     */
    private Camera.PictureCallback mPictureCallback = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(final byte[] data, Camera camera) {
            MessageUtils.MakeToast("拍照！");
            mCamera.startPreview();
        }
    };


    /**
     * 两个按钮的事件
     *
     * @param view
     */
    @OnClick({R.id.more_take_photo_button_capture, R.id.more_takephoto_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.more_take_photo_button_capture:
                mCamera.autoFocus(mAutoFocusCallback);
                break;
            case R.id.more_takephoto_ok:
                break;
        }
    }
}
