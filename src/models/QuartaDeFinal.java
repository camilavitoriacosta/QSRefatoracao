package src.models;
import java.util.ArrayList;
import java.util.List;


public class QuartaDeFinal {
    private int QuantidadeDeFilmePermitido = 8;
    public List<Filme> x;

    public QuartaDeFinal(List<Filme> participantes) throws Exception {
        new ExcecaoDeDominio()
                .Quando(participantes.size() != QuantidadeDeFilmePermitido,
                        "Para realizar a quarta de final é necessário ter 8 filmes")
                .Lancar();
        this.x = participantes;
    }

    public List<Filme> competir() {
        List<Filme> vencedores = new ArrayList<>();
        for (int i = 0; i < x.size(); i += 2) {
            var vencedor = (x.get(i).getNota() > x.get(i + 1).getNota()) ? x.get(i)
                    : x.get(i + 1);
            vencedores.add(vencedor);
        }
        return vencedores;
    }

    // criar metodo disputar
}