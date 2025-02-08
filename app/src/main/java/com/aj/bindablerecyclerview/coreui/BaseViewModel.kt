package com.aj.bindablerecyclerview.coreui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<Event,State>: ViewModel() {
    private val _state = SingleEventLiveData<ScreenState<State>>()
    val state:LiveData<ScreenState<State>> = _state

    fun dispatchEvent(event: Event){
        handleEvent(event)
    }

    protected open fun handleEvent(event: Event){}

    protected fun postLoadingState(){
        _state.postValue(ScreenState.Loading)
    }

    protected fun postState(state: State){
        _state.postValue(ScreenState.Loaded(state))
    }
}