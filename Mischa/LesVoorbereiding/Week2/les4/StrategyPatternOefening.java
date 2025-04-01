public interface ISorteerStrategie {
    void sorteer(Stringp[] woorden);
}

public class Woordenlijst {
    private Stringp[] woorden = {"Mischa", "Jacco", "Claudia", "Dinand", "Jerry Lee"};
    private ISorteerStrategie strategie;

    public void print() {
        for (int index = 0; index < woorden.length; index++) {
            System.out.println(woorden[index] + " ");
        }
        System.out.println();
    }

    public void sorteer() {
        if (sorteerStrategie != null) {
            sorteerStrategie.sorteer(woorden);
        } else {
            throw new UnsupportedOperationException("Sorteerstrategie is niet ingesteld");
        }
    }

    public void setSorteerStrategie(ISorteerStrategie strategie) {
        this.sorteerStrategie = strategie;
    }
}

public class BubbleSort implements ISorteerStrategie {

    @Override
    public void sorteer(String[] woorden) {
        for (int grens = woorden.length; grens > 0; grens--) {
            for (int i = 0; i < grens - 1; i++) {
                if (woorden[i].compareTo(woorden[i + 1]) > 0) {
                    String hulp = woorden[i];
                    woorden[i] = woorden[i + 1];
                    woorden[i + 1] = hulp;
                }
            }
        }
    }
}

public class SelectionSort implements ISorteerStrategie {

    @Override
    public void sorteer(String[] woorden) {
        for (int startpositie = 0; startpositie < woorden.length; startpositie++) {
            int positieMinimum = startpositie;
            for (int i = startpositie + 1; i < woorden.length; i++) {
                if (woorden[positieMinimum].compareTo(woorden[i]) > 0) {
                    positieMinimum = i;
                }
            }
            String hulp = woorden[startpositie];
            woorden[startpositie] = woorden[positieMinimum];
            woorden[positieMinimum] = hulp;
        }
    }
}