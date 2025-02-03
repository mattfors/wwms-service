package org.fors.wwms.entity

import jakarta.persistence.*

@Entity
@Table(name = "description")
open class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "description_id", nullable = false)
    open var id: Int? = null

    @javax.validation.constraints.Size(max = 255)
    @javax.validation.constraints.NotNull
    @Column(name = "short_desc", nullable = false)
    open var shortDesc: String? = null

    @javax.validation.constraints.NotNull
    @Lob
    @Column(name = "long_desc", nullable = false)
    open var longDesc: String? = null
}