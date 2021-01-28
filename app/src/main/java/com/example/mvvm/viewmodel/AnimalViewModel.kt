package com.example.mvvm.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.mvvm.model.Animal

/**
 * 页面描述：AnimalViewModel
 * @param animal 数据源Model(MVVM 中的M),负责提供ViewModel中需要处理的数据
 * Created by Jianxin on 2021/1/6.
 */

class AnimalViewModel(
    val animal: Animal,
    application: Application
) : AndroidViewModel(application) {
    //////////////////data//////////////
    val info = MutableLiveData<String>()
    val toast = MutableLiveData<String>()

    //////////////////binding//////////////
    fun shout() {
        animal.shoutCount++
        info.value = "${animal.name} 叫了 ${animal.shoutCount}声.."
//        animal.getNetData("123456", "123456")?.subscribe(object : MyObserver<Article>() {
//            override fun onSuccess(data: Article?) {
//                println("onSuccess")
//                Log.e("asdasd", "onSuccess")
//                toast.value = "登陆成功"
//            }
//
//            override fun onFailed(message: String, code: Int) {
//                println("onFailed:$message")
//                Log.e("asdasd", "onFailed:$message,code:$code")
//                toast.value = message
//            }
//
//        });
    }



}