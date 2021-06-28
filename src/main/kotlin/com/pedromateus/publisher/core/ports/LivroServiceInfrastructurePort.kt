package com.pedromateus.publisher.core.ports

import com.pedromateus.publisher.infrastructure.model.LivroEvent

interface LivroServiceInfrastructurePort {
    fun createLivro(livroEvent: LivroEvent)
    fun updateLivro(livroEvent: LivroEvent)
    fun deleteLivro(livroEvent: LivroEvent)
}