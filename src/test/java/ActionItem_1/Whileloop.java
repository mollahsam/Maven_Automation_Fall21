package ActionItem_1;

public class Whileloop {
    public static void main(String[] args) {

        //iterate through all zipcode defined by dynamic array for loop
        String[] zipcode = new String[4];
        zipcode[0] = "11111";
        zipcode[1] = "11112";
        zipcode[2] = "11113";
        zipcode[3] = "11114";

        //declare and define the initial starting point
        int i = 0;
        //define while loop with your end point (condition)
        while(i<zipcode.length){
            System.out.println("My current zipcode is " + zipcode[i]);
            i = i+1; //this is the incrementation step, if this step is not in code, then the while loop becomes an

    }//end of while loop
}//end of main method
}// end of java class
