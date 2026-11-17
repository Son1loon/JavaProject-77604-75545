
import java.util.Comparator;

public class PojazdComparator implements Comparator<Pojazd> {

    @Override
    public int compare(Pojazd p1, Pojazd p2) {
        int wynik = p1.getMarka().compareToIgnoreCase(p2.getMarka());

        if (wynik == 0) {
            return Integer.compare(
                    p1.getRokProdukcji(),
                    p2.getRokProdukcji()
            );
        }

        return wynik;
    }
}
