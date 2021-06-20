package id.chirikualii.movie_catalog_android_jetpack_pro.abstraction

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Chiriku Alii on 6/4/21.
 * github.com/chirikualii
 */

abstract class BaseViewModel<State> : ViewModel() {

    protected val TAG = this.javaClass.simpleName
    protected val _state = MutableLiveData<State>()

    val state: LiveData<State>
        get() = _state
}