package com.iflytek.commonlib.liveData

import com.iflytek.commonlib.net.NetManager

/**
 * Created by Jianxin on 2021/2/4.
 */

data class BaseListLiveData<T>(
    var isSuccess: Boolean,
    var result: List<T>? = null,
    var errorMessage: String? = null,
    var code: Int? = NetManager.SERVER_SUCCESS_CODE
)