package hu.anyrt.falatozo.data.response.user

data class KovetkezoHetNapiMenu(
    val etelLista: List<EtelLista>,
    val menuDatum: String = ""
)