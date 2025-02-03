package org.fors.wwms.entity

import java.math.BigDecimal
import jakarta.persistence.*

@Entity
@Table(name = "dimension")
open class Dimension {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dimension_id", nullable = false)
    open var id: Int? = null

    @javax.validation.constraints.NotNull
    @Column(name = "weight", nullable = false, precision = 10, scale = 2)
    open var weight: BigDecimal? = null

    @javax.validation.constraints.NotNull
    @Column(name = "length", nullable = false, precision = 10, scale = 2)
    open var length: BigDecimal? = null

    @javax.validation.constraints.NotNull
    @Column(name = "width", nullable = false, precision = 10, scale = 2)
    open var width: BigDecimal? = null

    @javax.validation.constraints.NotNull
    @Column(name = "height", nullable = false, precision = 10, scale = 2)
    open var height: BigDecimal? = null
}