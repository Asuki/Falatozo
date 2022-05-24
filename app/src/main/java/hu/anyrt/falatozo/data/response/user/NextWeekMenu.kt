package hu.anyrt.falatozo.data.response.user

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

@Json(name = "KovetkezoHetNapiMenu")
data class NextWeekMenu(
    @Json(name =  "etelLista")
    val foodList: List<EtelLista>,
    @Json(name = "menuDatum")
    val menuDate: String? = ""
)