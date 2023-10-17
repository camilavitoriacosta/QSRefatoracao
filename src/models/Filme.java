package src.models;
public class Filme {
    public String Id;
    public String Titulo;
    public int Ano;
    public double Nota;

    public Filme(String id, String titulo, int ano, double nota) {
        Id = id;
        Titulo = titulo;
        Ano = ano;
        Nota = nota;
    }

    public String getTitulo() {
        return Titulo;
    }

    public String getId() {
        return Id;
    }

    public int getAno() {
        return Ano;
    }

    public double getNota() {
        return Nota;
    }
}