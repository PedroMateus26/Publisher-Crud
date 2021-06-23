package com.pedromateus.publisher.server.nats

import com.pedromateus.publisher.service.livroevent.EventsInformation
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface LivroClient {

    @Subject("livro.estoque.reposicao",)
    fun sendLivro(eventsInformation: EventsInformation)

}
