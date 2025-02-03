package org.fors.wwms.entity

import jakarta.persistence.*

@Entity
@Table(name = "barcode")
open class Barcode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "barcode_id", nullable = false)
    open var id: Int? = null

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    open var material: Material? = null

    @javax.validation.constraints.Size(max = 10)
    @javax.validation.constraints.NotNull
    @Column(name = "barcode_type", nullable = false, length = 10)
    open var barcodeType: String? = null

    @javax.validation.constraints.Size(max = 50)
    @javax.validation.constraints.NotNull
    @Column(name = "barcode_data", nullable = false, length = 50)
    open var barcodeData: String? = null
}