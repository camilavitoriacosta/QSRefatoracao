import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Filme> participantes = new ArrayList<Filme>();
        // adicionar os filmes

        List<Filme> vencedoresQuartasDeFinal = new QuartaDeFinal(participantes).competir();
        List<Filme> vencedoresSemiFinal = new SemiFinal(vencedoresQuartasDeFinal).competir();
        Filme vencedor = new Final(vencedoresSemiFinal, new ClassificarPorNota()).competir();
    }
}