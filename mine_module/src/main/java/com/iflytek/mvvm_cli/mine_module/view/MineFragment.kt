package com.iflytek.mvvm_cli.mine_module.view

import android.util.Log
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.iflytek.commonlib.ConstantRouterPath
import com.iflytek.commonlib.base.BaseFragment
import com.iflytek.commonlib.viewModel.ClickPresent
import com.iflytek.mvvm_cli.mine_module.R
import com.iflytek.mvvm_cli.mine_module.databinding.FragmentMineBinding

/**
 * Created by Jianxin on 2021/1/27.
 */
@Route(path = ConstantRouterPath.PATH_FRAGMENT_MINE_MINE)
class MineFragment : BaseFragment<FragmentMineBinding>(),
    ClickPresent {
    override fun bindVM() {
        mBinding.click = this
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_mine
    }

    override fun initView() {
        mBinding.topBar.setTitle("我的")
    }

    override fun lazyLoad() {
        Log.e("MineFragment", "MineFragment:initData")
    }

    override fun onClick(v: View?) {

    }

}