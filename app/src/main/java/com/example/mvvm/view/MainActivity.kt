package com.example.mvvm.view

import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.example.commonlib.Constant
import com.example.commonlib.base.BaseActivity
import com.example.commonlib.base.ClickPresent
import com.example.commonlib.extens.showSuccessDialog
import com.example.commonlib.extens.toast
import com.example.mvvm.R
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.viewmodel.AnimalViewModel
import com.qmuiteam.qmui.util.QMUIStatusBarHelper
import com.qmuiteam.qmui.widget.tab.QMUITab
import org.koin.android.viewmodel.ext.android.viewModel


@Route(path = Constant.PATH_ACTIVITY_APP_MAIN)
class MainActivity : BaseActivity<ActivityMainBinding>(), ClickPresent {
    //di
//    private val mViewModel: AnimalViewModel by viewModel() {
//        parametersOf(
//            Animal("dog", 0),
//            application
//        )
//    }
    private val mViewModel: AnimalViewModel by viewModel()
    var fragmentList: MutableList<Fragment> = ArrayList()
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun bindVM() {
        mBinding.presenter = this
    }

    override fun initView() {
        QMUIStatusBarHelper.setStatusBarLightMode(this)
        initTab()
    }

    private fun initTab() {
        val normalColor = resources.getColor(R.color.qmui_config_color_gray_2)
        val selectColor = resources.getColor(R.color.teal_200)
        val home = mBinding.tabs.tabBuilder()
            .setColor(normalColor, selectColor)
            .setText("首页")
            .setNormalDrawable(resources.getDrawable(R.mipmap.icon_tab_home_selected))
            .setIconPosition(QMUITab.ICON_POSITION_TOP)
            .setDynamicChangeIconColor(true)
            .build(this@MainActivity)
        mBinding.tabs.addTab(home)
        val mine = mBinding.tabs.tabBuilder()
            .setColor(normalColor, selectColor)
            .setText("我的")
            .setNormalDrawable(resources.getDrawable(R.mipmap.icon_tab_mine_selected))
            .setIconPosition(QMUITab.ICON_POSITION_TOP)
            .setDynamicChangeIconColor(true)
            .build(this@MainActivity)
        mBinding.tabs.addTab(mine)
        val mainFragment = ARouter.getInstance().build(Constant.PATH_FRAGMENT_MAIN_MAIN)
            .navigation() as Fragment
        val mineFragment = ARouter.getInstance().build(Constant.PATH_FRAGMENT_MINE_MINE)
            .navigation() as Fragment
        fragmentList.add(mainFragment)
        fragmentList.add(mineFragment)
        //        mTabSegment.notifyDataChanged();
        //        mTabSegment.notifyDataChanged();
        mBinding.viewPager.offscreenPageLimit = 5
        mBinding.viewPager.adapter = object :
            FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getItem(position: Int): Fragment {
                return fragmentList[position]
            }

            override fun getCount(): Int {
                return fragmentList.size
            }
        }
        mBinding.tabs.setupWithViewPager(mBinding.viewPager, false)
    }

    override fun initData() {
        mViewModel.toast.observe(this,
            Observer<String> { t ->
                Toast.makeText(applicationContext, t, Toast.LENGTH_SHORT).show()
            })
    }

    override fun onClick(v: View?) {
        toast("阿萨飒")
        showSuccessDialog("阿萨飒")
    }
}