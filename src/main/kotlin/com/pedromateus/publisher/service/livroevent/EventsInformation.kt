package com.pedromateus.publisher.service.livroevent

import com.pedromateus.publisher.server.nats.Events

class EventsInformation(
    val livroEvent: LivroEvent,
    val event: Events
)