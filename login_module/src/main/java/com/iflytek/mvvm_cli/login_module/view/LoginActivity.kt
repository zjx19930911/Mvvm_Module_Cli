package com.iflytek.mvvm_cli.login_module.view

import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.iflytek.commonlib.Constant
import com.iflytek.commonlib.base.BaseActivity
import com.iflytek.commonlib.base.ClickPresent

import com.iflytek.mvvm_cli.login_module.viewmodel.LoginViewModel
import com.iflytek.commonlib.extens.showFailedDialog
import com.iflytek.commonlib.extens.showSuccessDialog
import com.iflytek.mvvm_cli.login_module.LoginApplication
import com.iflytek.mvvm_cli.login_module.model.LoginModel
import com.iflytek.mvvm_cli.login_module.R
import com.iflytek.mvvm_cli.login_module.databinding.ActivityLoginBinding
import org.koin.android.viewmodel.ext.android.viewModel

@Route(path = Constant.PATH_ACTIVITY_LOGIN_LOGIN)
class LoginActivity : BaseActivity<ActivityLoginBinding>(), ClickPresent {
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
        mViewModel.loginFailed.observe(this,
            Observer<String> {
                dismissProgressDialog()
                showFailedDialog(it) {
                    LoginApplication.isLogin = true
                    ARouter.getInstance().build(path).navigation()
                    finish()
                }
            })
        mViewModel.loginSuccess.observe(this,
            Observer<LoginModel> {
                dismissProgressDialog()
                showSuccessDialog("登录成功") {
                    ARouter.getInstance().build(path).navigation()
                    finish()
                }
            })
    }

    override fun onClick(v: View?) {
        showProgressDialog()
        mViewModel.ext()
        mViewModel.login(mBinding.editAcc.text.toString(), mBinding.editPwd.text.toString())
    }

    private fun ViewModel.ext() {
        this.apply {
            println("sasas")
        }
    }
}
