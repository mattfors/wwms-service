package org.fors.wwms.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull

@Entity
@Table(name = "idoc_segments")
data class IdocSegment(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "segment_id")
    val segmentId: Int? = null,  // Unique ID for each segment

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idoc_id", nullable = false)
    val idocHeader: IdocHeader,  // Foreign Key to the IDoc header

    @field:NotNull
    @Column(name = "segment_name", nullable = false)
    val segmentName: String,  // Name of the segment (e.g., E1MARAM)

    @field:NotNull
    @Column(name = "segment_order", nullable = false)
    val segmentOrder: Int  // The order/position of the segment in the IDoc
) {

    // Custom equals implementation using the primary key (segmentId)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as IdocSegment
        return segmentId == other.segmentId
    }

    // Custom hashCode implementation using the primary key (segmentId)
    override fun hashCode(): Int {
        return segmentId ?: 0
    }

    // Custom toString implementation
    override fun toString(): String {
        return "IdocSegment(segmentId=$segmentId, segmentName='$segmentName', segmentOrder=$segmentOrder)"
    }
}
