package com.pedromateus.publisher.service

import com.pedromateus.publisher.controller.dto.LivroRequest
import com.pedromateus.publisher.server.nats.LivroClient

class LivroServiceImpl(private val livroClient: LivroClient):LivroService{

    override fun cadastraLivro(livroRequest: LivroRequest) {
        livroClient.sendLivro(livroRequest.LivroRequestParaLivroResponse())
    }

}