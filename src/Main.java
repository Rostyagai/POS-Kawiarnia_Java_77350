import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private String terminalName;

    public Main(String terminalName) {
        this.terminalName = terminalName;
    }

    public String getTerminalName() {
        return terminalName;
    }

    public void setTerminalName(String terminalName) {
        this.terminalName = terminalName;
    }

    // Metoda generyczna 1 - wyswietlanie dowolnej tablicy obiektow
    public static <T> void displayArray(T[] arr) {
        for (T element : arr) {
            System.out.println(element.toString());
        }
    }

    // Metoda generyczna 2 z ograniczeniem - sortowanie i wyswietlanie tablicy Comparable
    public static <T extends Comparable<T>> void sortAndDisplayArray(T[] arr) {
        Arrays.sort(arr);
        displayArray(arr);
    }

    public static void main(String[] args) {
        // Utworzenie co najmniej 2 obiektow klasy Main
        Main posTerminal1 = new Main("Terminal Glowny #1");
        Main posTerminal2 = new Main("Terminal Mobilny #2");
        posTerminal2.setTerminalName("Terminal Barowy #2");
        System.out.println("Uruchomiono: " + posTerminal1.getTerminalName() + " oraz " + posTerminal2.getTerminalName());

        // Utworzenie obiektow klas Beverage i Dessert (Upcasting do tablicy Product[])
        Beverage bev1 = new Beverage("Caffe Latte", 16.50, Size.LARGE, true);
        Beverage bev2 = new Beverage("Espresso", 9.00, Size.SMALL, true);
        Beverage bev3 = new Beverage("Mrozona Matcha", 19.00, Size.MEDIUM, false);

        Dessert des1 = new Dessert("Sernik Klasyczny", 18.00, 420, false);
        Dessert des2 = new Dessert("Brownie Czekoladowe", 15.50, 380, true);
        Dessert des3 = new Dessert("Szarlotka na cieplo", 17.00, 350, false);

        // Wywolanie metod dostepowych (getterow i setterow), aby kazda metoda w projekcie byla uzyta
        bev1.setName("Caffe Latte Classic");
        bev1.setPrice(16.00);
        bev1.setSize(Size.EXTRA_LARGE);
        bev1.setIsHot(true);
        des1.setCalories(430);
        des1.setIsGlutenFree(false);
        Product.setTotalProductsCreated(Product.getTotalProductsCreated());

        // Tablica 1: Menu kawiarni (Upcasting: Beverage i Dessert jako Product)
        Product[] menuArray = {bev1, bev2, bev3, des1, des2, des3};

        // Utworzenie co najmniej 2 obiektow klas Barista i Cashier
        Barista barista1 = new Barista("Jan", "Kowalski", 1, 40);
        Barista barista2 = new Barista("Anna", "Nowak", 2, 55);
        Cashier cashier1 = new Cashier("Piotr", "Wisniewski", 3, 80);
        Cashier cashier2 = new Cashier("Katarzyna", "Wojcik", 4, 65);

        // Wywolanie getterow i setterow klas pracownikow
        Employee.setCafeName("Kawiarnia Java POS");
        barista1.setFirstName("Janusz");
        barista1.setLastName("Kowalski");
        barista1.setEmployeeId(101);
        barista1.setCoffeesPrepared(42);
        cashier1.setOrdersHandled(85);

        // Tablica 2: Pracownicy kawiarni (Upcasting: Barista i Cashier jako Employee)
        Employee[] staffArray = {barista1, barista2, cashier1, cashier2};

        // Tablica 3: Dostepne metody platnosci (1D)
        String[] paymentMethods = {"Gotowka", "Karta platnicza", "BLIK"};

        // Tablica 4: Uklad stolikow w sali kawiarni (2D)
        int[][] tablesGrid = {
                {1, 2, 3},
                {4, 5, 6}
        };

        // Utworzenie co najmniej 2 obiektow klasy ProductPriceComparator
        ProductPriceComparator ascPriceComparator = new ProductPriceComparator(true);
        ProductPriceComparator descPriceComparator = new ProductPriceComparator(false);
        descPriceComparator.setAscending(false);

        // Kolekcja 1: Zbior (HashSet) stalych klientow (test equals i hashCode)
        Set<Customer> customerSet = new HashSet<>();
        Customer cust1 = new Customer("Adam Mickiewicz", 1, 50);
        Customer cust2 = new Customer("Juliusz Slowacki", 2, 20);
        Customer cust3Duplicate = new Customer("Adam Mickiewicz", 1, 50);

        cust1.setName("Adam Mickiewicz");
        cust1.setCustomerId(1);
        cust1.setLoyaltyPoints(55);

        customerSet.add(cust1);
        customerSet.add(cust2);
        customerSet.add(cust3Duplicate); // Duplikat nie zostanie dodany dzieki equals i hashCode

        // Kolekcja 2: Mapa (HashMap) przechowujaca zamowienia po ID
        Map<Integer, Order> ordersMap = new HashMap<>();

        // Utworzenie co najmniej 2 obiektow klasy Order
        Order initialOrder1 = new Order(1, cust1);
        Order initialOrder2 = new Order(2, cust2);
        initialOrder1.setOrderId(1);
        initialOrder1.setCustomer(cust1);
        initialOrder1.setProducts(new ArrayList<>(initialOrder1.getProducts()));

        // Test wyjatku uzytkownika (utworzenie co najmniej 2 obiektow InvalidOrderException)
        try {
            initialOrder1.addProduct(bev1);
            initialOrder1.addProduct(des1);
            initialOrder2.addProduct(bev2);
            // Celowe wywolanie wyjatku 1 (przekazanie null)
            initialOrder2.addProduct(null);
        } catch (InvalidOrderException e) {
            e.setErrorCode(e.getErrorCode());
            System.out.println("[Test zabezpieczen POS] Zlapano wyjatek (kod " + e.getErrorCode() + "): " + e.getMessage());
        }

        try {
            // Celowe wywolanie wyjatku 2
            throw new InvalidOrderException("Test drugiego obiektu wyjatku w systemie POS.", 200);
        } catch (InvalidOrderException e) {
            System.out.println("[Test zabezpieczen POS] " + e.getMessage());
        }

        ordersMap.put(initialOrder1.getOrderId(), initialOrder1);
        ordersMap.put(initialOrder2.getOrderId(), initialOrder2);
        int nextOrderId = 3;

        // Bieżące otwarte zamówienie w terminalu
        Order currentOrder = new Order(nextOrderId, cust1);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("\n==============================================");
        System.out.println(" WITAJ W SYSTEMIE POS: " + Employee.getCafeName());
        System.out.println(" Liczba utworzonych produktow w bazie: " + Product.getTotalProductsCreated());
        System.out.println("==============================================");

        // Pętla 1: while (glowna petla interaktywna programu)
        while (running) {
            System.out.println("\n--- MENU GLOWNE SYSTEMU POS ---");
            System.out.println("1. Wyswietl menu kawiarni (oraz układ stolikow)");
            System.out.println("2. Posortuj menu (Comparable - po nazwie / Comparator - po cenie)");
            System.out.println("3. Dodaj produkt do biezacego zamowienia");
            System.out.println("4. Nadaj rabat na produkt (Interfejs Discountable)");
            System.out.println("5. Finalizuj biezace zamowienie i wybierz platnosc");
            System.out.println("6. Panel pracownikow i przygotowania (Upcasting i Downcasting)");
            System.out.println("7. Baza stalych klientow (Set) oraz historia zamowien (Map)");
            System.out.println("0. Zakoncz dzialanie programu");
            System.out.print("Wybierz opcje: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Blad: Prosze podac poprawna liczbe calkowita!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\n--- AKTUALNE MENU KAWIARNI ---");
                    // Pętla 2: klasyczna pętla for
                    for (int i = 0; i < menuArray.length; i++) {
                        Product p = menuArray[i];
                        System.out.printf("%d. %s | Cena netto: %.2f PLN | Brutto: %.2f PLN | %s\n",
                                (i + 1), p.getName(), p.getPrice(), p.getPriceBrutto(), p.getCategoryDescription());
                    }

                    System.out.println("\nUklad stolikow na sali (Tablica 2D):");
                    for (int i = 0; i < tablesGrid.length; i++) {
                        for (int j = 0; j < tablesGrid[i].length; j++) {
                            System.out.print("[Stolik " + tablesGrid[i][j] + "] ");
                        }
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.println("\nWybierz sposob sortowania:");
                    System.out.println("1 - Alfabetycznie po nazwie (Comparable + metoda generyczna)");
                    System.out.println("2 - Rosnaco po cenie (Comparator)");
                    System.out.println("3 - Malejaco po cenie (Comparator)");
                    System.out.print("Twoj wybor: ");
                    int sortChoice = Integer.parseInt(scanner.nextLine());

                    if (sortChoice == 1) {
                        System.out.println("\nPosortowano alfabetycznie (Comparable):");
                        sortAndDisplayArray(menuArray);
                    } else if (sortChoice == 2) {
                        Arrays.sort(menuArray, ascPriceComparator);
                        System.out.println("\nPosortowano rosnaco po cenie (Comparator: " + ascPriceComparator.getAscending() + "):");
                        displayArray(menuArray);
                    } else if (sortChoice == 3) {
                        Arrays.sort(menuArray, descPriceComparator);
                        System.out.println("\nPosortowano malejaco po cenie (Comparator):");
                        displayArray(menuArray);
                    } else {
                        System.out.println("Nieznana opcja sortowania.");
                    }
                    break;

                case 3:
                    System.out.println("\nPodaj numer produktu z menu (od 1 do " + menuArray.length + "): ");
                    int prodIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    try {
                        if (prodIndex < 0 || prodIndex >= menuArray.length) {
                            throw new InvalidOrderException("Wybrano nieistniejacy numer produktu z menu!", 404);
                        }
                        Product selectedProduct = menuArray[prodIndex];
                        currentOrder.addProduct(selectedProduct);
                        System.out.println("Dodano do zamowienia: " + selectedProduct.getName());
                        System.out.println("Aktualna wartosc koszyka: " + currentOrder.calculateTotal() + " PLN");
                    } catch (InvalidOrderException e) {
                        System.out.println("BLAD ZAMOWIENIA (kod " + e.getErrorCode() + "): " + e.getMessage());
                    }
                    break;

                case 4:
                    bev1.printDiscountPolicy();
                    System.out.print("Podaj numer produktu do rabatu (1-" + menuArray.length + "): ");
                    int discIndex = Integer.parseInt(scanner.nextLine()) - 1;
                    if (discIndex >= 0 && discIndex < menuArray.length) {
                        double percent;
                        // Pętla 3: do-while
                        do {
                            System.out.print("Podaj procent rabatu (1 - 50): ");
                            percent = Double.parseDouble(scanner.nextLine());
                        } while (percent <= 0);

                        menuArray[discIndex].applyDiscount(percent);
                        System.out.println("Po zmianie: " + menuArray[discIndex]);
                    } else {
                        System.out.println("Nieprawidlowy numer produktu.");
                    }
                    break;

                case 5:
                    if (currentOrder.getProducts().isEmpty()) {
                        System.out.println("Biezace zamowienie jest puste! Dodaj najpierw produkty.");
                    } else {
                        System.out.println("\nDostepne metody platnosci:");
                        for (int i = 0; i < paymentMethods.length; i++) {
                            System.out.println((i + 1) + ". " + paymentMethods[i]);
                        }
                        System.out.print("Wybierz metode platnosci: ");
                        int payIdx = Integer.parseInt(scanner.nextLine()) - 1;
                        String chosenPayment = (payIdx >= 0 && payIdx < paymentMethods.length)
                                ? paymentMethods[payIdx] : paymentMethods[0];

                        System.out.println("Zrealizowano platnosc (" + chosenPayment + ") na kwote: " + currentOrder.calculateTotal() + " PLN");
                        ordersMap.put(currentOrder.getOrderId(), currentOrder);
                        nextOrderId++;
                        currentOrder = new Order(nextOrderId, cust1);
                    }
                    break;

                case 6:
                    System.out.println("\n--- DEMONSTRACJA UPCASTINGU I DOWNCASTINGU ---");
                    // Upcasting: obiekt klasy pochodnej przypisany do referencji klasy bazowej
                    Product upcastedBev = bev1;
                    Product upcastedDes = des1;

                    // Downcasting: jawne rzutowanie referencji klasy bazowej na klase pochodna
                    Beverage downcastedBev = (Beverage) upcastedBev;
                    downcastedBev.heatUp();
                    System.out.println("Czy napoj goracy: " + downcastedBev.getIsHot() + ", rozmiar: " + downcastedBev.getSize());

                    Dessert downcastedDes = (Dessert) upcastedDes;
                    downcastedDes.addWhippedCream();
                    System.out.println("Czy bezglutenowy: " + downcastedDes.getIsGlutenFree() + ", kalorie: " + downcastedDes.getCalories());

                    // Upcasting i Downcasting na drugiej hierarchii (Employee -> Barista, Cashier)
                    Employee upcastedBarista = barista1;
                    ((Barista) upcastedBarista).brewSpecialtyCoffee();
                    System.out.println("Kawy baristy: " + ((Barista) upcastedBarista).getCoffeesPrepared());

                    Employee upcastedCashier = cashier1;
                    ((Cashier) upcastedCashier).openCashRegister();
                    System.out.println("Obsluzone zamowienia kasjera: " + ((Cashier) upcastedCashier).getOrdersHandled());

                    System.out.println("\nLista pracownikow i ich premie (Polimorfizm):");
                    // Pętla 4: for-each
                    for (Employee emp : staffArray) {
                        System.out.println(emp.toString() + " -> Premia: " + emp.calculateBonus() + " PLN");
                    }
                    break;

                case 7:
                    System.out.println("\n--- ZAREJESTROWANI STALI KLIENCI (Kolekcja Set) ---");
                    for (Customer c : customerSet) {
                        System.out.println(c + " (Punkty: " + c.getLoyaltyPoints() + ", ID: " + c.getCustomerId() + ")");
                    }
                    System.out.print("Chcesz dodac nowego klienta? (t/n): ");
                    String ans = scanner.nextLine();
                    if (ans.equals("t")) {
                        System.out.print("Podaj imie i nazwisko klienta: ");
                        String cName = scanner.nextLine();
                        System.out.print("Podaj numer ID klienta: ");
                        int cId = Integer.parseInt(scanner.nextLine());
                        Customer newCust = new Customer(cName, cId, 0);
                        if (customerSet.add(newCust)) {
                            System.out.println("Dodano nowego klienta do zbioru!");
                        } else {
                            System.out.println("Klient o takich danych juz istnieje w zbiorze (wykryto przez equals i hashCode)!");
                        }
                    }

                    System.out.println("\n--- HISTORIA ZAMOWIEN (Kolekcja Map) ---");
                    for (Map.Entry<Integer, Order> entry : ordersMap.entrySet()) {
                        System.out.println("Klucz ID: " + entry.getKey() + " -> Wartosc: " + entry.getValue());
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Zamykanie systemu POS. Do widzenia!");
                    break;

                default:
                    System.out.println("Nieznana opcja w menu. Wybierz numer od 0 do 7.");
                    break;
            }
        }
        scanner.close();
    }
}