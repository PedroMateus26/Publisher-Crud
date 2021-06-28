package com.pedromateus.publisher.entrypoint

import com.pedromateus.publisher.core.mapper.LivroConverter
import com.pedromateus.publisher.entrypoint.dto.LivroRequestDTO
import com.pedromateus.publisher.core.ports.LivroServicePort
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Put
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.PathVariable
import org.slf4j.LoggerFactory
import java.util.UUID


@Controller("/livros")
class LivroController(
    private val livroServicePort: LivroServicePort,
) {

    private val logger = LoggerFactory.getLogger(this::class.java)


    @Post
    fun livroParaNats(@Body livroRequestDTO: LivroRequestDTO) {
        logger.info("Recebendo livro $livroRequestDTO")
        val livro=LivroConverter.converteDtoParaLivro(livroRequestDTO, null)
        livroServicePort.createLivro(livro)
    }

    @Put("/{id}")
    fun atualizaLivroParaNats(@PathVariable id: UUID, @Body livroRequestDTO: LivroRequestDTO) {
        logger.info("Recebendo livro $livroRequestDTO")
        val livro=LivroConverter.converteDtoParaLivro(livroRequestDTO, id)
        livroServicePort.updateLivro(livro)
    }

    @Delete("/{id}")
    fun deleteLivroParaNats(@PathVariable id: UUID) {
        logger.info("Recebendo livro $id")
        val livro=LivroConverter.converteDtoParaLivro(null, id)
        livroServicePort.deleteLivro(livro)
    }
}