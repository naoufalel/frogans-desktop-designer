package com.frogans.designer.Utils;

import java.util.ArrayList;

/** this class contains functions we use to capitalize the first letter of a string
 * check if a string is empty and split a string using a separator
 */
public class Tools {

    /**
     * this function has en entry of a string and changes the first letter of the string
     * to upper case
     *
     * @param fletter
     * @return
     */
    public static String capitalizeFirstLetter(String fletter) {
        return Character.toUpperCase(fletter.charAt(0)) + fletter.substring(1);
    }

    /**
     * this function splits our string according to a separator we choose and returns an arraylist
     * of the parts of the string
     *
     * @param pos
     * @return
     */
    public static ArrayList<String> splitPosition(String pos) {
        ArrayList<String> temp = new ArrayList<>();
        for (String w : pos.split(",")) {
            temp.add(w);
        }
        return temp;
    }

    /**
     * this function checks if the string is empty
     *
     * @param Strn
     * @return
     */
    public static Double ifStringIsEmpty(String Strn) {
        if (Strn.equals("") || Strn.isEmpty()) {
            return 0.0;
        } else
            return Double.parseDouble(Strn);
    }
}
