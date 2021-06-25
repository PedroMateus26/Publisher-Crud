package com.pedromateus.publisher.core.ports

import com.pedromateus.publisher.infrastructure.controller.dto.LivroRequestDTO
import java.util.*


interface LivroService {
    fun createLivro(livroRequestDTO: LivroRequestDTO)
    fun updateLivro(livroRequestDTO: LivroRequestDTO, id:UUID)
    fun deleteLivro(id:UUID)
}