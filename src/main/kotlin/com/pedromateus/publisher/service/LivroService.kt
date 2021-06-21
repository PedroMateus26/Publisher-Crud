package com.pedromateus.publisher.service

import com.pedromateus.publisher.controller.dto.LivroRequest
import javax.inject.Singleton

@Singleton
interface LivroService {

    fun cadastraLivro(livroRequest:LivroRequest)
}