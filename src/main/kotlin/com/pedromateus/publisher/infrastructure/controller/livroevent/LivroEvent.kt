package com.pedromateus.publisher.infrastructure.controller.livroevent

import com.pedromateus.publisher.infrastructure.controller.dto.LivroRequestDTO
import java.util.*

class LivroEvent(
    val id: UUID?,
    val livroRequestDTO: LivroRequestDTO?
)