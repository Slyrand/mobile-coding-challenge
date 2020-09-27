package com.yogasolo.data.postures.network

import arrow.core.Either
import com.yogasolo.data.core.NetworkDataSource
import com.yogasolo.domain.postures.model.Posture

class PostureNetworkDataSource(
    private val service: PostureService
) : NetworkDataSource() {

    fun getPostures(): Either<Exception, List<Posture>> = handleCall {
        service.getPostures()
    }.map { postureList -> postureList.map { it.mapToDomain() } }
}