package Day4_121221;

import java.util.Locale;

public class Loop_Array_Conditions {

    public static void main(String[] args) {

        String[] cities = new String[4];
        cities[0] = "Queens";
        cities[1] = "Manhattan";
        cities[2] = "Bronx";
        cities[3] = "Brooklyn";

        int i = 0;
        while(i <cities.length){
            if(cities[i].toLowerCase().equals("brooklyn")){
                System.out.println("City is " + cities[i]);
            }else if (cities[i].toUpperCase().equals("Queens")){
                System.out.println("City is " + cities[i]);
            }//end of conditions


            i++;
        }//end of while loop
    }//end of main
}//end of java class
