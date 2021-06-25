package com.pedromateus.publisher.core.ports

import com.pedromateus.publisher.core.model.Livro
import com.pedromateus.publisher.infrastructure.model.LivroEvent
import java.util.*

interface LivroServiceInfrastructurePort {
    fun createLivro(livroEvent: LivroEvent)
    fun updateLivro(livroEvent: LivroEvent)
    fun deleteLivro(livroEvent: LivroEvent)
}