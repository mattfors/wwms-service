package org.fors.wwms.idoc

import com.fasterxml.jackson.annotation.JsonRootName
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement
import javax.validation.constraints.*

// Enum classes
enum class MatlType(val value: String) {
    ROH("ROH"),   // Raw Material
    FERT("FERT"), // Finished Goods
    HALB("HALB"), // Semi-finished Goods
    HAWA("HAWA")  // Trading Goods
}

enum class MaterialStatus(val value: String) {
    A("A"),  // Active
    I("I")   // Inactive
}

enum class BaseUOM(val value: String) {
    EA("EA"),   // Each
    KG("KG"),   // Kilogram
    MTR("MTR"), // Meter
    L("L")      // Liter
}

// Segment Classes
data class E1MARAM(
    @field:Size(max = 3)
    val MSGFN: String?, // Message function code

    @field:Size(max = 18)
    val MATNR: String?, // Material number

    @field:Size(max = 18)
    val BISMT: String?, // Number you use or previously used to manage the material

    @field:Size(max = 14)
    val BREIT: String?, // Width

    @field:Size(max = 14)
    val BRGEW: String?, // Gross weight per weight unit

    @field:Size(max = 3)
    val GEWEI: String?, // Weight unit

    @field:Size(max = 14)
    val HOEHE: String?, // Height

    @field:Size(max = 1)
    val KZKFG: String?, // Configurable material

    @field:Size(max = 14)
    val LAENG: String?, // Length

    @field:Size(max = 9)
    val MATKL: String?, // Key for material group

    @field:Size(max = 1)
    val MBRSH: String?, // Key specifying the branch of industry

    @field:Size(max = 3)
    val MEABM: String?, // Unit for length, width, and height

    @field:Size(max = 3)
    val MEINS: String?, // Unit of measure

    @field:Size(max = 4)
    val MTART: String?, // Key for material type

    @field:Size(max = 14)
    val NTGEW: String?, // Net weight per weight unit

    @field:Size(max = 2)
    val SPART: String?, // Division

    @field:Size(max = 3)
    val VOLEH: String?, // Unit for volume

    @field:Size(max = 14)
    val VOLUM: String? // Volume per unit
)

data class E1MAKTM(
    @field:Size(max = 3)
    val MSGFN: String?, // Message function code

    @field:Size(max = 1)
    val SPRAS: String?, // Language key

    @field:Size(max = 40)
    val MAKTX: String? // Material description
)

