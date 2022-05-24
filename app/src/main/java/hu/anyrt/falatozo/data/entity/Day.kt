package hu.anyrt.falatozo.data.entity

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class Day(
    @Id
    var id: Long = 0,
    val day: String,
    val date: String,
    val weekNumber: Int,
    val isSelected: Boolean
)
