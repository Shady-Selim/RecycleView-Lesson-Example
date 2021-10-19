package com.shady.recycleviewapp

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    fun insert(user: User)

    @Query("select * From user_table ")
    fun getAllUsers() : List<User>

    @Update()
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("select * from USER_TABLE where id== :uId")
    fun selectUserById(uId: Int): User
}