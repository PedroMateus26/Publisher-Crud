package com.pedromateus.publisher.infrastructure.model

import com.pedromateus.publisher.entrypoint.dto.LivroRequestDTO
import java.util.UUID

class LivroEvent(
    val id: UUID?,
    val titulo:String?,
    val autor:String?
)