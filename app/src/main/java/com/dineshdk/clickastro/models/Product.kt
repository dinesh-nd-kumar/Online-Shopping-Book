package com.dineshdk.clickastro.models

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("products") val products: Map<String, Product>
)

data class Product(
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("availableLanguages") val availableLanguages: List<String>,
    @SerializedName("sampleReports") val sampleReports: SampleReports,
    @SerializedName("pages") val pages: Int,
    @SerializedName("pagesintext") val pagesintext: String,
    @SerializedName("report_type") val reportType: String,
    @SerializedName("authentic") val authentic: String,
    @SerializedName("remedies") val remedies: String,
    @SerializedName("vedic") val vedic: String,
    @SerializedName("price") val price: Int,
    @SerializedName("discount") val discount: Int,
    @SerializedName("appDiscount") val appDiscount: Int,
    @SerializedName("couponDiscount") val couponDiscount: Int,
    @SerializedName("imagePath") val imagePath: ImagePath,
    @SerializedName("soldcount") val soldcount: String,
    @SerializedName("avg") val avg: Double
)

data class SampleReports(
    @SerializedName("ENG") val eng: String?,
    @SerializedName("HIN") val hin: String?,
    @SerializedName("MAL") val mal: String?,
    @SerializedName("MAR") val mar: String?,
    @SerializedName("TAM") val tam: String?,
    @SerializedName("TEL") val tel: String?,
    @SerializedName("KAN") val kan: String?,
    @SerializedName("BEN") val ben: String?,
    @SerializedName("ORI") val ori: String?,
    @SerializedName("GUJ") val guj: String?
)

data class ImagePath(
    @SerializedName("square") val square: String,
    @SerializedName("wide") val wide: String
)
