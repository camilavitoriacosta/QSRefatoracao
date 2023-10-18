package UnitTest;

import java.util.List;

import net.datafaker.Faker;
import net.datafaker.sequence.FakeSequence.Builder;
import src.models.Filme;

public abstract class TestConfig {
    Faker faker = new Faker();
    Builder<Filme> filmeBuilderFaker = faker.<Filme>collection()
    .suppliers(() -> {
        try {
            return new Filme().gerarFilme(faker);
        } catch (Exception e) {
            return new Filme();
        }
    });

    List<Filme> gerarFilmes(int nullRate, int minLen, int maxLen){
       return  filmeBuilderFaker
                .nullRate(nullRate)
                .minLen(minLen)
                .maxLen(maxLen)
                .generate();
    }

}
