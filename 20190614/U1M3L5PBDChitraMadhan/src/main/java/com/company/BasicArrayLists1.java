
/*Create an ArrayList that can hold Integers.
Add ten copies of the number -113 to the ArrayList.
Then display the contents of the ArrayList on the screen.*/

package com.company;

import java.util.ArrayList;
import java.util.List;

public class BasicArrayLists1 {

    public static void main(String[] args) {
        List<Integer> basicArray = new ArrayList<>();

        int myInteger = -113;
        basicArray.add(myInteger);
        basicArray.add(myInteger);
        basicArray.add(myInteger);
        basicArray.add(myInteger);
        basicArray.add(myInteger);
        basicArray.add(myInteger);
        basicArray.add(myInteger);
        basicArray.add(myInteger);
        basicArray.add(myInteger);
        basicArray.add(myInteger);

        for (int i = 0; i < basicArray.size(); i++) {
            System.out.println("Slot " + i + " contains a " + basicArray.get(i) + ";");
        }
    }
}
