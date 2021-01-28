package com.example.mvvm.main_module.view

import com.alibaba.android.arouter.facade.annotation.Route
import com.example.commonlib.Constant
import com.example.commonlib.base.BaseActivity
import com.example.mvvm.main_module.R
import com.example.mvvm.main_module.databinding.ActivityMainDetailBinding

/**
 * Created by Jianxin on 2021/1/28.
 */
@Route(path = Constant.PATH_ACTIVITY_MAIN_MAINDETAIL, extras = 20001)
class MainDetailActivity : BaseActivity<ActivityMainDetailBinding>() {
    override fun bindVM() {

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main_detail
    }

    override fun initView() {
        mBinding.topBar.setTitle("主页详情")
    }

    override fun initData() {

    }
}