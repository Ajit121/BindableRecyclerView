package com.aj.bindablerecyclerview.coreui

abstract class UseCase< Params, ReturnType> {
    abstract suspend operator fun invoke(params: Params): ReturnType
}

class NoParams