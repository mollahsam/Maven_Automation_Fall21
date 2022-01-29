package ActionItem_2;

import jdk.jshell.StatementSnippet;

public class ActionItem_2A {

    public static void main(String[] args) {

        String[] states = new String[4];
        states[0] = "New York";
        states[1] = "California";
        states[2] = "New Jersey";
        states[3] = "Ohio";

        int i = 0;
        while (i <states.length){
            if(states[i] == "New York"){
                System.out.println("State is " + states[i]);
            }else if (states[i] == "California"){
                System.out.println("State is " + states[i]);
            }//end of conditions
            i++;
        }//end of while loop
    }//end of main
}//end of java class

