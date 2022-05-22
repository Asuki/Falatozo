package hu.anyrt.falatozo.data.response.user

data class MegrendeltEtel(
    val Uzenet: String = "",
    val atvetelDatum: String = "",
    val db: Int = 0,
    val etelID: Int = 0,
    val etelMegnevezese: String = "",
    val hanyadikHet: Int  = 0,
    val menuTipus: String = "",
    val rendelesID: Int = 0
)