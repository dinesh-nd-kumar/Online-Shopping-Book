package com.dineshdk.clickastro.models

import androidx.room.*

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "availableLanguages") val availableLanguages: String,  // Stored as comma-separated string
    @Embedded val sampleReports: SampleReportsEntity,
    @ColumnInfo(name = "pages") val pages: Int,
    @ColumnInfo(name = "pagesintext") val pagesintext: String,
    @ColumnInfo(name = "report_type") val reportType: String,
    @ColumnInfo(name = "authentic") val authentic: String,
    @ColumnInfo(name = "remedies") val remedies: String,
    @ColumnInfo(name = "vedic") val vedic: String,
    @ColumnInfo(name = "price") val price: Int,
    @ColumnInfo(name = "discount") val discount: Int,
    @ColumnInfo(name = "appDiscount") val appDiscount: Int,
    @ColumnInfo(name = "couponDiscount") val couponDiscount: Int,
    @Embedded val imagePath: ImagePathEntity,
    @ColumnInfo(name = "soldcount") val soldcount: String,
    @ColumnInfo(name = "avg") val avg: Double
)

data class SampleReportsEntity(
    @ColumnInfo(name = "ENG") val eng: String?,
    @ColumnInfo(name = "HIN") val hin: String?,
    @ColumnInfo(name = "MAL") val mal: String?,
    @ColumnInfo(name = "MAR") val mar: String?,
    @ColumnInfo(name = "TAM") val tam: String?,
    @ColumnInfo(name = "TEL") val tel: String?,
    @ColumnInfo(name = "KAN") val kan: String?,
    @ColumnInfo(name = "BEN") val ben: String?,
    @ColumnInfo(name = "ORI") val ori: String?,
    @ColumnInfo(name = "GUJ") val guj: String?
)

data class ImagePathEntity(
    @ColumnInfo(name = "square") val square: String,
    @ColumnInfo(name = "wide") val wide: String
)
