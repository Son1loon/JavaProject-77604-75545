
public abstract class Pojazd {

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
    public String toString() {
        return marka + " " + model
                + " (" + rokProdukcji + ")"
                + " - " + cenaZaDzien + " PLN/dzien";
    }
}
