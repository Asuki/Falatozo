package hu.anyrt.falatozo.data.response.user

data class NapiMenu(
    val etelLista: List<EtelListaX>,
    val menuDatum: String = ""
)