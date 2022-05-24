package hu.anyrt.falatozo.data.response.user

import com.google.gson.annotations.SerializedName
import javax.annotation.Nullable

data class EtelLista(
    val ar: Int = 0,
    val db: Int = 0,
    val etelID: Int = 0,
    val etelMegnevezes: String = "",
    @Nullable
    val hanyadikHet: Int? = null,
    val kategoria: String = "",
    val menuTipus: String = ""
)