data class E1MARCM(
    @field:Size(max = 3)
    val MSGFN: String?, // Message function code

    @field:Size(max = 4)
    val WERKS: String?, // Plant key

    @field:Size(max = 3)
    val AUSME: String?, // Unit of issue

    @field:Size(max = 5)
    val AUSSS: String?, // Assembly scrap in percent

    @field:Size(max = 14)
    val BASMG: String?, // Base quantity

    @field:Size(max = 6)
    val BEARZ: String?, // Processing time

    @field:Size(max = 1)
    val BESKZ: String?, // Procurement indicator

    @field:Size(max = 14)
    val BSTFE: String?, // Lot size

    @field:Size(max = 14)
    val BSTMI: String?, // Minimum lot size

    @field:Size(max = 14)
    val BSTMA: String?, // Maximum lot size

    @field:Size(max = 14)
    val BSTRF: String?, // Rounding value

    @field:Size(max = 2)
    val DISLS: String?, // Lot size method

    @field:Size(max = 2)
    val DISMM: String?, // MRP type

    @field:Size(max = 3)
    val DISPO: String?, // MRP controller

    @field:Size(max = 3)
    val DZEIT: String?, // In-house processing time

    @field:Size(max = 14)
    val EISBE: String?, // Safety stock

    @field:Size(max = 3)
    val FEVOR: String?, // Production supervisor

    @field:Size(max = 1)
    val FFREI: String?, // Automatic release indicator

    @field:Size(max = 3)
    val FHORI: String?, // Float time key

    @field:Size(max = 3)
    val FRTME: String?, // Production unit of measure

    @field:Size(max = 3)
    val FXHOR: String?, // Planning time fence

    @field:Size(max = 5)
    val KAUSF: String?, // Component scrap in percent

    @field:Size(max = 1)
    val KZKRI: String?, // Critical part indicator

    @field:Size(max = 1)
    val KZKUP: String?, // Co-product indicator

    @field:Size(max = 4)
    val LGPRO: String?, // Issue storage location

    @field:Size(max = 14)
    val MABST: String?, // Maximum stock level

    @field:Size(max = 14)
    val MINBE: String?, // Reorder point

    @field:Size(max = 3)
    val MRPPP: String?, // PP planning calendar

    @field:Size(max = 2)
    val MTVFP: String?, // Availability check

    @field:Size(max = 3)
    val PLIFZ: String?, // Planned delivery time

    @field:Size(max = 4)
    val RDPRF: String?, // Rounding profile

    @field:Size(max = 1)
    val RGEKZ: String?, // Backflush indicator

    @field:Size(max = 6)
    val RUEZT: String?, // Setup time

    @field:Size(max = 1)
    val SAUFT: String?, // Repetitive manufacturing indicator

    @field:Size(max = 1)
    val SCHGT: String?, // Bulk material indicator

    @field:Size(max = 4)
    val SFEPR: String?, // Repetitive manufacturing profile

    @field:Size(max = 2)
    val SOBSL: String?, // Special procurement type

    @field:Size(max = 2)
    val STRGR: String?, // Strategy group

    @field:Size(max = 15)
    val TRAME: String?, // Stock in transit

    @field:Size(max = 6)
    val TRANZ: String?, // Interoperation time

    @field:Size(max = 4)
    val UEETO: String?, // Overdelivery tolerance

    @field:Size(max = 14)
    val UMLMC: String?, // Stock in transfer

    @field:Size(max = 4)
    val UNETO: String?, // Underdelivery tolerance

    @field:Size(max = 3)
    val WEBAZ: String? // Goods receipt processing time
)

data class E1MARDM(
    @field:Size(max = 3)
    val MSGFN: String?, // Message function code

    @field:Size(max = 4)
    val LGORT: String?, // Storage location

    @field:Size(max = 1)
    val DISKZ: String?, // MRP indicator

    @field:Size(max = 14)
    val LBSTF: String?, // Lot size

    @field:Size(max = 10)
    val LGPBE: String?, // Storage bin

    @field:Size(max = 14)
    val LMINB: String?, // Reorder point

    @field:Size(max = 2)
    val LSOBS: String? // Special procurement type
)

data class E1MKALM(
    @field:Size(max = 3)
    val MSGFN: String?, // Message function code

    @field:Size(max = 4)
    val VERID: String?, // Production version

    @field:Size(max = 8)
    val ADATU: String?, // Valid from date

    @field:Size(max = 2)
    val ALNAL: String?, // Group counter

    @field:Size(max = 8)
    val BDATU: String?, // Valid to date

    @field:Size(max = 15)
    val BSTMA: String?, // Upper limit of lot size range

    @field:Size(max = 15)
    val BSTMI: String?, // Lower limit of lot size range

    @field:Size(max = 8)
    val MDV01: String?, // Work center

    @field:Size(max = 8)
    val MDV02: String?, // Planning ID

    @field:Size(max = 8)
    val PLNNR: String?, // Group key

    @field:Size(max = 1)
    val PLNTY: String?, // Task list type

    @field:Size(max = 1)
    val SERKZ: String?, // Run schedule header indicator

    @field:Size(max = 2)
    val STLAL: String?, // BOM alternative

    @field:Size(max = 1)
    val STLAN: String?, // BOM usage

    @field:Size(max = 40)
    val TEXT1: String?, // Short description

    @field:Size(max = 4)
    val VERTO: String? // Distribution key
)

