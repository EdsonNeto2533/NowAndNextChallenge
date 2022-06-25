package com.mctable.nowandnextchallenge.commons.utils.interfaces

interface IMapper<T, X> {
    fun transform(data: T): X
}