package ActionItem_1;

public class DynamicArray {

    public static void main(String[] args) {

        //create a dynamic array for zipcode
        String[] zipcode = new String[4]; //you set the limit/boundaries for your array
        //now you define your value by the variables indexing
        zipcode[0] = "11111";
        zipcode[1] = "11112";
        zipcode[2] = "11113";
        zipcode[3] = "11114";

        System.out.println("My zipcode is " + zipcode[3]);

        //integer dynamic array
        int[] streetNumber = new int[4];
        streetNumber[0] = 200;
        streetNumber[1] = 400;
        streetNumber[2] = 500;
        streetNumber[3] = 600;
        System.out.println("My streetnumber is " + streetNumber[3]);


    }//end of main method
}//end of java class
