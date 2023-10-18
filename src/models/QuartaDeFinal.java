package src.models;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class QuartaDeFinal extends Competicao{
    final int QuantidadeDeFilmePermitido = 8;
    public List<Filme> x;

    public QuartaDeFinal(List<Filme> participantes) throws Exception {
        new ExcecaoDeDominio()
                .Quando(participantes.size() != QuantidadeDeFilmePermitido,
                        "Para realizar a quarta de final é necessário ter 8 filmes")
                .Quando(validarParticipantes(participantes), "Participante deve ser valido")
                .Lancar();
        this.x = participantes;
        this.x.sort(Comparator.comparingDouble(Filme::getNota).reversed());

    }

    public List<Filme> competir() {
        List<Filme> vencedores = new ArrayList<>();
        
        for (int i = 0; i < x.size(); i += 2) {
            Filme filme1 = x.get(i);
            Filme filme2 = (i + 1 < x.size()) ? x.get(i + 1) : null;
            // var vencedor = filme1.getNota() > filme2.getNota() ? filme1
            //         : filme2;
            vencedores.add(obterVencedor(filme1, filme2));
        }
        return vencedores;
    }

    // criar metodo disputar
}