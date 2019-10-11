package com.lyhoangvinh.validationwithlivedata.ui.base.interfaces

import com.lyhoangvinh.validationwithlivedata.data.entities.Entities
import io.reactivex.annotations.NonNull

interface PlainEntitiesPagingConsumer<E,T : Entities<E>> {
    fun accept(@NonNull t: List<E>)
}