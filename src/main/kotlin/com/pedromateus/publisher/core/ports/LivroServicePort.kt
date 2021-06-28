package com.pedromateus.publisher.core.ports

import com.pedromateus.publisher.core.model.Livro


interface LivroServicePort {
    fun createLivro(livro:Livro)
    fun updateLivro(livro:Livro)
    fun deleteLivro(livro:Livro)
}