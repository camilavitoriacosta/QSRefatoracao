package src.models;

import java.util.Comparator;
import java.util.List;

public class QuartaDeFinal extends Competicao {
    private int QuantidadeDeFilmePermitido = 8;

    public QuartaDeFinal(List<Filme> participantes, Criterio criterio) throws Exception {
        super(participantes, criterio);
        new ExcecaoDeDominio()
                .Quando(participantes.size() != QuantidadeDeFilmePermitido,
                        "Para realizar a quarta de final é necessário ter 8 filmes")
                .Quando(Competicao.validarParticipantes(participantes), "Participante deve ser valido")
                .Lancar();
        this.participantes = participantes;
        this.criterio = criterio;
        this.participantes.sort(Comparator.comparingDouble(Filme::getNota).reversed());
    }
}
