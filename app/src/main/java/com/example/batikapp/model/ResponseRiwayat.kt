package com.langga.batikapp.model

data class ResponseRiwayat(
    val riwayatKain1: RiwayatKain1? = null,
    val riwayatKain2: RiwayatKain2? = null,
)


data class RiwayatKain1(
	val id5: Id5? = null,
	val id4: Id4? = null,
	val id1: Id1? = null,
	val id3: Id3? = null,
	val id2: Id2? = null,
)


data class Id3(
	val arus: Int? = null,
	val frekuensi: Int? = null,
	val suhu: List<Int?>? = null,
	val tegangan: Int? = null,
	val daya: Int? = null,
	val tanggal: String? = null,
)

data class Id1(
	val arus: Int? = null,
	val frekuensi: Int? = null,
	val suhu: List<Int?>? = null,
	val tegangan: Int? = null,
	val daya: Int? = null,
	val tanggal: String? = null,
)

data class RiwayatKain2(
	val id5: Id5? = null,
	val id4: Id4? = null,
	val id1: Id1? = null,
	val id3: Id3? = null,
	val id2: Id2? = null,
)

data class Id4(
	val arus: Int? = null,
	val frekuensi: Int? = null,
	val suhu: List<Int?>? = null,
	val tegangan: Int? = null,
	val daya: Int? = null,
	val tanggal: String? = null,
)

data class Id2(
	val arus: Int? = null,
	val frekuensi: Int? = null,
	val suhu: List<Int?>? = null,
	val tegangan: Int? = null,
	val daya: Int? = null,
	val tanggal: String? = null,
)

data class Id5(
	val arus: Int? = null,
	val frekuensi: Int? = null,
	val suhu: List<Int?>? = null,
	val tegangan: Int? = null,
	val daya: Int? = null,
	val tanggal: String? = null,
)

