package com.lyhoangvinh.validationwithdatabinding.ui.base.activity

import android.os.Bundle
import androidx.annotation.VisibleForTesting
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.lyhoangvinh.validationwithdatabinding.data.entities.State
import com.lyhoangvinh.validationwithdatabinding.data.entities.Status
import com.lyhoangvinh.validationwithdatabinding.ui.base.viewmodel.BaseViewModel
import com.lyhoangvinh.validationwithdatabinding.utils.genericCastOrNull

import java.lang.reflect.ParameterizedType
import javax.inject.Inject

abstract class BaseViewModelActivity<B : ViewDataBinding, VM : BaseViewModel> : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    @VisibleForTesting
    lateinit var binding: B

    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayoutResource())
        // noinspection unchecked
        val viewModelClass =
            genericCastOrNull<Class<VM>>((javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[1]) // 1 is BaseViewModel
        viewModel = ViewModelProviders.of(this, viewModelFactory)[viewModelClass]

        viewModel.onCreate(this, intent.extras)
        viewModel.stateLiveData.observe(this, Observer { handleState(it) })
    }

    /**
     * Default state handling, can be override
     * @param state viewModel's state
     */
    open fun handleState(state: State?) {
        setLoading(state != null && state.status == Status.LOADING)
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.onDestroyView()
    }

    override fun shouldUseDataBinding() = true
}