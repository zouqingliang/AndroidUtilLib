package com.siberiadante.utilsample.activity.view;

import android.os.Bundle;
import android.view.View;

import com.siberiadante.androidutil.view.loading.SDRotateLayoutImageView;
import com.siberiadante.androidutil.view.loading.SDCircleMove;
import com.siberiadante.androidutil.view.loading.SDSkipLoadView;
import com.siberiadante.utilsample.R;
import com.siberiadante.utilsample.activity.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class SDLoadingViewActivity extends BaseActivity {

    @BindView(R.id.sd_circle_move)
    SDCircleMove sdCircleMove;
    @BindView(R.id.sd_skip_load_view)
    SDSkipLoadView sdSkipLoadView;
    @BindView(R.id.sd_rotate_view)
    SDRotateLayoutImageView sdRotateView;

    @Override
    public int setLayoutId() {
        return R.layout.activity_sdloading_view;
    }

    @Override
    public void initView(Bundle savedInstanceState) {

    }

    @OnClick({R.id.sd_rotate_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.sd_rotate_view:
                sdRotateView.stopAnimator();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sdSkipLoadView.setVisibility(View.GONE);
    }
}
