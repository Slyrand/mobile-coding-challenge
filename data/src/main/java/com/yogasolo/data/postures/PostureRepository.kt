package com.yogasolo.data.postures

import arrow.core.Either
import com.yogasolo.data.postures.network.PostureNetworkDataSource
import com.yogasolo.domain.postures.IPostureRepository
import com.yogasolo.domain.postures.model.Posture

class PostureRepository(
    private val networkDataSource: PostureNetworkDataSource
) : IPostureRepository {

    override fun getPostures(): Either<Exception, List<Posture>> =
        networkDataSource.getPostures()
}