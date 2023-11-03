package src.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Final extends Competicao {
    private int QuantidadeDeFilmePermitido = 2;
    public List<Filme> participantes;

    public Final(List<Filme> participantes, Criterio criterio) throws Exception {
        super(participantes, criterio);
        new ExcecaoDeDominio()
                .Quando(participantes.size() != QuantidadeDeFilmePermitido,
                        "Para realizar a final é necessário ter 2 filmes")
                .Quando(validarParticipantes(participantes), "Participante deve ser valido")
                .Lancar();
        this.participantes = participantes;
        this.participantes.sort(Comparator.comparingDouble(Filme::getNota).reversed());
    }

    @Override
    public List<Filme> competir() {
        var filme1 = participantes.get(0);
        var filme2 = participantes.get(1);
        var vencedores = new ArrayList<Filme>();
        vencedores.add(obterVencedor(filme1, filme2));
        return vencedores;
    }
}