package Apteka;

import java.text.MessageFormat;

public class MedicalEquipment extends Product1 implements Interfejsable {

    MedicalEquipment(int product_id, String product_name, double product_price_per_package, int how_much_available) {

        super(product_id, product_name, product_price_per_package, how_much_available);

    }


    MedicalEquipment() {
        super();
    }

    //implementacja abstrakcyjnej metody klasy nadrzędnej
    public double getProduct_price_per_package() {
        return product_price_per_package;
    }


    @Override
    public String toString_klient() {
        return String.format("Product ID: %d | Product name: %s", super.getProduct_id(), super.getProduct_name());
    }

    @Override
    public String toString_admin() {
        return MessageFormat.format("Product ID: {0} | Product name: {1} | Product price per package: {2} zł  | Available: {3}", super.getProduct_id(), super.getProduct_name(), getProduct_price_per_package(), super.getHow_much_available());
    }

    @Override
    public String toString_delivery() {
        return "Informacja o stanie magazynu: " + super.setDeliveryInfo(getHow_much_available());
    }

}

