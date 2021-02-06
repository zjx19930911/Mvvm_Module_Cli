package com.iflytek.commonlib.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.iflytek.commonlib.database.User
import io.reactivex.Single

/**
 * 页面描述：ArticleDao
 *
 * Created by ditclear on 2017/10/30.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insetAll(users: List<User>)

    @Query("SELECT * FROM User WHERE userId= :id")
    fun getUserById(id: Int): Single<User>

    @Query("SELECT * FROM User")
    fun getAllUser(): Single<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User): Single<Long>

}