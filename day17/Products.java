package day17;



import java.util.ArrayList;
import java.util.Collections;

public class Products {
    public static void main(String[] args) {
        ArrayList<String> products = new ArrayList<>();

        products.add("Laptop");
        products.add("Mobile");
        products.add("Earphones");
        products.add("Smartwatch");
        products.add("Tablet");

        Collections.sort(products);

        System.out.println("Sorted Product List:");
        for (String product : products) {
            System.out.println(product);
        }
    }
}

