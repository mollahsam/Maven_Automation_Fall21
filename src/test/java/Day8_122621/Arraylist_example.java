package Day8_122621;

import java.util.ArrayList;

public class Arraylist_example {
    public static void main(String[] args) {

        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");

        System.out.println("MY city is " + cities.get(2));

        ArrayList<Integer> streetNumber = new ArrayList<>();
        streetNumber.add(111);
        streetNumber.add(112);
        streetNumber.add(113);

        System.out.println("My third city is " +cities.get(2) + " and my third house number is " + streetNumber.get(2));



    }//end of main
}//end of java class
