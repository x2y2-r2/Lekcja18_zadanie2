package restauracja;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restauracja {
    Map<Kelnerka, List<Stolik>> kelnerkiZeStolikami;

    public Restauracja() {
        this.kelnerkiZeStolikami = new HashMap<>();
    }

    public void dodajStolikDoKelnerki(Kelnerka kelnerka, Stolik stolik) {
        if (!this.kelnerkiZeStolikami.containsKey(kelnerka)) {
            this.kelnerkiZeStolikami.put(kelnerka, new ArrayList<>());
        }

        this.kelnerkiZeStolikami.get(kelnerka).add(stolik);
    }

    public double pobierzCalkowityDochod(){
        double calkowtyDochod = 0;
        for (List<Stolik> stolik : kelnerkiZeStolikami.values()) {
            for (int i = 0; i < stolik.size(); i++) {
                double rachunek = stolik.get(i).cenaZamowien;
                calkowtyDochod += rachunek;
            }
        }
        return calkowtyDochod;
    }

    public double pobierzDochodKelnerki(String imie) {
        List<Stolik> rachunkiZaStolik = kelnerkiZeStolikami.get(new Kelnerka(imie));
        double sumaRachunkowZeStolika = 0;
        for (int i = 0; i < rachunkiZaStolik.size(); i++) {
            double rachunek = rachunkiZaStolik.get(i).cenaZamowien;
            sumaRachunkowZeStolika += rachunek;
        }
        return sumaRachunkowZeStolika;
    }
}