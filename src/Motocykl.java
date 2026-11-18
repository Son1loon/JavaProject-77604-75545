public class Motocykl extends Pojazd {

    private int pojemnoscSilnika;

    public Motocykl(String marka, String model, int rokProdukcji,
                    double cenaZaDzien, int pojemnoscSilnika) {
        super(marka, model, rokProdukcji, cenaZaDzien);
        this.pojemnoscSilnika = pojemnoscSilnika;
    }

    public int getPojemnoscSilnika() {
        return pojemnoscSilnika;
    }

    @Override
    public TypPojazdu getTypPojazdu() {
        return TypPojazdu.MOTOCYKL;
    }

    @Override
    public double obliczKoszt(int dni) {
        if (dni <= 0) {
            throw new IllegalArgumentException("Liczba dni musi byc dodatnia");
        }
        return getCenaZaDzien() * dni;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Pojemnosc silnika: " + pojemnoscSilnika + " cm3";
    }
}
