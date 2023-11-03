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

import src.models.CriterioPorNota;
import src.models.Filme;
import src.models.SemiFinal;

public class SemiFinalTest extends TestConfig {

    @Test
    public void deveLancarExcecao_QuandoTiverMaisDe4Participantes() throws Exception {
        var participantes = gerarFilmes(0, 5, 20);

        var exception = assertThrows(ExceptionInInitializerError.class,
                () -> new SemiFinal(participantes, new CriterioPorNota()));

        assertEquals("Para realizar a semi final é necessário ter 4 filmes", exception.getMessage());
    }

    @Test
    public void deveLancarExcecao_QuandoParticipanteEInvalido() throws Exception {
        List<Filme> participantes = gerarFilmes(1, 4, 4);

        var exception = assertThrows(ExceptionInInitializerError.class,
                () -> new SemiFinal(participantes, new CriterioPorNota()));

        assertEquals("Participante deve ser valido", exception.getMessage());
    }

    @Test
    public void naoDeveLancarExcecao_QuandoInformarOsParticipantesValidos() {
        List<Filme> participantes = gerarFilmes(0, 4, 4);

        assertDoesNotThrow(() -> new SemiFinal(participantes, new CriterioPorNota()));
    }

    @Test
    public void deveRetornarDoisGanhadoresComAsMaioresNotas_QuandoInformarParticipantesValidos() throws Exception {
        List<Filme> participantes = gerarFilmes(0, 4, 4);

        var ganhadoresDaSemiFinal = new SemiFinal(participantes, new CriterioPorNota()).competir();

        participantes.sort(Comparator.comparingDouble(Filme::getNota).reversed());
        var ganhadoresEsperados = IntStream.range(0, participantes.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(participantes::get)
                .collect(Collectors.toList());
        assertTrue(ganhadoresEsperados.containsAll(ganhadoresDaSemiFinal));
        assertEquals(2, ganhadoresDaSemiFinal.size());

    }
}
