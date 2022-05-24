package hu.anyrt.falatozo.network.controller

import hu.anyrt.falatozo.data.response.user.LoginUserResponse
import hu.anyrt.falatozo.network.api.UserApi
import hu.anyrt.falatozo.network.core.ApiClient
import hu.anyrt.falatozo.network.core.HttpClientFactory
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import retrofit2.Response

class UserController {
    fun loginUser(username: String, password: String): Single<Response<LoginUserResponse>> {
        val client = ApiClient.makeHttpClient(
            HttpClientFactory()
                .getClient(), baseUrl = "http://192.168.100.130/api/"
        )
            .create(UserApi::class.java)

        return client.loginUser(username, password)
            .subscribeOn(Schedulers.io())
//            .map { loginUserResponse ->
//                loginUserResponse.body()
//                retrofit2.Response. <LoginUserResponse>(
////                    Data = loginUserResponse.body()?.Data,
////                    HttpResultCode = loginUserResponse.body()?.HttpResultCode,
////                    Message = loginUserResponse.body()?.Message
//                )
//            }
    }
}