package UnitTest;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

import src.models.Filme;
import src.models.Final;
public class FinalTest extends TestConfig {
   
    @Test
    public void deveLancarExcecao_QuandoTiverMaisDe2Participantes() throws Exception {
        var participantes = gerarFilmes(0, 3, 20);

        var exception = assertThrows(ExceptionInInitializerError.class,
                () -> new Final(participantes));

        assertEquals("Para realizar a final é necessário ter 2 filmes", exception.getMessage());
    }

    @Test
    public void deveLancarExcecao_QuandoParticipanteEInvalido() throws Exception {
        List<Filme> participantes = gerarFilmes(1, 2, 2);

        var exception = assertThrows(ExceptionInInitializerError.class,
                () -> new Final(participantes));

        assertEquals("Participante deve ser valido", exception.getMessage());
    }

    @Test
    public void naoDeveLancarExcecao_QuandoInformarOsParticipantesValidos() {
        List<Filme> participantes = gerarFilmes(0, 2, 2);

        assertDoesNotThrow(() -> new Final(participantes));
    }

    @Test
    public void deveRetornarOGanhadorComAMaiorNota_QuandoInformarParticipantesValidos() throws Exception {
        List<Filme> participantes = gerarFilmes(0, 2, 2);

        var ganhadoresDaFinal = new Final(participantes).competir();

       
        assertTrue(participantes.get(0).equals(ganhadoresDaFinal));
    }
}
