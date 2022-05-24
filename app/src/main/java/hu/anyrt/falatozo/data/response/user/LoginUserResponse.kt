package hu.anyrt.falatozo.data.response.user

data class LoginUserResponse(
    val Data: Data,
    val HttpResultCode: Int = 0,
    val Message: String? = ""
)