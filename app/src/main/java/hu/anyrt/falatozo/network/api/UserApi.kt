package hu.anyrt.falatozo.network.api

import hu.anyrt.falatozo.data.response.user.LoginUserResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserApi {
    @POST("./User/LoginUser/")
    @FormUrlEncoded
    fun loginUser(
        @Field("Username") username: String,
        @Field("Password") password: String
    ): Single<Response<LoginUserResponse>>
}