package src.models;
import java.util.List;

public class Final {
    private int QuantidadeDeFilmePermitido = 2;
    public List<Filme> participantes;
    public Classificador classificador;

    public Final(List<Filme> participantes, Classificador classificador) throws Exception {
        new ExcecaoDeDominio()
                .Quando(participantes.size() != QuantidadeDeFilmePermitido,
                        "Para realizar a final é necessário ter 2 filmes")
                .Lancar();
        this.participantes = participantes;
    }

    public Filme competir() {
        return classificador.disputar(participantes.get(0), participantes.get(1));
    }
}