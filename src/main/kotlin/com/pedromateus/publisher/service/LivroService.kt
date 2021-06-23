package com.pedromateus.publisher.service

import com.pedromateus.publisher.controller.dto.LivroRequestDTO
import com.pedromateus.publisher.service.livroevent.EventsInformation
import java.util.*


interface LivroService {
    fun createLivro(livroRequestDTO: LivroRequestDTO)
    fun updateLivro(livroRequestDTO: LivroRequestDTO,id:UUID)
    fun deleteLivro(id:UUID)
}