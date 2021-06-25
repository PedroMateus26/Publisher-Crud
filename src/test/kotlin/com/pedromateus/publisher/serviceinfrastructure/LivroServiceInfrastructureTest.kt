package com.pedromateus.publisher.serviceinfrastructure

import com.pedromateus.publisher.core.model.Livro
import com.pedromateus.publisher.infrastructure.model.LivroEvent
import com.pedromateus.publisher.infrastructure.server.nats.LivroClient
import com.pedromateus.publisher.infrastructure.serviceinfrastructure.LivroServiceInfrastructureImpl
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk

@MicronautTest
class LivroServiceInfrastructureTest:AnnotationSpec() {

    val LivroClient = mockk<LivroClient>()
    val livroServiceInfrastructureImpl= LivroServiceInfrastructureImpl(LivroClient)

    lateinit var livroEvent: LivroEvent
    lateinit var livroSemIEventId: LivroEvent

    @BeforeEach
    fun setUp(){
        livroEvent= LivroEvent(null,"titulo","autor")
        livroSemIEventId= LivroEvent(null,"titulo","autor")

    }

    @Test
    fun `deve enviar um objeto para Nats para salvar`(){
        every { LivroClient.sendLivro(any()) } answers {}
        val result=livroServiceInfrastructureImpl.createLivro(livroSemIEventId)
        result shouldBe Unit
    }

    @Test
    fun `deve enviar um objeto para Nats para atualizar`(){
        every { LivroClient.sendLivro(any()) } answers {}
        val result=livroServiceInfrastructureImpl.updateLivro(livroEvent)
        result shouldBe Unit
    }

    @Test
    fun `deve enviar um objeto para Nats para deletar`(){
        every { LivroClient.sendLivro(any()) } answers {}
        val result=livroServiceInfrastructureImpl.deleteLivro(livroEvent)
        result shouldBe Unit
    }
}