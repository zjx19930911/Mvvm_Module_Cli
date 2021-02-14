package com.iflytek.mvvm_module_cli.login_module.view

import android.view.View
import androidx.lifecycle.ViewModel
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.iflytek.commonlib.ConstantRouterPath
import com.iflytek.commonlib.base.BaseActivity
import com.iflytek.commonlib.extens.observerFilter
import com.iflytek.commonlib.viewModel.ClickPresent

import com.iflytek.mvvm_module_cli.login_module.viewmodel.LoginViewModel
import com.iflytek.commonlib.extens.showFailedDialog
import com.iflytek.commonlib.extens.showSuccessDialog
import com.iflytek.mvvm_module_cli.login_module.LoginApplication
import com.iflytek.mvvm_module_cli.login_module.R
import com.iflytek.mvvm_module_cli.login_module.databinding.ActivityLoginBinding
import org.koin.android.viewmodel.ext.android.viewModel

@Route(path = ConstantRouterPath.PATH_ACTIVITY_LOGIN_LOGIN)
class LoginActivity : BaseActivity<ActivityLoginBinding>(),
    ClickPresent {
    @JvmField
    @Autowired(name = "path")
    var path: String = ""

    private val mViewModel: LoginViewModel by viewModel()
    override fun bindVM() {
        mBinding.click = this
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_login
    }

    override fun initView() {
        mBinding.topBar.setTitle("登录")
    }

    override fun initData() {
        mViewModel.loginResult.observerFilter(this, {
            dismissProgressDialog()
            showSuccessDialog("登录成功:" + it?.curPage) {
                LoginApplication.isLogin = true
                ARouter.getInstance().build(path).navigation()
                finish()
            }
        }, { message, _ ->
            dismissProgressDialog()
            showFailedDialog(message)
        })
    }

    override fun onClick(v: View?) {
        showProgressDialog()
        mViewModel.ext()
        mViewModel.login(mBinding.editAcc.text.toString(), mBinding.editPwd.text.toString())
//        mViewModel.detail()
    }

    private fun ViewModel.ext() {
        this.apply {
            println("sasas")
        }
    }
}
