package com.pedromateus.publisher.controller.client

import com.pedromateus.publisher.service.dto.LivroEvent
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.client.annotation.Client
import java.util.*

@Client( "http://localhost:8082/busca.livros")
interface BuscaLivros {

    @Get("/{id}")
    fun findById(@PathVariable id: UUID):LivroEvent

    @Get
    fun findAllLivros():List<LivroEvent>

}