package com.shady.recycleviewapp

import androidx.room.*

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Query("select * From user_table ")
    suspend fun getAllUsers() : List<User>

    @Update()
    suspend fun update(user: User)

    @Delete
    suspend fun delete(user: User)

    @Query("select * from USER_TABLE where id== :uId")
    suspend fun selectUserById(uId: Int): User
}