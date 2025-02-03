package org.fors.wwms.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

@Entity
@Table(name = "idoc_fields")
data class IdocField(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "field_id")
    val fieldId: Int? = null,  // Unique ID for each field

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "segment_id", nullable = false)
    val segment: IdocSegment,  // Foreign Key to the segment

    @field:NotNull
    @field:Size(max = 100)
    @Column(name = "field_name", nullable = false)
    val fieldName: String,  // Name of the field (e.g., MATERIAL)

    @field:NotNull
    @field:Size(max = 255)
    @Column(name = "field_value", nullable = false)
    val fieldValue: String,  // Value of the field

    @Column(name = "field_length")
    val fieldLength: Int? = null,  // Max length of the field (e.g., 18 for MATERIAL)

    @field:Size(max = 255)
    @Column(name = "allowed_values")
    val allowedValues: String? = null  // Optional: Comma-separated list of allowed values (for enum fields)
) {

    // Custom equals implementation using the primary key (fieldId)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as IdocField
        return fieldId == other.fieldId
    }

    // Custom hashCode implementation using the primary key (fieldId)
    override fun hashCode(): Int {
        return fieldId ?: 0
    }

    // Custom toString implementation
    override fun toString(): String {
        return "IdocField(fieldId=$fieldId, fieldName='$fieldName', fieldValue='$fieldValue', fieldLength=$fieldLength, allowedValues='$allowedValues')"
    }
}
