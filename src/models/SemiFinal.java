package src.models;

import java.util.Comparator;
import java.util.List;

public class SemiFinal extends Competicao {
    final int QuantidadeDeFilmePermitido = 4;
    public List<Filme> participantes;

    public SemiFinal(List<Filme> participantes, Criterio criterio) throws Exception {
        super(participantes, criterio);
        new ExcecaoDeDominio()
                .Quando(participantes.size() > QuantidadeDeFilmePermitido,
                        "Para realizar a semi final é necessário ter 4 filmes")
                .Quando(validarParticipantes(participantes), "Participante deve ser valido")
                .Lancar();
        this.participantes = participantes;
        this.participantes.sort(Comparator.comparingDouble(Filme::getNota).reversed());
    }
}