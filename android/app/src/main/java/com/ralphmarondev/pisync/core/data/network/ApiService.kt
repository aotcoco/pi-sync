package com.ralphmarondev.pisync.core.data.network

import com.ralphmarondev.pisync.core.domain.Result
import com.ralphmarondev.pisync.features.auth.domain.model.User
import com.ralphmarondev.pisync.features.history.domain.model.DoorLog
import com.ralphmarondev.pisync.features.home.domain.model.DoorActionRequest
import com.ralphmarondev.pisync.features.home.domain.model.DoorActionResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("login/")
    suspend fun login(@Body user: User): Result

    @POST("door/{id}/open/")
    suspend fun openDoor(
        @Path("id") doorId: Int,
        @Body request: DoorActionRequest
    ): DoorActionResponse

    @POST("door/{id}/close/")
    suspend fun closeDoor(
        @Path("id") doorId: Int,
        @Body request: DoorActionRequest
    ): DoorActionResponse

    @GET("history/")
    suspend fun getHistory(): List<DoorLog>
}