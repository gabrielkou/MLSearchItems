package com.gabrielkou.remote.model

import java.math.BigInteger

data class AttributesItem(val attributeGroupId: String = "",
                          val name: String = "",
                          val attributeGroupName: String = "",
                          val source: BigInteger = BigInteger.ZERO,
                          val id: String = "",
                          val valueId: String = "",
                          val valueStruct: Any? = null,
                          val valueName: String = "")