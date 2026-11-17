
import java.util.*;

public abstract class Pojazd implements Comparable<Pojazd>{

    private String marka;
    private String model;
    private int rokProdukcji;
    private double cenaZaDzien;
    private boolean dostepny;

    private static int liczbaPojazdow = 0;

    public Pojazd(String marka, String model, int rokProdukcji,
                  double cenaZaDzien) {
        this.marka = marka;
        this.model = model;
        this.rokProdukcji = rokProdukcji;
        this.cenaZaDzien = cenaZaDzien;
        this.dostepny = true;

        liczbaPojazdow++;
    }

    public abstract double obliczKoszt(int dni);

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public double getCenaZaDzien() {
        return cenaZaDzien;
    }

    public boolean isDostepny() {
        return dostepny;
    }

    public void setDostepny(boolean dostepny) {
        this.dostepny = dostepny;
    }

    public static int getLiczbaPojazdow() {
        return liczbaPojazdow;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Pojazd pojazd = (Pojazd) obj;

        return rokProdukcji == pojazd.rokProdukcji
                && Objects.equals(marka, pojazd.marka)
                && Objects.equals(model, pojazd.model);
    }

    public abstract TypPojazdu getTypPojazdu();

    @Override
    public int hashCode() {
        return Objects.hash(marka, model, rokProdukcji, getClass());
    }

    @Override
    public int compareTo(Pojazd inny) {
        return Double.compare(
                this.cenaZaDzien,
                inny.cenaZaDzien
        );
    }

    @Override
    public String toString() {
        return marka + " " + model
                + " (" + rokProdukcji + ")"
                + " - " + cenaZaDzien + " PLN/dzien";
    }
}
