package com.pedromateus.publisher.controller

import com.pedromateus.publisher.controller.dto.LivroRequest
import com.pedromateus.publisher.server.service.NatsService
import com.pedromateus.publisher.service.LivroService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import org.slf4j.LoggerFactory

@Controller("/livros")
class LivroController (private val livroService:LivroService){

    private val logger =LoggerFactory.getLogger(this::class.java)

    @Post
    fun LivroParaNats(@Body livroRequest: LivroRequest){
        logger.info("Recebendo livro $livroRequest")
        val livroResponse=livroRequest.LivroRequestParaLivroResponse()
        livroService.cadastraLivro(livroRequest)
    }
}