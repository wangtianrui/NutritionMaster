package com.example.ninefourone.nutritionmaster.modules.classifyresult;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.ninefourone.nutritionmaster.R;
import com.example.ninefourone.nutritionmaster.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MaterialResultActivity extends BaseActivity {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;


    @Override
    public int getLayoutId() {
        return R.layout.activity_material_result;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {

    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
