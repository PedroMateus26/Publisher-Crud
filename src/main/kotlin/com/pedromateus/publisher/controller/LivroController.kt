package com.pedromateus.publisher.controller

import com.pedromateus.publisher.controller.client.BuscaLivros
import com.pedromateus.publisher.controller.dto.LivroRequest
import com.pedromateus.publisher.service.LivroService
import com.pedromateus.publisher.service.dto.EventsInformation
import com.pedromateus.publisher.service.dto.LivroEvent
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.http.client.annotation.Client
import org.slf4j.LoggerFactory
import java.util.*

@Controller("/livros")
class LivroController(
    private val livroService: LivroService,
    private val buscaLivros: BuscaLivros
) {

    private val logger = LoggerFactory.getLogger(this::class.java)

    @Get
    fun findAll():HttpResponse<List<LivroEvent>> = HttpResponse.ok(buscaLivros.findAllLivros())

    @Get("/{id}")
    fun findById(@PathVariable id:UUID): HttpResponse<LivroEvent> =HttpResponse.ok(buscaLivros.findById(id))


    @Post
    fun livroParaNats(@Body livroRequest: LivroRequest) {
        val eventsInformation = EventsInformation(LivroEvent(null, livroRequest), Events.SAVE)
        logger.info("Recebendo livro $livroRequest")
        livroService.sendNats(eventsInformation = eventsInformation)
    }

    @Put("/{id}")
    fun atualizaLivroParaNats(@PathVariable id: UUID, @Body livroRequest: LivroRequest) {
        val eventsInformation = EventsInformation(LivroEvent(id, livroRequest), Events.UPDATE)
        logger.info("Recebendo livro $livroRequest")
        livroService.sendNats(eventsInformation = eventsInformation)
    }

    @Delete("/{id}")
    fun deleteLivroParaNats(@PathVariable id: UUID) {
        logger.info("Recebendo livro $id")
        livroService.sendNats(EventsInformation(LivroEvent(id, null), Events.DELETE))
    }
}