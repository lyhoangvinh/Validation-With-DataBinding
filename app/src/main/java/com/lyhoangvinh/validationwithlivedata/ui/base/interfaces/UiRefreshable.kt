package com.lyhoangvinh.validationwithlivedata.ui.base.interfaces

import com.lyhoangvinh.validationwithlivedata.ui.base.interfaces.Refreshable

interface UiRefreshable : Refreshable {
    fun doneRefresh()
    fun refreshWithUi()
    fun refreshWithUi(delay: Long)
}
