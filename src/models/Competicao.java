package src.models;

import java.util.List;

public abstract class Competicao {

    static Filme obterVencedor(Filme filme1, Filme filme2) {
        return filme1.getNota() > filme2.getNota() ? filme1 : filme2;
    }

    static Boolean validarParticipantes(List<Filme> participantes) {
        return participantes.stream()
                .anyMatch(filme ->
                        null == filme ||
                                filme.getTitulo() == null ||
                                filme.getTitulo().isBlank() ||
                                filme.getId().isBlank()
                );
    }
}
