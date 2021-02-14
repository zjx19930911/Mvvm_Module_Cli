package com.iflytek.mvvm_module_cli.main_module.view

import com.alibaba.android.arouter.facade.annotation.Route
import com.iflytek.commonlib.ConstantRouterPath
import com.iflytek.commonlib.base.BaseActivity
import com.iflytek.mvvm_module_cli.main_module.R
import com.iflytek.mvvm_module_cli.main_module.databinding.ActivityMainDetailBinding

/**
 * Created by Jianxin on 2021/1/28.
 */
@Route(path = ConstantRouterPath.PATH_ACTIVITY_MAIN_MAINDETAIL, extras = 20001)
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