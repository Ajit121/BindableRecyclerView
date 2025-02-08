package com.aj.bindablerecyclerview.coreui

sealed class ScreenState <out T>{
    data object Initial: ScreenState<Nothing>()
    data object Loading: ScreenState<Nothing>()
    class Loaded<T>(val state: T): ScreenState<T>()
}