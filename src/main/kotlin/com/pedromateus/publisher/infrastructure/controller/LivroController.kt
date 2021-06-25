package com.pedromateus.publisher.infrastructure.controller

import com.pedromateus.publisher.infrastructure.controller.dto.LivroRequestDTO
import com.pedromateus.publisher.core.ports.LivroService
import io.micronaut.http.annotation.*
import org.slf4j.LoggerFactory
import java.util.*

@Controller("/livros")
class LivroController(
    private val livroService: LivroService,
) {

    private val logger = LoggerFactory.getLogger(this::class.java)


    @Post
    fun livroParaNats(@Body livroRequestDTO: LivroRequestDTO) {

        logger.info("Recebendo livro $livroRequestDTO")
        livroService.createLivro(livroRequestDTO)
    }

    @Put("/{id}")
    fun atualizaLivroParaNats(@PathVariable id: UUID, @Body livroRequestDTO: LivroRequestDTO) {
        logger.info("Recebendo livro $livroRequestDTO")
        livroService.updateLivro(livroRequestDTO,id)
    }

    @Delete("/{id}")
    fun deleteLivroParaNats(@PathVariable id: UUID) {
        logger.info("Recebendo livro $id")
        livroService.deleteLivro(id)
    }
}