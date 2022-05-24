package hu.anyrt.falatozo.data.response.user

data class Data(
    val azonosito: Int = 0,
    val email: String = "",
    val id: Int = 0,
    val keresztnev: String = "",
    val kovetkezoHetNapiMenu: List<NextWeekMenu>,
    val megrendeltEtel: List<MegrendeltEtel>,
    val napiMenu: List<NapiMenu>,
    val rendelesModositasDatuma: String? = "",
    val vezeteknev: String = ""
)