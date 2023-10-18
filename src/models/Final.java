package src.models;
import java.util.List;

public class Final extends Competicao {
    private int QuantidadeDeFilmePermitido = 2;
    public List<Filme> participantes;
    //public Classificador classificador;

    // public Final(List<Filme> participantes, Classificador classificador) throws Exception {
    //     new ExcecaoDeDominio()
    //             .Quando(participantes.size() != QuantidadeDeFilmePermitido,
    //                     "Para realizar a final é necessário ter 2 filmes")
    //             .Lancar();
    //     this.participantes = participantes;
    // }

    public Final(List<Filme> participantes)  throws Exception  {
        new ExcecaoDeDominio()
                .Quando(participantes.size() != QuantidadeDeFilmePermitido,
                        "Para realizar a final é necessário ter 2 filmes")
                .Quando(validarParticipantes(participantes), "Participante deve ser valido")
                .Lancar();
        this.participantes = participantes;
    }

        // public Filme competir() {
    //     return classificador.disputar(participantes.get(0), participantes.get(1));
    // }
        public Filme competir() {
            var filme1 = participantes.get(0);
            var filme2 = participantes.get(1);
            return obterVencedor(filme1, filme2);
      //  return (filme1.getNota() > filme2.getNota()) ? filme1 : filme2;
    }
}