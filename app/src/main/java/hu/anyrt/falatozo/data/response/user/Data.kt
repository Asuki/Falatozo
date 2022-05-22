package hu.anyrt.falatozo.data.response.user

data class Data(
    val azonosito: String = "",
    val email: String = "",
    val id: Int = 0,
    val keresztnev: String = "",
    val kovetkezoHetNapiMenu: List<KovetkezoHetNapiMenu>,
    val megrendeltEtel: List<MegrendeltEtel>,
    val napiMenu: List<NapiMenu>,
    val rendelesModositasDatuma: String = "",
    val vezeteknev: String = ""
)