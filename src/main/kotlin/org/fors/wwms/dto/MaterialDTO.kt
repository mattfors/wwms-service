package org.fors.wwms.dto

data class BarcodeDTO(
    var barcodeType: String? = null,
    var barcodeData: String? = null
)

data class MaterialDTO(
    var brandCode: String? = null,
    var matNum: String? = null,
    var extMatNum: String? = null,
    var materialType: String? = null,
    var caseQty: Int? = null,
    var weight: Double? = null,
    var length: Double? = null,
    var width: Double? = null,
    var height: Double? = null,
    var shortDesc: String? = null,
    var longDesc: String? = null,
    var barcodes: List<BarcodeDTO> = mutableListOf()
)