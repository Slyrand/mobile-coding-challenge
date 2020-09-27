package com.yogasolo.domain.postures

import arrow.core.Either
import com.yogasolo.domain.postures.model.Posture

interface IPostureRepository {
    fun getPostures(): Either<Exception, List<Posture>>
}