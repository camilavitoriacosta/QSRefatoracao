package UnitTest;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.InetAddress;

import org.junit.jupiter.api.Test;

import src.models.ExcecaoDeDominio;

public class ExcecaoDeDominioTest {

    @Test
    public void deveLancarExcecao() {
        var excecaoLancada = new ExcecaoDeDominio();
        var mensagemDeErro = "excecao lancada pelo dominio";
        var exception = assertThrows(ExceptionInInitializerError.class,
                () -> excecaoLancada.Quando(true, mensagemDeErro).Lancar());
        assertEquals(mensagemDeErro, exception.getMessage());

    }

    @Test
    public void naoDeveLancarExcecao() {
        var excecaoDeDominio = new ExcecaoDeDominio();
        assertDoesNotThrow(() -> excecaoDeDominio.Quando(false, "erro").Lancar());

    }

}