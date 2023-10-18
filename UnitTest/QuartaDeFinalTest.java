package UnitTest;

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
import src.models.QuartaDeFinal;

public class QuartaDeFinalTest extends TestConfig {

    @Test
    public void deveLancarExcecao_QuandoTiverMaisDe8Participantes() throws Exception {
        var participantes = gerarFilmes(0, 9, 20);

        var exception = assertThrows(ExceptionInInitializerError.class,
                () -> new QuartaDeFinal(participantes));

        assertEquals("Para realizar a quarta de final é necessário ter 8 filmes", exception.getMessage());
    }

    @Test
    public void deveLancarExcecao_QuandoParticipanteEInvalido() throws Exception {
        List<Filme> participantes = gerarFilmes(1, 8, 8);

        var exception = assertThrows(ExceptionInInitializerError.class,
                () -> new QuartaDeFinal(participantes));

        assertEquals("Participante deve ser valido", exception.getMessage());
    }

    @Test
    public void naoDeveLancarExcecao_QuandoInformarOsParticipantesValidos() {
        List<Filme> participantes = gerarFilmes(0, 8, 8);

        assertDoesNotThrow(() -> new QuartaDeFinal(participantes));
    }

    @Test
    public void deveRetornarQuatroGanhadoresComAsMaioresNotas_QuandoInformarParticipantesValidos() throws Exception {
        List<Filme> participantes = gerarFilmes(0, 8, 8);

        var ganhadoresDaQuartaDeFinal = new QuartaDeFinal(participantes).competir();

        participantes.sort(Comparator.comparingDouble(Filme::getNota).reversed());
        var ganhadoresEsperados = IntStream.range(0, participantes.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(participantes::get)
                .collect(Collectors.toList());
        assertTrue(ganhadoresEsperados.containsAll(ganhadoresDaQuartaDeFinal));
        assertEquals(4, ganhadoresDaQuartaDeFinal.size());
    }

}
