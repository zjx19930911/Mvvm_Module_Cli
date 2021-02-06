package com.iflytek.commonlib.viewModel

import android.view.View

/**
 * Created by Jianxin on 2021/1/6.
 */
interface ClickPresent : View.OnClickListener {
    override fun onClick(v: View?)
}