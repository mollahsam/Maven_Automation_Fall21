package ActionItem_1;

public class Forloop {
    public static void main(String[] args) {

        //iterate through all zipcode defined by dynamic array for loop
        String[] zipcode = new String[4];
        zipcode[0] = "11111";
        zipcode[1] = "11112";
        zipcode[2] = "11113";
        zipcode[3] = "11114";

        for(int i = 0; i <zipcode.length;i++){
            //print statement
            System.out.println("My current zipcode is " + zipcode[i]);

        }//end of for loop
    }//end of main method
}//end of java class

