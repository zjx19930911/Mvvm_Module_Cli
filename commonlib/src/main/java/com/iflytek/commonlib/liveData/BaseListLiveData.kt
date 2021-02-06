package com.iflytek.commonlib.liveData

/**
 * Created by Jianxin on 2021/2/4.
 */

data class BaseListLiveData<T>(
    var isSuccess: Boolean,
    var errorMessage: String? = null,
    var result: List<T>? = null
)