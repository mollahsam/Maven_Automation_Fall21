package ActionItem_1;

public class ForloopA1 {

    public static void main(String[] args) {

        String[] zipcode = new String[4];
        zipcode[0] = "11111";
        zipcode[1] = "11112";
        zipcode[2] = "11113";
        zipcode[3] = "11114";

        int[] streetNumber = new int[4];
        streetNumber[0] = 200;
        streetNumber[1] = 400;
        streetNumber[2] = 500;
        streetNumber[3] = 600;

        //Forloop Example
        for(int i = 0; i <zipcode.length;i++) {
            //print statement
            System.out.println("My current zipcode is " + zipcode[i] + " and my street number is " + streetNumber[i]);

        }//end of for loop
    }//end of main
}//end of java
