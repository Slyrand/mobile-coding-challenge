package com.yogasolo.domain.postures.model

import java.io.Serializable

data class Posture(
    val id: String,
    val name: String,
    val teacher: String,
    val duration: String,
    val picture: String,
    val description: String
): Serializable