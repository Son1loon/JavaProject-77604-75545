import java.util.*;

public class Wypozyczalnia {
    private ArrayList<Pojazd> pojazdy = new ArrayList<>();
    private ArrayList<Osoba> osoby = new ArrayList<>();
    private ArrayList<Wypozyczenie> wypozyczenia = new ArrayList<>();

    public void dodajPojazd(Pojazd pojazd) {
        HashSet<Pojazd> zbior = new HashSet<Pojazd>(pojazdy);

        if (zbior.add(pojazd)) {
            pojazdy.add(pojazd);
        }
    }

    public void dodajKlienta(Klient klient) {
        osoby.add(klient);
    }

    public void dodajOsobe(Osoba osoba) {
        osoby.add(osoba);
    }

    public ArrayList<Pojazd> getPojazdy() {
        return new ArrayList<>(pojazdy);
    }

    public ArrayList<Wypozyczenie> getWypozyczenia() {
        return new ArrayList<>(wypozyczenia);
    }

    public Pojazd znajdzPojazd(String marka, String model)
            throws BrakPojazduException {

        for (Pojazd pojazd : pojazdy) {

            if (pojazd.getMarka().equalsIgnoreCase(marka)
                    && pojazd.getModel().equalsIgnoreCase(model)) {

                return pojazd;
            }
        }

        throw new BrakPojazduException(
                "Nie znaleziono pojazdu: " + marka + " " + model
        );
    }

    public Wypozyczenie wypozyczPojazd(
            Klient klient, String marka, String model, int dni)
            throws BrakPojazduException {

        Pojazd pojazd = znajdzPojazd(marka, model);

        if (!pojazd.isDostepny()) {
            throw new BrakPojazduException(
                    "Ten pojazd jest juz wypozyczony!"
            );
        }

        Wypozyczenie wypozyczenie =
                new Wypozyczenie(klient, pojazd, dni);

        pojazd.setDostepny(false);

        wypozyczenia.add(wypozyczenie);
        klient.dodajWypozyczenie(wypozyczenie);

        return wypozyczenie;
    }

    public void zwrocPojazd(Wypozyczenie wypozyczenie) {

        if (wypozyczenia.remove(wypozyczenie)) {
            wypozyczenie.getPojazd().setDostepny(true);
        }
    }

    public ArrayList<Pojazd> sortujComparable() {

        ArrayList<Pojazd> lista = new ArrayList<>(pojazdy);

        Collections.sort(lista);

        return lista;
    }

    public ArrayList<Pojazd> sortujComparator() {

        ArrayList<Pojazd> lista = new ArrayList<>(pojazdy);

        Collections.sort(lista, new PojazdComparator());

        return lista;
    }

    public ArrayList<Klient> pobierzKlientow() {

        ArrayList<Klient> klienci = new ArrayList<>();

        for (Osoba osoba : osoby) {

            if (osoba instanceof Klient) {

                Klient klient = (Klient) osoba;

                klienci.add(klient);
            }
        }

        return klienci;
    }

    public ArrayList<Osoba> getOsoby() {
        return new ArrayList<>(osoby);
    }

}
