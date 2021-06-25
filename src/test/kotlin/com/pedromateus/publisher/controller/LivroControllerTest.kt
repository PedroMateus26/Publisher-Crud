package com.pedromateus.publisher.controller

import com.pedromateus.publisher.infrastructure.controller.dto.LivroRequestDTO
import com.pedromateus.publisher.infrastructure.controller.LivroController
import com.pedromateus.publisher.core.ports.LivroService
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*


@MicronautTest
class LivroControllerTest : AnnotationSpec() {

    val livroService = mockk<LivroService>()
    val controller = LivroController(livroService)

    lateinit var livroRequestDTO: LivroRequestDTO

    @BeforeEach
    fun setUp() {
        livroRequestDTO = LivroRequestDTO("titulo", "autor")
    }

    @Test
    fun `deve enviar o objeto para service para nats para salvar no banco`() {
        every { livroService.createLivro(any()) } answers {}
        val result = controller.livroParaNats(livroRequestDTO)
        result shouldBe Unit
    }

    @Test
    fun `deve enviar um id e um objeto para service para nats para fazer o update`() {
        every { livroService.updateLivro(any(),any()) } answers {}
        val result = controller.atualizaLivroParaNats(UUID.randomUUID(),livroRequestDTO)
        result shouldBe Unit
    }

    @Test
    fun `deve enviar um id para o service para enviar para o nats para deletar no banco`() {
        every { livroService.deleteLivro(any()) } answers {}
        val result = controller.deleteLivroParaNats(UUID.randomUUID())
        result shouldBe Unit
    }

}