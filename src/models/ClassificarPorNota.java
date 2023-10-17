package src.models;
public class ClassificarPorNota implements Classificador {
    public Filme disputar(Filme filme1, Filme filme2) {
        return (filme1.getNota() > filme2.getNota()) ? filme1 : filme2;
    }
}