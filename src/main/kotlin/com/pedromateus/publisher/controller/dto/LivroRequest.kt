package com.pedromateus.publisher.controller.dto

import com.pedromateus.publisher.controller.Events

data class LivroRequest(
    val titulo:String,
    val autor:String
)