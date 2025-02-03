package org.fors.wwms.entity

import java.time.Instant
import jakarta.persistence.*

@Entity
@Table(name = "material")
open class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id", nullable = false)
    open var id: Int? = null

    @javax.validation.constraints.Size(max = 10)
    @javax.validation.constraints.NotNull
    @Column(name = "brand_code", nullable = false, length = 10)
    open var brandCode: String? = null

    @javax.validation.constraints.Size(max = 50)
    @javax.validation.constraints.NotNull
    @Column(name = "mat_num", nullable = false, length = 50)
    open var matNum: String? = null

    @javax.validation.constraints.Size(max = 50)
    @javax.validation.constraints.NotNull
    @Column(name = "ext_mat_num", nullable = false, length = 50)
    open var extMatNum: String? = null

    @javax.validation.constraints.Size(max = 100)
    @javax.validation.constraints.NotNull
    @Column(name = "material_type", nullable = false, length = 100)
    open var materialType: String? = null

    @javax.validation.constraints.NotNull
    @Column(name = "case_qty", nullable = false)
    open var caseQty: Int? = null

    @ManyToOne
    @JoinColumn(name = "dimension_id", referencedColumnName = "dimension_id")
    open var dimension: Dimension? = null

    @ManyToOne
    @JoinColumn(name = "description_id", referencedColumnName = "description_id")
    open var description: Description? = null

    @Column(name = "create_date")
    open var createDate: Instant? = null

    @Column(name = "mod_date")
    open var modDate: Instant? = null

    @OneToMany(mappedBy = "material", cascade = [CascadeType.ALL], orphanRemoval = true)
    open var barcodes: List<Barcode> = mutableListOf()
}