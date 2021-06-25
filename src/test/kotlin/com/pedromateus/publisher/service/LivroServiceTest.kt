package com.pedromateus.publisher.service

import com.pedromateus.publisher.core.model.Livro
import com.pedromateus.publisher.core.service.LivroServicePortImpl
import com.pedromateus.publisher.infrastructure.serviceinfrastructure.LivroServiceInfrastructureImpl
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk

@MicronautTest
class LivroServiceTest: AnnotationSpec() {
    val livroServiceImpl = mockk<LivroServiceInfrastructureImpl>()
    val livroService= LivroServicePortImpl(livroServiceImpl)

    lateinit var livro: Livro
    lateinit var livroSemID: Livro

    @BeforeEach
    fun setUp(){
        livro= Livro(null,"titulo","autor")
        livroSemID= Livro(null,"titulo","autor")

    }

    @Test
    fun `deve enviar um objeto para infrastructurer com objetivo de salvar`(){
        every { livroServiceImpl.createLivro(any()) } answers {}
        val result=livroService.createLivro(livroSemID)
        result shouldBe Unit
    }

    @Test
    fun `deve enviar um objeto para infrastructurer com objetivo de realizar um update`(){
        every { livroServiceImpl.updateLivro(any()) } answers {}
        val result=livroService.updateLivro(livro)
        result shouldBe Unit
    }

    @Test
    fun `deve enviar um livro para infrastructure para operação de deleção`(){
        every { livroServiceImpl.deleteLivro(any()) } answers {}
        val result=livroService.deleteLivro(livro)
        result shouldBe Unit
    }
}