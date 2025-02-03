package org.fors.wwms.entity

    import io.swagger.v3.oas.annotations.media.Schema
    import jakarta.persistence.*

    @Entity
    @Table(name = "brand")
    open class Brand {
        @Id
        @javax.validation.constraints.Size(max = 10)
        @Column(name = "brand_code", nullable = false, length = 10)
        @Schema(example = "BR123")
        open var brandCode: String? = null

        @javax.validation.constraints.Size(max = 100)
        @javax.validation.constraints.NotNull
        @Column(name = "brand_name", nullable = false, length = 100)
        @Schema(example = "BrandName")
        open var brandName: String? = null

        @ManyToOne(cascade = [CascadeType.ALL])
        @JoinColumn(name = "address_id", nullable = false)
        @Schema(implementation = Address::class)
        open var address: Address? = null
    }