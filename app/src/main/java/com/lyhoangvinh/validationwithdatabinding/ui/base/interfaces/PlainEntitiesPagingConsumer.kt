package com.lyhoangvinh.validationwithdatabinding.ui.base.interfaces

import com.lyhoangvinh.validationwithdatabinding.data.entities.Entities
import io.reactivex.annotations.NonNull

interface PlainEntitiesPagingConsumer<E,T : Entities<E>> {
    fun accept(@NonNull t: List<E>)
}