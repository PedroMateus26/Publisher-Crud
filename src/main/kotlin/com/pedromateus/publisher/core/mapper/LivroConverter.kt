package com.pedromateus.publisher.core.mapper

import com.pedromateus.publisher.core.model.Livro
import com.pedromateus.publisher.entrypoint.dto.LivroRequestDTO
import com.pedromateus.publisher.infrastructure.model.LivroEvent
import java.util.*

class LivroConverter {

    companion object{
        fun converteDtoParaLivro(livroRequestDTO: LivroRequestDTO?, id: UUID?)=Livro(id,livroRequestDTO?.titulo,livroRequestDTO?.autor)
        fun converteLivroParaLivroEvent(livro: Livro?)=LivroEvent(livro?.id,livro?.titulo,livro?.autor)
    }
}