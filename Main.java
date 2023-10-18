import java.util.List;
import net.datafaker.Faker;
import src.models.Filme;
import src.models.Final;
import src.models.QuartaDeFinal;
import src.models.SemiFinal;

public class Main {
    public static void main(String[] args) throws Exception {

        Faker faker = new Faker();
        List<Filme> participantes = faker.<Filme>collection()
                .suppliers(() -> {
                    try {
                        return new Filme().gerarFilme(faker); 
                    } catch (Exception e) {
                       return new Filme();
                    }
                })
                .nullRate(0)
                .maxLen(8)
                .generate();

        List<Filme> vencedoresQuartasDeFinal = new QuartaDeFinal(participantes).competir();
        List<Filme> vencedoresSemiFinal = new SemiFinal(vencedoresQuartasDeFinal).competir();
        Filme vencedor = new Final(vencedoresSemiFinal).competir();


        // Filme vencedor = new Final(vencedoresSemiFinal, new ClassificarPorNota()).competir();

        System.out.printf("O vencedor eh: RUFEM OS TAMBORES -------- \n" 
                + "O id do livro: %s \n" 
                + "O titulo eh: %s \n"
                + "O ano de publicacao: %d \n" 
                + "A nota do livro: %.2f \n",
                vencedor.getId(),
                vencedor.getTitulo(),
                vencedor.getAno(),
                vencedor.getNota());
    }
}