package src.models;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ExcecaoDeDominio<T> {
    public List<String> mensagensDeErros = new ArrayList<>();

    private T dataDomain;

    public ExcecaoDeDominio() {
        mensagensDeErros = new ArrayList<>();
    }

    public ExcecaoDeDominio(T dataDomain) {
        this.dataDomain = dataDomain;
    }

    public ExcecaoDeDominio<T> Quando(boolean condicao, String mensagemDeErro) {
        if (condicao) {
            mensagensDeErros.add(mensagemDeErro);
        }
        return this;
    }

    public ExcecaoDeDominio<T> when(Predicate<T> predicate, String mensagemDeErro) {
        if (predicate.test(this.dataDomain)) {
            this.mensagensDeErros.add(mensagemDeErro);
        }
        return this;
    }

    public void Lancar() {
        if (!this.mensagensDeErros.isEmpty()) {
            throw new IllegalArgumentException(mensagensDeErros.get(0));
        }
    }

    public static <T> ExcecaoDeDominio<T> iniciar() {
        return new ExcecaoDeDominio<>();
    }


}
