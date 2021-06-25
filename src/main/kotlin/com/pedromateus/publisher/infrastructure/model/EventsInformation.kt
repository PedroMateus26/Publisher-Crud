package com.pedromateus.publisher.infrastructure.model

import com.pedromateus.publisher.infrastructure.server.nats.Events

class EventsInformation(
    val livroEvent: LivroEvent,
    val event: Events
)