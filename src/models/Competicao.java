package src.models;

import java.util.ArrayList;
import java.util.List;

public abstract class Competicao {
    public List<Filme> participantes;
    protected Criterio criterio;

    public Competicao(List<Filme> participantes, Criterio criterio) {
        this.participantes = participantes;
        this.criterio = criterio;
    }

    public Filme obterVencedor(Filme filme1, Filme filme2) {
        return criterio.disputar(filme1, filme2);
    }

    public List<Filme> competir() {
        List<Filme> vencedores = new ArrayList<>();
        for (int i = 0; i < participantes.size(); i += 2) {
            Filme filme1 = participantes.get(i);
            Filme filme2 = participantes.get(i + 1);

            Filme vencedor = obterVencedor(filme1, filme2);

            vencedores.add(vencedor);
        }
        return vencedores;
    }

    static Boolean validarParticipantes(List<Filme> participantes) {
        var participanteValido = false;

        for (Filme filme : participantes) {
            if (null == filme ||
                    filme.getTitulo() == null || filme.getTitulo().isBlank() ||
                    filme.Id.isBlank()) {
                participanteValido = true;
                break;
            }
        }
        return participanteValido;
    }
}
