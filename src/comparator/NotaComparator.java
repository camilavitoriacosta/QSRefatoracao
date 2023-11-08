package src.comparator;

import src.models.Filme;

import java.util.Comparator;

public class NotaComparator implements Comparator<Filme> {

    @Override
    public int compare(Filme o1, Filme o2) {
        if (o1.getNota() == o2.getNota()) {
            return 0;
        } else if (o1.getNota() > o2.getNota()) {
            return 1;
        } else {
            return -1;
        }
    }
}
