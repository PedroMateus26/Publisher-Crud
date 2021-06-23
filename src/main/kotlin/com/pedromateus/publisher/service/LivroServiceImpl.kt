package com.pedromateus.publisher.service

import com.pedromateus.publisher.controller.client.BuscaLivros
import com.pedromateus.publisher.controller.dto.LivroRequest
import com.pedromateus.publisher.server.nats.LivroClient
import com.pedromateus.publisher.service.dto.EventsInformation
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroServiceImpl(
    private val livroClient: LivroClient,
    private val livros: BuscaLivros
):LivroService{

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun sendNats(eventsInformation: EventsInformation) {
        logger.info("Enviando para nats")
        livroClient.sendLivro(eventsInformation)
    }

}