package Apteka;


import java.util.*;


public class DrugStore {


    public static void main(String[] args) {

        User admin = new User("admin5678", "pass123");

        Przypadki_testowe();

        Product1[] products_list_0 = tworzenie_listy_produktów();

        String password_string = logowanie_jako_administrator();

        if (admin.getPassword().equals(password_string)) {

            System.out.println(admin.toString());


            wersja_administrator(products_list_0);


        } else {

            wersja_klient(products_list_0);

        }
    }

    private static String logowanie_jako_administrator() {
        System.out.println("Aby zalogować się jako administrator wprowadź hasło: ");

        Scanner password = new Scanner(System.in);
        return password.next();
    }

    private static void wersja_klient(Product1[] products_list_0) {
        System.out.println("Błędne hasło. Korzystasz z programu jako klient.\n");

        System.out.println("Dzisiaj w aptece możesz kupić:\n");

        for (Product1 product1 : products_list_0) {
            System.out.println(product1.toString_klient());
        }

        System.out.println("\nPodaj ID produktu aby sprawdzić cenę: ");
        Scanner czytaj_ID = new Scanner(System.in);
        int wczytane_ID = czytaj_ID.nextInt();

        System.out.println("\nMasz ubezpieczenie? Jeśli tak wpisz 1, jeśli nie wpisz 0:");

        Scanner insurance = new Scanner(System.in);
        boolean appriopriate_input = false;
        boolean insurance_info_boolean = false;

        do {
            try {
                int insurance_info = insurance.nextInt();

                if (insurance_info == 1) {
                    appriopriate_input = true;
                    insurance_info_boolean = true;


                }
                if (insurance_info == 0) {
                    appriopriate_input = true;

                }
            } catch (InputMismatchException mistake) {
                System.out.println("Write 1 for yes or 0 for no");
                insurance.next();

            }
        } while (appriopriate_input == false);


        for (int i = 0; i < products_list_0.length; i++) {

            if (products_list_0[i].getProduct_id() == wczytane_ID && insurance_info_boolean == false) {

                System.out.println(products_list_0[i].getProduct_name() + ", cena za 1 szt. w zł: " + products_list_0[i].getProduct_price_per_package());

            }

            if (products_list_0[i].getProduct_id() == wczytane_ID && insurance_info_boolean == true) {


                if (products_list_0[i] instanceof MedicalEquipment) {
                    System.out.println(products_list_0[i].getProduct_name() + ", cena za 1 szt. w zł: " + (products_list_0[i]).getProduct_price_per_package());
                } else if (products_list_0[i] instanceof Antibiotic) {

                    System.out.println(products_list_0[i].getProduct_name() + ", cena za 1 szt. w zł: " + ((Antibiotic) products_list_0[i]).PriceAfterRefund());

                } else {

                    System.out.println("Brak danych");
                }
            }
        }
    }

    private static void wersja_administrator(Product1[] products_list_0) {

        for (Product1 product1 : products_list_0) {
            System.out.println("\n" + product1.toString_admin());
            System.out.println(product1.toString_delivery());

        }

        double max = 00.00;

        String lek_max_refund_amount = "";

        for (int i = 0; i < products_list_0.length; i++) {
            if (products_list_0[i] instanceof Antibiotic) {
                double check = ((Antibiotic) products_list_0[i]).getRefundCount();
                if (check > max) {
                    max = check;
                    lek_max_refund_amount = (products_list_0[i]).getProduct_name();


                }

            }

        }

        System.out.println("\nMaksymalną kwotę Refundacji ma: " + lek_max_refund_amount + " i wynosi ona " + max);

    }


    private static void Przypadki_testowe() {
        Product1 example1 = new MedicalEquipment();
        System.out.println(example1.toString_klient());

        Product1 example2 = new Antibiotic();
        System.out.println(example2.toString_klient());
    }


    private static Product1[] tworzenie_listy_produktów() {
        Product1[] products_list_0 = new Product1[9];
        products_list_0[0] = new MedicalEquipment(1, "ORTEZA STAWU KOLANOWEGO", 70.00, 5);
        products_list_0[1] = new MedicalEquipment(2, "ORTEZA STAWU SKOKOWEGO", 135.00, 3);
        products_list_0[2] = new MedicalEquipment(3, "INHALATOR", 79.90, 1);
        products_list_0[3] = new MedicalEquipment(4, "CIŚNIENIOMIERZ", 179.99, 6);
        products_list_0[4] = new MedicalEquipment(5, "MASKA PRZECIWSMOGOWA", 142.99, 13);
        products_list_0[5] = new Antibiotic(0010, "OSPAMOX", 65.99, 78, "zapalenie zatok", 0.34);
        products_list_0[6] = new Antibiotic(0011, "DUOMOX", 12.99, 4, "dur brzuszny", 0.30);
        products_list_0[7] = new Antibiotic(0012, "AMOTAKS", 56.99, 6, "dur brzuszny", 0.67);
        products_list_0[8] = new Antibiotic(0013, "HICONCIL", 67.89, 4, "zapalenie zatok", 0.1);
        return products_list_0;
    }
}

