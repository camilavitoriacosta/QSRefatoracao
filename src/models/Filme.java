package src.models;

import net.datafaker.Faker;

public class Filme {
    private final String Id;
    private final String Titulo;
    private final int Ano;
    private final double Nota;

    public Filme(String id, String titulo, int ano, double nota) {
        ExcecaoDeDominio.iniciar()
                .Quando(null == titulo || titulo.isBlank(), "Para realizar a quarta de final é necessário ter 8 filmes")
                .Quando(0 >= nota, "O ano de lancamento do livro nao pode ser numero negativo")
                .Quando(0 >= nota && nota <= 10, "A nota do livro tem que ser entre 0 a 10")
                .Lancar();
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


    public static Filme gerarFilme(Faker faker) {
        var ano = faker.oscarMovie().getYear().replaceAll("[\\D]", "");
        return new Filme(
                faker.idNumber().valid(),
                faker.oscarMovie().movieName(),
                Integer.parseInt(ano),
                faker.number().randomDouble(9, 0, 10)
        );
    }
}