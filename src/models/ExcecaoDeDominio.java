package src.models;
import java.util.ArrayList;
import java.util.List;

public class ExcecaoDeDominio {
    public List<String> MensagensDeErros;

    public ExcecaoDeDominio() {
        MensagensDeErros = new ArrayList<String>();
    }

    public ExcecaoDeDominio Quando(boolean condicao, String mensagemDeErro) {
        if (condicao) {
            MensagensDeErros.add(mensagemDeErro);
        }
        return this;
    }

    public void Lancar() throws Exception {
        if (MensagensDeErros.size() > 0) {
            throw new ExceptionInInitializerError(MensagensDeErros.get(0));
        }
    }
}
