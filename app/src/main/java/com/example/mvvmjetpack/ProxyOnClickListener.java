package com.example.mvvmjetpack;

import android.util.Log;
import android.view.View;

/**
 * title：
 * description：
 * author：dinglicheng on 2022/3/7 16:59
 */
class ProxyOnClickListener implements View.OnClickListener {

    View.OnClickListener oriLis;

    public ProxyOnClickListener(View.OnClickListener oriLis) {
        this.oriLis = oriLis;
    }

    @Override
    public void onClick(View v) {
        Log.d("main9", "点击事件被hook到了");
        if (oriLis != null) {
            oriLis.onClick(v);
        }
    }
}
