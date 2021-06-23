package com.pedromateus.publisher.service

import com.pedromateus.publisher.controller.dto.LivroRequest
import com.pedromateus.publisher.service.dto.EventsInformation
import java.util.*


interface LivroService {
    fun sendNats(eventsInformation: EventsInformation)
}