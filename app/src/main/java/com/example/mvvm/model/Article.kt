package com.example.mvvm.model

import com.google.gson.annotations.SerializedName

/**
 * 页面描述：Article
 *
 * Created by ditclear on 2017/11/19.
 */

class Article(var title: String?){

    var id: Int = 0
    var content: String? = null
    var readme: String? = null
    @SerializedName("describe")
    var description: String? = null
    var click: Int = 0
    var channel: Int = 0
    var comments: Int = 0
    var stow: Int = 0
    var upvote: Int = 0
    var downvote: Int = 0
    var url: String? = null
    var pubDate: String? = null
    var thumbnail: String? = null




}