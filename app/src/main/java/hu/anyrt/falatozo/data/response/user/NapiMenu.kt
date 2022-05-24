package hu.anyrt.falatozo.data.response.user

data class NapiMenu(
    val etelLista: List<EtelLista>,
    val menuDatum: String? = ""
)