package com.upao.crimenintent.modelo

import java.util.Date
import java.util.UUID

data class Crimen(
    val id: UUID,
    val titulo: String,
    val fecha: Date,
    val resuelto: Boolean
)
