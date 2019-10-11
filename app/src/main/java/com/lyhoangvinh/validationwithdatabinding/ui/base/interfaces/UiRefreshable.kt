package com.lyhoangvinh.validationwithdatabinding.ui.base.interfaces

interface UiRefreshable : Refreshable {
    fun doneRefresh()
    fun refreshWithUi()
    fun refreshWithUi(delay: Long)
}
