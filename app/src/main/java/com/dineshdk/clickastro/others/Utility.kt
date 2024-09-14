package com.dineshdk.clickastro.others

import com.dineshdk.clickastro.models.ApiResponse
import com.dineshdk.clickastro.models.ImagePath
import com.dineshdk.clickastro.models.ImagePathEntity
import com.dineshdk.clickastro.models.ProductEntity
import com.dineshdk.clickastro.models.SampleReports
import com.dineshdk.clickastro.models.SampleReportsEntity

fun ApiResponse.toProductEntities(): List<ProductEntity> {
    return products.map { (id, product) ->
        ProductEntity(
            id = id,
            name = product.name,
            description = product.description,
            availableLanguages = product.availableLanguages.joinToString(","),
            sampleReports = product.sampleReports.toEntity(),
            pages = product.pages,
            pagesintext = product.pagesintext,
            reportType = product.reportType,
            authentic = product.authentic,
            remedies = product.remedies,
            vedic = product.vedic,
            price = product.price,
            discount = product.discount,
            appDiscount = product.appDiscount,
            couponDiscount = product.couponDiscount,
            imagePath = product.imagePath.toEntity(),
            soldcount = product.soldcount,
            avg = product.avg
        )
    }
}

fun SampleReports.toEntity(): SampleReportsEntity {
    return SampleReportsEntity(
        eng = eng,
        hin = hin,
        mal = mal,
        mar = mar,
        tam = tam,
        tel = tel,
        kan = kan,
        ben = ben,
        ori = ori,
        guj = guj
    )
}

fun ImagePath.toEntity(): ImagePathEntity {
    return ImagePathEntity(
        square = square,
        wide = wide
    )
}
