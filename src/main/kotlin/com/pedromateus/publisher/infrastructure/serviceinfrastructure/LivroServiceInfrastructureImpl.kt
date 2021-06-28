package com.pedromateus.publisher.infrastructure.serviceinfrastructure

import com.pedromateus.publisher.core.ports.LivroServiceInfrastructurePort
import com.pedromateus.publisher.infrastructure.model.EventsInformation
import com.pedromateus.publisher.infrastructure.model.LivroEvent
import com.pedromateus.publisher.infrastructure.model.Events
import com.pedromateus.publisher.infrastructure.server.nats.LivroClient
import javax.inject.Singleton

@Singleton
class LivroServiceInfrastructureImpl(private val livroClient: LivroClient):LivroServiceInfrastructurePort {

    override fun createLivro(livroEvent: LivroEvent) {
        livroClient.sendLivro(EventsInformation(livroEvent, Events.SAVE))
    }

    override fun updateLivro(livroEvent: LivroEvent) {
        livroClient.sendLivro(EventsInformation(livroEvent, Events.UPDATE))
    }

    override fun deleteLivro(livroEvent: LivroEvent) {
        livroClient.sendLivro(EventsInformation(livroEvent, Events.DELETE))
    }

}