package src.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class QuartaDeFinal {
    private int QuantidadeDeFilmePermitido = 8;
    public List<Filme> x;
    private CriterioEnum criterio;

    public QuartaDeFinal(List<Filme> participantes, CriterioEnum criterio) throws Exception {
        new ExcecaoDeDominio()
                .Quando(participantes.size() != QuantidadeDeFilmePermitido,
                        "Para realizar a quarta de final é necessário ter 8 filmes")
                .Quando(Competicao.validarParticipantes(participantes), "Participante deve ser valido")
                .Lancar();
        this.x = participantes;
        this.criterio = criterio;
        this.x.sort(Comparator.comparingDouble(Filme::getNota).reversed());
    }

    public List<Filme> competir() {
        List<Filme> vencedores = new ArrayList<>();
        for (int i = 0; i < x.size(); i += 2) {
            Filme filme1 = x.get(i);
            Filme filme2 = x.get(i + 1);

            Filme vencedor = null;
            if (criterio == CriterioEnum.NOTA) {
                vencedor = (filme1.getNota() > filme2.getNota()) ? filme1 : filme2;
            } else if (criterio == CriterioEnum.ANO) {
                vencedor = (filme1.getAno() > filme2.getAno()) ? filme1 : filme2;
            }

            vencedores.add(vencedor);
        }
        return vencedores;
    }
}
