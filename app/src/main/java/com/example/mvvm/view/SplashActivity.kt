package com.example.mvvm.view

import android.animation.Animator
import android.animation.ObjectAnimator
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.commonlib.Constant
import com.example.commonlib.base.BaseActivity
import com.example.mvvm.R
import com.example.mvvm.databinding.ActivitySplashBinding
import com.example.mvvm.viewmodel.SplashViewModel
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * Created by Jianxin on 2021/1/13.
 */

@Route(path = Constant.PATH_ACTIVITY_APP_SPLASH)
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    private val mViewModel: SplashViewModel by viewModel()


    override fun bindVM() {
        mBinding.vm = mViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initView() {
        val animator = ObjectAnimator.ofFloat(mBinding.bg, "alpha", 0f, 1f)
        animator.duration = 2000
        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(animation: Animator?) {
            }

            override fun onAnimationEnd(animation: Animator?) {
                ARouter.getInstance().build(Constant.PATH_ACTIVITY_APP_MAIN).navigation()
                finish()
            }

            override fun onAnimationCancel(animation: Animator?) {
            }

            override fun onAnimationStart(animation: Animator?) {
            }

        })
        animator.start()
    }

    override fun initData() {

    }

}