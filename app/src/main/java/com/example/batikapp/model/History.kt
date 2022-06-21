package com.example.batikapp.model

//data class History(
//    val waktu: String,
//    val daya: String,
//    val arus: String,
//    val tegangan: String,
//    val frekuensi: String,
//    val suhu: List<*>,
//)

data class ItemSuhu(
    val list:Int,
)

data class History(
    val list: ArrayList<ItemHistory>,
)

data class ItemHistory(
    val waktu: String,
    val daya: String,
    val arus: String,
    val tegangan: String,
    val frekuensi: String,
    val suhu: List<*>,
)


