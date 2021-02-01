package com.iflytek.mvvm_cli.model


/**
 * Created by Jianxin on 2021/1/6.
 */
open class AppMainModel(var name: String, var shoutCount: Int) {
//    fun getNetData(phone: String, passwprd: String): Observable<BaseBean<Article>>? {
//        return NetManager.getPaoService()?.getArticleDetail(phone, passwprd)
//            ?.subscribeOn(Schedulers.newThread())//请求在新的线程中执行
//            ?.observeOn(AndroidSchedulers.mainThread())
//    }
//
//    private fun save(t: Article?) {
//        TODO("Not yet implemented")
//    }
//
//    /**
//     * Observable 切换到主线程
//     */
//    fun <T> observableToMain(): ObservableTransformer<T, T>? {
//        return ObservableTransformer { upstream: Observable<T> ->
//            upstream.subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//        }
//    }
}

