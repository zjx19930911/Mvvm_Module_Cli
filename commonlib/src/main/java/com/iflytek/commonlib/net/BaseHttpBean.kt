package com.iflytek.commonlib.net

/**
 * Created by Jianxin on 2021/1/8.
 * 处理请求data为对象的数据
 * {
 *  "result":"结果代号",
 *  "msg":"消息文本"
 *  "data":{}
 * }
 *
 */
class BaseHttpBean<T> {
    var data: T? = null
    var message: String? = null
    var code = 0
}