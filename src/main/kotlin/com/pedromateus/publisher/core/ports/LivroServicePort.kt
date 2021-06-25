package com.pedromateus.publisher.core.ports

import com.pedromateus.publisher.core.model.Livro
import com.pedromateus.publisher.entrypoint.dto.LivroRequestDTO
import java.util.*


interface LivroServicePort {
    fun createLivro(livro:Livro)
    fun updateLivro(livro:Livro)
    fun deleteLivro(livro:Livro)
}