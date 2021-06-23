package com.pedromateus.publisher.controller

import com.pedromateus.publisher.controller.dto.LivroRequest
import com.pedromateus.publisher.service.LivroService
import io.kotest.core.spec.style.AnnotationSpec
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk


@MicronautTest
class LivroControllerTest : AnnotationSpec() {

    val livroService = mockk<LivroService>()
    val controller = LivroController(livroService)

    lateinit var livroRequest: LivroRequest

    @BeforeEach
    fun setUp() {
        livroRequest = LivroRequest("titulo", "autor", Events.SAVE)
    }

    @Test
    fun `deve enviar o objeto para service`() {
        every { livroService.cadastraLivro(livroRequest) } answers {}
        val result = controller.LivroParaNats(livroRequest)
        result shouldBe Unit
    }

}