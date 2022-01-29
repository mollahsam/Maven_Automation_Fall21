package ActionItem_1;

public class WhileloopA1 {

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

        //Whileloop Example
        int i = 0;
        while(i<zipcode.length){
            System.out.println("My zipcode is " + zipcode[i] + " and my street number is " + streetNumber[i]);
            i = i+1;

        }//end of while loop
    }//end of main
}//end of java