data class E1MBEWM(
    @field:Size(max = 3)
    val MSGFN: String?, // Message function code

    @field:Size(max = 4)
    val BWKEY: String?, // Valuation area

    @field:Size(max = 10)
    val BWTAR: String?, // Valuation type

    @field:Size(max = 4)
    val BKLAS: String?, // Valuation class

    @field:Size(max = 5)
    val PEINH: String?, // Price unit

    @field:Size(max = 12)
    val STPRS: String?, // Standard price

    @field:Size(max = 12)
    val VERPR: String?, // Moving average price

    @field:Size(max = 1)
    val VPRSV: String?, // Price control indicator

    @field:Size(max = 8)
    val ZKDAT: String?, // Valid from date

    @field:Size(max = 12)
    val ZKPRS: String? // Future price
)

data class E1MARMM (
    @field:Size(max = 3)
    val MSGFN: String?, // Message function code

    @field:Size(max = 3)
    val MEINH: String?, // Alternative unit of measure

    @field:Size(max = 14)
    val BREIT: String?, // Width

    @field:Size(max = 14)
    val BRGEW: String?, // Gross weight

    @field:Size(max = 3)
    val GEWEI: String?, // Weight unit

    @field:Size(max = 14)
    val HOEHE: String?, // Height

    @field:Size(max = 14)
    val LAENG: String?, // Length

    @field:Size(max = 3)
    val MEABM: String?, // Unit for length, width, and height

    @field:Size(max = 5)
    val UMREN: String?, // Denominator for conversion

    @field:Size(max = 5)
    val UMREZ: String?, // Numerator for conversion

    @field:Size(max = 3)
    val VOLEH: String?, // Volume unit

    @field:Size(max = 14)
    val VOLUM: String? // Volume
)

// Main IDoc Class
data class Matmas03Idoc(
    @field:Size(max = 8, message = "IDOCTYPE must be 8 characters long")
    val IDOCTYPE: String?,   // IDoc Type (e.g., MATMAS03)

    @field:Size(max = 6, message = "MESTYP must be 6 characters long")
    val MESTYP: String?,     // Message Type (e.g., MATMAS)

    @field:Size(max = 2, message = "SNDPRT must be 2 characters long")
    val SNDPRT: String?,     // Sender partner type

    @field:Size(max = 8, message = "SNDPOR must be 8 characters long")
    val SNDPOR: String?,     // Sender port

    @field:Size(max = 2, message = "RCVPRT must be 2 characters long")
    val RCVPRT: String?,     // Receiver partner type

    @field:Size(max = 8, message = "RCVPOR must be 8 characters long")
    val RCVPOR: String?,     // Receiver port

    @field:Size(max = 3, message = "SNDLAD must be 3 characters long")
    val SNDLAD: String?,     // Sender logical system

    @field:Size(max = 3, message = "RCVLAD must be 3 characters long")
    val RCVLAD: String?,     // Receiver logical system

    @field:Size(max = 10, message = "SNDID must be 10 characters long")
    val SNDID: String?,      // Sender partner number

    @field:Size(max = 10, message = "RCVID must be 10 characters long")
    val RCVID: String?,      // Receiver partner number


    //val E1MARAM: List<E1MARAM>? = emptyList(),   // Material master general data
    //val E1MAKTM: List<E1MAKTM>? = emptyList(),   // Material descriptions (language-specific)
    //val E1MARDM: List<E1MARDM>? = emptyList(),   // Material plant data
    //val E1MARCM: List<E1MARCM>? = emptyList(),   // Material MRP data
    //val E1MKALM: List<E1MKALM>? = emptyList(),   // Production version data
    //val E1MBEWM: List<E1MBEWM>? = emptyList(),   // Valuation data
    //val E1MARMM: List<E1MARMM>? = emptyList()    // Alternative unit of measure data


    val E1MARAM: E1MARAM?,   // Material master general data
    val E1MAKTM: E1MAKTM?,   // Material descriptions (language-specific)
    val E1MARDM: E1MARDM?,   // Material plant data
    val E1MARCM: E1MARCM?,   // Material MRP data
    val E1MKALM: E1MKALM?,   // Production version data
    val E1MBEWM: E1MBEWM?,   // Valuation data
    val E1MARMM: E1MARMM?    // Alternative unit of measure data
)