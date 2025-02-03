package org.fors.wwms.entity

import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.util.*

@Entity
@Table(name = "idoc_header")
data class IdocHeader(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idoc_id")
    val idocId: Int? = null,  // Unique ID for the IDoc instance

    @field:NotNull
    @field:Size(max = 8)
    @Column(name = "idoctype", nullable = false)
    val idoctype: String,  // IDoc Type (e.g., MATMAS03)

    @field:NotNull
    @field:Size(max = 6)
    @Column(name = "message_type", nullable = false)
    val messageType: String,  // Message Type (e.g., MATMAS)

    @field:NotNull
    @field:Size(max = 10)
    @Column(name = "sender_partner", nullable = false)
    val senderPartner: String,  // Sender Partner number

    @field:NotNull
    @field:Size(max = 10)
    @Column(name = "receiver_partner", nullable = false)
    val receiverPartner: String,  // Receiver Partner number

    @field:NotNull
    @field:Size(max = 20)
    @Column(name = "status", nullable = false)
    val status: String = "NEW",  // IDoc status (e.g., "processed")

    @field:NotNull
    @Column(name = "creation_date", nullable = false)
    val creationDate: Date,  // Date when the IDoc was created

    @Column(name = "processed_date")
    val processedDate: Date? = null  // Date when the IDoc was processed
) {

    // Custom equals implementation using the primary key (idocId)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as IdocHeader
        return idocId == other.idocId
    }

    // Custom hashCode implementation using the primary key (idocId)
    override fun hashCode(): Int {
        return idocId ?: 0
    }

    // Custom toString implementation
    override fun toString(): String {
        return "IdocHeader(idocId=$idocId, idoctype='$idoctype', messageType='$messageType', senderPartner='$senderPartner', receiverPartner='$receiverPartner', status='$status', creationDate=$creationDate, processedDate=$processedDate)"
    }
}

