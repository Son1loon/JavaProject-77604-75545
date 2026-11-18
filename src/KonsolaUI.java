
import java.util.ArrayList;
import java.util.Scanner;

public class KonsolaUI implements InterfejsUzytkownika {

    private Scanner scanner = new Scanner(System.in);
    private Wypozyczalnia wypozyczalnia;

    public KonsolaUI(Wypozyczalnia wypozyczalnia) {
        this.wypozyczalnia = wypozyczalnia;
    }

    @Override
    public void pokazMenu() {
        String[] menu = {
                "1. Wyswietl pojazdy",
                "2. Wyswietl klientow",
                "3. Wypozycz pojazd",
                "4. Wyswietl wypozyczenia",
                "5. Sortuj pojazdy (Comparable)",
                "6. Sortuj pojazdy (Comparator)",
                "7. Statystyki",
                "8. Zwroc pojazd",
                "9. Wyswietl pracownikow",
                "10. Szczegoly pojazdow",
                "0. Wyjscie"
        };
        System.out.println("wypozyczalnia pojazdow");

        for (String element : menu) {
            System.out.println(element);
        }
    }

    @Override
    public int pobierzLiczbe(String komunikat) {
        while (true) {
            System.out.print(komunikat);

            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Blad! Wprowadz poprawna liczbe.");
            }
        }
    }

    @Override
    public void pokazKomunikat(String komunikat) {
        System.out.println(komunikat);
    }

    public void uruchom() {
        boolean dziala = true;

        while (dziala) {
            pokazMenu();
            int wybor = pobierzLiczbe("Wybierz opcje: ");

            switch (wybor) {
                case 1:
                    pokazPojazdy();
                    break;
                case 2:
                    Narzedzia.wyswietlTytul("lista klientow");
                    Narzedzia.wyswietlListe(wypozyczalnia.pobierzKlientow());
                    for (Klient klient : wypozyczalnia.pobierzKlientow()) {
                        System.out.println("Liczba wypozyczen klienta: " + klient.liczbaWypozyczen());
                    }
                    break;
                case 3:
                    wypozycz();
                    break;
                case 4:
                    pokazWypozyczenia();
                    break;
                case 5:
                    Narzedzia.wyswietlTytul("sortowanie comparable");
                    Narzedzia.wyswietlListe(wypozyczalnia.sortujComparable());
                    break;
                case 6:
                    Narzedzia.wyswietlTytul("sortowanie comparator");
                    Narzedzia.wyswietlListe(wypozyczalnia.sortujComparator());
                    break;
                case 7:
                    pokazKomunikat("Liczba pojazdow: " + Pojazd.getLiczbaPojazdow());
                    pokazKomunikat("Liczba wypozyczen: " + Wypozyczenie.getLiczbaWypozyczen());
                    break;
                case 8:
                    zwrocPojazd();
                    break;
                case 9:
                    pokazPracownikow();
                    break;
                case 10:
                    pokazSzczegolyPojazdow();
                    break;
                case 0:
                    dziala = false;
                    pokazKomunikat("Do widzenia!");
                    break;
                default:
                    pokazKomunikat("Nieprawidlowy wybor!");
            }
        }
    }

    private void pokazPojazdy() {
        Narzedzia.wyswietlTytul("lista pojazdow");
        for (Pojazd pojazd : wypozyczalnia.getPojazdy()) {
            System.out.println(pojazd.getTypPojazdu() + " - " + pojazd);
        }
    }

    private void wypozycz() {
        try {
            Narzedzia.wyswietlTytul("wypozyczanie pojazdu");
            ArrayList<Klient> klienci = wypozyczalnia.pobierzKlientow();

            if (klienci.isEmpty()) {
                pokazKomunikat("Brak klientow!");
                return;
            }

            for (int i = 0; i < klienci.size(); i++) {
                System.out.println((i + 1) + ". " + klienci.get(i));
            }

            int numerKlienta = pobierzLiczbe("Wybierz klienta: ");

            if (numerKlienta < 1 || numerKlienta > klienci.size()) {
                pokazKomunikat("Nieprawidlowy numer klienta!");
                return;
            }

            Klient klient = klienci.get(numerKlienta - 1);

            System.out.print("Podaj marke pojazdu: ");
            String marka = scanner.nextLine();

            System.out.print("Podaj model pojazdu: ");
            String model = scanner.nextLine();

            int dni = pobierzLiczbe("Podaj liczbe dni: ");
            Wypozyczenie wypozyczenie = wypozyczalnia.wypozyczPojazd(klient, marka, model, dni);

            pokazKomunikat("Wypozyczenie zakonczone sukcesem!");
            System.out.println(wypozyczenie);

            for (Osoba osoba : wypozyczalnia.getOsoby()) {
                if (osoba instanceof Pracownik) {
                    Pracownik pracownik = (Pracownik) osoba;

                    pokazKomunikat(
                            pracownik.obsluz(wypozyczenie)
                    );
                    break;
                }
            }

        } catch (BrakPojazduException e) {
            pokazKomunikat("Blad: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            pokazKomunikat("Blad: " + e.getMessage());
        }
    }

    private void pokazWypozyczenia() {
        Narzedzia.wyswietlTytul("aktywne wypozyczenia");
        ArrayList<Wypozyczenie> lista = wypozyczalnia.getWypozyczenia();

        if (lista.isEmpty()) {
            pokazKomunikat("Brak aktywnych wypozyczen.");
            return;
        }

        for (Wypozyczenie wypozyczenie : lista) {
            System.out.println(
                    "Klient: " + wypozyczenie.getKlient()
            );
            System.out.println(
                    "Liczba dni: " + wypozyczenie.getLiczbaDni()
            );
            System.out.println(
                    "Pojazd: " + wypozyczenie.getPojazd()
            );
        }
    }

    private void zwrocPojazd() {
        ArrayList<Wypozyczenie> lista = wypozyczalnia.getWypozyczenia();

        if (lista.isEmpty()) {
            pokazKomunikat("Brak pojazdow do zwrotu.");
            return;
        }

        Narzedzia.wyswietlTytul("zwrot pojazdu");

        for (int i = 0; i < lista.size(); i++) {
            System.out.println(
                    (i + 1) + ". " + lista.get(i)
            );
        }

        int numer = pobierzLiczbe("Wybierz wypozyczenie do zwrotu: ");

        if (numer < 1 || numer > lista.size()) {
            pokazKomunikat("Nieprawidlowy numer!");
            return;
        }

        Wypozyczenie wypozyczenie = lista.get(numer - 1);
        wypozyczalnia.zwrocPojazd(wypozyczenie);

        pokazKomunikat("Pojazd zostal zwrocony.");
    }

    private void pokazPracownikow() {
        Narzedzia.wyswietlTytul("lista pracownikow");

        for (Osoba osoba : wypozyczalnia.getOsoby()) {
            if (osoba instanceof Pracownik) {
                Pracownik pracownik = (Pracownik) osoba;
                System.out.println(pracownik.opis());
            }
        }
    }

    private void pokazSzczegolyPojazdow() {
        Narzedzia.wyswietlTytul("szczegole pojazdow");

        for (Pojazd pojazd : wypozyczalnia.getPojazdy()) {
            System.out.println(pojazd);
            System.out.println("Typ: " + pojazd.getTypPojazdu());

            if (pojazd instanceof Samochod) {
                Samochod samochod = (Samochod) pojazd;
                System.out.println("Klimatyzacja: " + (samochod.isKlimatyzacja() ? "Tak" : "Nie"));
            } else if (pojazd instanceof Motocykl) {
                Motocykl motocykl = (Motocykl) pojazd;
                System.out.println("Pojemnosc silnika: " + motocykl.getPojemnoscSilnika() + " cm3");
            } else if (pojazd instanceof Rower) {
                Rower rower = (Rower) pojazd;
                System.out.println("Elektryczny: " + (rower.isElektryczny() ? "Tak" : "Nie"));
            }
        }
    }
}
