package com.pedromateus.publisher.service.livroevent

import com.pedromateus.publisher.controller.dto.LivroRequestDTO
import java.util.*

class LivroEvent(
    val id: UUID?,
    val livroRequestDTO: LivroRequestDTO?
)