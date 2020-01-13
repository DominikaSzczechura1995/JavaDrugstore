package Apteka;

import static Apteka.PriceEnum.*;
import static Apteka.PriceEnum.DUŻO;

// nie można utworzyć instancji klasy Product1, ponieważ jest to klasa abstrakcyjna
public abstract class Product1 implements Interfejsable {
    int product_id;
    String product_name;
    public double product_price_per_package;
    int how_much_available;
    String first_part;
    String second_part;


    public Product1(int product_id, String product_name, double product_price_per_package, int how_much_available) {

        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price_per_package = product_price_per_package;
        this.how_much_available = how_much_available;
    }

    public Product1() {
        this.product_id = 0;
        this.product_name = "no name";
        this.product_price_per_package = 00.00;
        this.how_much_available = 0;

    }


    int getProduct_id() {

        return product_id;
    }

    final void setProduct_name(String product_name) {
        first_part = product_name.substring(0, 1).toUpperCase();
        second_part = product_name.substring(1).toLowerCase();
        this.product_name = first_part + second_part;
    }

    String getProduct_name() {
        setProduct_name(product_name);
        return product_name;
    }

    //metoda abstrakcyjna, która będzie musiała być zaimplementowana we wszystkich podklasach
    public abstract double getProduct_price_per_package();

    int getHow_much_available() {
        return how_much_available;
    }


    public String setDeliveryInfo(int how_much_available) {
        PriceEnum amount = NIEZNANA_ILOŚĆ;
        String dostepnosc = "";


        if (how_much_available < 10) {
            amount = MAŁO;
        }
        if (how_much_available >= 10 && how_much_available <= 30) {
            amount = OPTYMALNIE;
        }
        if (how_much_available > 30) {
            amount = DUŻO;
        }

        switch (amount) {
            case DUŻO:
                dostepnosc = "Zorganizuj promocję";
                break;
            case OPTYMALNIE:
                dostepnosc = "Jest ok";
                break;
            case MAŁO:
                dostepnosc = "Złóż zamówienie w hurtowni";
                break;
        }
        return dostepnosc;
    }


    //metoda abstrakcyjna, która będzie musiała być zaimplementowana we wszystkich nieabstrakcyjnych podklasach tej klasy
    @Override
    public abstract String toString_klient();

    @Override
    public abstract String toString_admin();

    @Override
    public abstract String toString_delivery();


}
