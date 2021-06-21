package com.pedromateus.publisher.controller.dto

data class LivroRequest(
    val titulo:String,
    val autor:String
){
    fun LivroRequestParaLivroResponse()=LivroResponse(titulo,autor)
}