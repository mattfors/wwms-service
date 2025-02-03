package org.fors.wwms.entity

import io.swagger.annotations.ApiModelProperty
import jakarta.persistence.*

@Entity
@Table(name = "address")
open class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id", nullable = false)
    open var id: Int? = null

    @javax.validation.constraints.Size(max = 255)
    @javax.validation.constraints.NotNull
    @Column(name = "delivery_name", nullable = false)
    @ApiModelProperty(example = "John Doe")
    open var deliveryName: String? = null

    @javax.validation.constraints.Size(max = 255)
    @javax.validation.constraints.NotNull
    @Column(name = "delivery_line_1", nullable = false)
    @ApiModelProperty(example = "123 Main St")
    open var deliveryLine1: String? = null

    @javax.validation.constraints.Size(max = 255)
    @Column(name = "delivery_line_2")
    @ApiModelProperty(example = "Apt 4B")
    open var deliveryLine2: String? = null

    @javax.validation.constraints.Size(max = 50)
    @Column(name = "suite", length = 50)
    @ApiModelProperty(example = "Suite 100")
    open var suite: String? = null

    @javax.validation.constraints.Size(max = 100)
    @javax.validation.constraints.NotNull
    @Column(name = "city", nullable = false, length = 100)
    @ApiModelProperty(example = "Springfield")
    open var city: String? = null

    @javax.validation.constraints.Size(max = 100)
    @javax.validation.constraints.NotNull
    @Column(name = "state", nullable = false, length = 100)
    @ApiModelProperty(example = "IL")
    open var state: String? = null

    @javax.validation.constraints.Size(max = 20)
    @javax.validation.constraints.NotNull
    @Column(name = "zip_code", nullable = false, length = 20)
    @ApiModelProperty(example = "62704")
    open var zipCode: String? = null

    @javax.validation.constraints.Size(max = 10)
    @Column(name = "zip_plus4", length = 10)
    @ApiModelProperty(example = "1234")
    open var zipPlus4: String? = null

    @javax.validation.constraints.Size(max = 100)
    @javax.validation.constraints.NotNull
    @Column(name = "country", nullable = false, length = 100)
    @ApiModelProperty(example = "USA")
    open var country: String? = null

    @javax.validation.constraints.Size(max = 12)
    @Column(name = "phone_number", length = 12)
    @ApiModelProperty(example = "555-1234")
    open var phoneNumber: String? = null

    @javax.validation.constraints.Size(max = 12)
    @Column(name = "delivery_point_barcode", length = 12)
    @ApiModelProperty(example = "DPB123456")
    open var deliveryPointBarcode: String? = null
}