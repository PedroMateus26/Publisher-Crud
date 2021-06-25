package com.pedromateus.publisher.core.service

import com.pedromateus.publisher.core.ports.LivroService
import com.pedromateus.publisher.infrastructure.controller.dto.LivroRequestDTO
import com.pedromateus.publisher.infrastructure.server.nats.Events
import com.pedromateus.publisher.infrastructure.server.nats.LivroClient
import com.pedromateus.publisher.infrastructure.controller.livroevent.EventsInformation
import com.pedromateus.publisher.infrastructure.controller.livroevent.LivroEvent
import org.slf4j.LoggerFactory
import java.util.*
import javax.inject.Singleton

@Singleton
class LivroServiceImpl(
    private val livroClient: LivroClient
): LivroService {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun createLivro(livroRequestDTO: LivroRequestDTO) {
        val eventsInformation = EventsInformation(LivroEvent(null, livroRequestDTO), Events.SAVE)
        enviaNats(eventsInformation)
    }

    override fun updateLivro(livroRequestDTO: LivroRequestDTO, id: UUID) {
        val eventsInformation = EventsInformation(LivroEvent(id, livroRequestDTO), Events.UPDATE)
        enviaNats(eventsInformation)
    }

    override fun deleteLivro(id: UUID) {
        val eventsInformation=EventsInformation(LivroEvent(id, null), Events.DELETE)
        enviaNats(eventsInformation)
    }

    private fun enviaNats(eventsInformation:EventsInformation){
        logger.info("Enviando para nats")
        livroClient.sendLivro(eventsInformation)
    }

}