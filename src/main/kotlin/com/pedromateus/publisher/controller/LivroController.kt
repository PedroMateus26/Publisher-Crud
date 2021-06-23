package com.pedromateus.publisher.controller

import com.pedromateus.publisher.controller.dto.LivroRequestDTO
import com.pedromateus.publisher.server.nats.Events
import com.pedromateus.publisher.service.LivroService
import com.pedromateus.publisher.service.livroevent.EventsInformation
import com.pedromateus.publisher.service.livroevent.LivroEvent
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