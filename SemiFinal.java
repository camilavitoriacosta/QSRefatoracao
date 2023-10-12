import java.util.ArrayList;
import java.util.List;

public class SemiFinal {
    private int QuantidadeDeFilmePermitido = 4;
    public List<Filme> participantes;

    public SemiFinal(List<Filme> participantes) throws Exception {
        new ExcecaoDeDominio()
                .Quando(participantes.size() > QuantidadeDeFilmePermitido,
                        "Para realizar a semi final é necessário ter 4 filmes")
                .Lancar();
        this.participantes = participantes;
    }

    public List<Filme> competir() {
        List<Filme> vencedores = new ArrayList<>();
        for (int i = 0; i < participantes.size(); i += 2) {
            Filme filme1 = participantes.get(i);
            Filme filme2 = participantes.get(i + 1);
            var vencedor = (filme1.getNota() > filme2.getNota()) ? filme1 : filme2;
            vencedores.add(vencedor);
        }
        return vencedores;
    }

    // criar metodo disputar

}