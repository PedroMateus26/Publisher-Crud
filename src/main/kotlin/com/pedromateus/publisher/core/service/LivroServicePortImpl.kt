package com.pedromateus.publisher.core.service

import com.pedromateus.publisher.core.mapper.LivroConverter
import com.pedromateus.publisher.core.model.Livro
import com.pedromateus.publisher.core.ports.LivroServiceInfrastructurePort
import com.pedromateus.publisher.core.ports.LivroServicePort
import org.slf4j.LoggerFactory
import javax.inject.Singleton

@Singleton
class LivroServicePortImpl(
    private val livroLivroServiceInfrastructurePort: LivroServiceInfrastructurePort
): LivroServicePort {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun createLivro(livro:Livro) {
        val livroEvent = LivroConverter.converteLivroParaLivroEvent(livro)
        livroLivroServiceInfrastructurePort.createLivro(livroEvent)
    }

    override fun updateLivro(livro:Livro) {
        val livroEvent = LivroConverter.converteLivroParaLivroEvent(livro)
        livroLivroServiceInfrastructurePort.updateLivro(livroEvent)
    }

    override fun deleteLivro(livro:Livro) {
        val livroEvent = LivroConverter.converteLivroParaLivroEvent(livro)
        livroLivroServiceInfrastructurePort.deleteLivro(livroEvent)
    }



}