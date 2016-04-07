package com.frogans.designer.Utils;

import java.util.ArrayList;

/**
 * Created by naouf on 4/5/2016.
 */
public class Tools {
    public static String capitalizeFirstLetter(String moak) {
        return Character.toUpperCase(moak.charAt(0)) + moak.substring(1);
    }

    public static ArrayList<String> splitPosition(String wiwe) {
        ArrayList<String> temp = new ArrayList<>();
        for (String w : wiwe.split(",")) {
            temp.add(w);
        }
        return temp;
    }

    public static Double ifStringIsEmpty(String poka) {
        if (poka.equals("") || poka.isEmpty()) {
            return 0.0;
        } else
            return Double.parseDouble(poka);
    }
}
