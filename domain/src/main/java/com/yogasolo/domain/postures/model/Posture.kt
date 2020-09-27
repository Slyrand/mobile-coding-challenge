package com.yogasolo.domain.postures.model

data class Posture(
    val id: String,
    val name: String,
    val teacher: String,
    val duration: String,
    val picture: String,
    val description: String
)