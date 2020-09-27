package com.yogasolo.data.postures.network.model

import com.yogasolo.domain.postures.model.Posture

data class ApiPosture(
    val _id: String?,
    val name: String?,
    val teacher: String?,
    val duration: String?,
    val picture: String?,
    val description: String?
) {

    fun mapToDomain(): Posture = Posture(
        id = _id ?: "",
        name = name ?: "",
        teacher = teacher ?: "",
        duration = duration ?: "",
        picture = picture ?: "",
        description = description ?: ""
    )
}