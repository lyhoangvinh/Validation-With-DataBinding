package com.lyhoangvinh.validationwithlivedata.ui.base.viewmodel

import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.util.Log
import androidx.annotation.CallSuper
import androidx.annotation.NonNull
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import com.lyhoangvinh.validationwithlivedata.data.entities.ErrorEntity
import com.lyhoangvinh.validationwithlivedata.data.entities.State
import com.lyhoangvinh.validationwithlivedata.utils.SafeMutableLiveData
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.annotation.Resource

abstract class BaseViewModel : ViewModel() {

    @NonNull
    protected var mCompositeDisposable = CompositeDisposable()

    @NonNull
    var stateLiveData = SafeMutableLiveData<State>()

    private var isFirstTimeUiCreate = true

    protected lateinit var lifecycleOwner: LifecycleOwner

    /**
     * called after fragment / activity is created with input bundle arguments
     * @param bundle argument data
     */
    @CallSuper
    fun onCreate(lifecycleOwner: LifecycleOwner, bundle: Bundle?) {
        this.lifecycleOwner = lifecycleOwner
        if (isFirstTimeUiCreate) {
            onFirstTimeUiCreate(lifecycleOwner, bundle)
            isFirstTimeUiCreate = false
        }
    }

    /**
     * Called when UI create for first time only, since activity / fragment might be rotated,
     * we don't need to re-init data, because view model will survive, data aren't destroyed
     * @param bundle
     */
    abstract fun onFirstTimeUiCreate(lifecycleOwner: LifecycleOwner, bundle: Bundle?)

    /**
     * It is importance to un-reference activity / fragment instance after they are destroyed
     * For situation of configuration changes, activity / fragment will be destroyed and recreated,
     * but view model will survive, so if we don't un-reference them, memory leaks will occur
     */
    open fun onDestroyView() {

    }

    @CallSuper
    override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.dispose()
    }

    fun disposeAllExecutions() {
        mCompositeDisposable.dispose()
        mCompositeDisposable = CompositeDisposable()
        publishState(State.success(null))
    }

    fun publishState(state: State) {
        stateLiveData.setValue(state)
        if (!TextUtils.isEmpty(state.message)) {
            // if state has a message, after show it, we should reset to prevent
            // message will still be shown if fragment / activity is rotated (re-observe state live data)
            Handler().postDelayed({ stateLiveData.setValue(State.success(null)) }, 100)
        }
    }
}