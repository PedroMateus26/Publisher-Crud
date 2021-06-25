package com.pedromateus.publisher.service

import com.pedromateus.publisher.core.service.LivroServiceImpl
import com.pedromateus.publisher.infrastructure.controller.dto.LivroRequestDTO
import com.pedromateus.publisher.infrastructure.server.nats.LivroClient
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class NatsServiceTest: AnnotationSpec() {
    val publisher = mockk<LivroClient>()
    val natsService= LivroServiceImpl(publisher)

    lateinit var livroRequestDTO: LivroRequestDTO

    @BeforeEach
    fun setUp(){
        livroRequestDTO= LivroRequestDTO("titulo","autor")
    }

    @Test
    fun `deve enviar um objeto para o nats e salvar`(){
        every { publisher.sendLivro(any()) } answers {}
        val result=natsService.createLivro(livroRequestDTO)
        result shouldBe Unit
    }

    @Test
    fun `deve enviar o objeto e o id fornecido e atualizar o objeto no banco`(){
        every { publisher.sendLivro(any()) } answers {}
        val result=natsService.updateLivro(livroRequestDTO,UUID.randomUUID())
        result shouldBe Unit
    }

    @Test
    fun `deve enviar um id fornecido e deletar o objeto com id igual`(){
        every { publisher.sendLivro(any()) } answers {}
        val result=natsService.deleteLivro(UUID.randomUUID())
        result shouldBe Unit
    }
}