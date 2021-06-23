package com.pedromateus.publisher.service.dto

import com.pedromateus.publisher.controller.dto.LivroRequest
import java.util.*

class LivroEvent(
    val id: UUID?,
    val livroRequest: LivroRequest?
)