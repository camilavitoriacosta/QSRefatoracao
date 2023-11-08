package UnitTest;

import net.datafaker.Faker;
import net.datafaker.sequence.FakeSequence.Builder;
import src.models.Filme;

import java.util.List;

public abstract class TestConfig {
    Faker faker = new Faker();
    Builder<Filme> filmeBuilderFaker = faker.<Filme>collection()
            .suppliers(() ->
                    Filme.gerarFilme(faker)
            );

    List<Filme> gerarFilmes(int nullRate, int minLen, int maxLen) {
        return filmeBuilderFaker
                .nullRate(nullRate)
                .minLen(minLen)
                .maxLen(maxLen)
                .generate();
    }
}