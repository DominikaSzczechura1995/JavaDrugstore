package Apteka;

import java.text.MessageFormat;

class Antibiotic extends Product1 implements Interfejsable {

    private String purpose;
    public double refundation_level;

    Antibiotic() {
        super();
    }


    Antibiotic(int product_id, String product_name, double product_price_per_package, int how_much_available, String purpose, double refundation_level) {

        super(product_id, product_name, product_price_per_package, how_much_available);
        this.purpose = purpose;
        this.refundation_level = refundation_level;
        this.purpose = purpose;


    }

//implementacja abstrakcyjnej metody klasy nadrzędnej

    public double getProduct_price_per_package() {

        return product_price_per_package;
    }

    String getPurpose() {
        return purpose;
    }

    double getRefundation_level() {
        return refundation_level;
    }


    final double RefundCount() {
        double kwota_RefundCount = getProduct_price_per_package() * getRefundation_level();
        return kwota_RefundCount;

    }

    public double getRefundCount() {
        return RefundCount();
    }

    final double PriceAfterRefund() {
        double kwota_PriceAfterRefund = getProduct_price_per_package() - RefundCount();
        return kwota_PriceAfterRefund;
    }



    @Override
    public String toString_klient() {

        return String.format("Product ID: %d | Product name: %s", super.getProduct_id(), super.getProduct_name());

    }

    @Override
    public String toString_admin() {

        return MessageFormat.format("Product ID: {0} | Product name: {1} | Product price per package: {2} zł| Available: {3} | Purpose: {4}| Refundation: {5} %", super.getProduct_id(), super.getProduct_name(), getProduct_price_per_package(), super.getHow_much_available(), getPurpose(), getRefundation_level() * 100);

    }

    @Override
    public String toString_delivery() {

        return "Informacja o stanie magazynu: " + super.setDeliveryInfo(getHow_much_available());

    }
}

