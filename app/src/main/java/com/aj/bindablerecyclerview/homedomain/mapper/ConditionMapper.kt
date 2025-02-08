package com.aj.bindablerecyclerview.homedomain.mapper

import com.aj.bindablerecyclerview.coreui.orEmpty
import com.aj.bindablerecyclerview.homedata.model.ConditionModel
import com.aj.bindablerecyclerview.homedomain.entity.ConditionEntity

fun ConditionModel.toDomain() = ConditionEntity(
    text = this.text.orEmpty(),
    icon =  this.icon.orEmpty(),
    code = this.code.orEmpty()
)