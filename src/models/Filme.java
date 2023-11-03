package src.models;

import net.datafaker.Faker;

public class Filme {
    public String Id;
    public String Titulo;
    public int Ano;
    public double Nota;

    public Filme() {
    }

    public Filme(String id, String titulo, int ano, double nota) throws Exception {
        new ExcecaoDeDominio()
        .Quando(null == titulo||titulo.isBlank(), "Para realizar a quarta de final é necessário ter 8 filmes")
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


    public Filme gerarFilme(Faker faker) throws Exception {
        var ano =  faker.oscarMovie().getYear().replaceAll("[\\D]", "");
        var filme = new Filme(
                faker.idNumber().valid(), 
                faker.oscarMovie().movieName(), 
                Integer.parseInt(ano), 
                faker.number().randomDouble(9,0, 10)
            );
        return filme;
    }
}