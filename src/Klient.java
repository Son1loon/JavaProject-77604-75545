import java.util.ArrayList;

public class Klient extends Osoba{
    private ArrayList<Wypozyczenie> historia = new ArrayList<Wypozyczenie>();

    public Klient(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    public void dodajWypozyczenie(Wypozyczenie wypozyczenie) {
        historia.add(wypozyczenie);
    }

    public int liczbaWypozyczen() {
        return historia.size();
    }

    @Override
    public String opis() {
        return "Klient " + super.toString() + ", wypozyczen: " + historia.size();
    }

    @Override
    public String toString() {
        return opis();
    }
}
