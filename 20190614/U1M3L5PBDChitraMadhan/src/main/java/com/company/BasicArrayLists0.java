
/*Create an ArrayList that can hold Integers.
Add ten copies of the number -113 to the ArrayList.
Then display the contents of the ArrayList on the screen.*/

package com.company;

import java.util.ArrayList;
import java.util.List;

public class BasicArrayLists0 {

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

        System.out.println("Slot 0 contains a "+basicArray.get(0) + ";"  );
        System.out.println("Slot 1 contains a "+basicArray.get(1) + ";"  );
        System.out.println("Slot 2 contains a "+basicArray.get(2) + ";"  );
        System.out.println("Slot 3 contains a "+basicArray.get(3) + ";"  );
        System.out.println("Slot 4 contains a "+basicArray.get(4) + ";"  );
        System.out.println("Slot 5 contains a "+basicArray.get(5) + ";"  );
        System.out.println("Slot 6 contains a "+basicArray.get(6) + ";"  );
        System.out.println("Slot 7 contains a "+basicArray.get(7) + ";"  );
        System.out.println("Slot 8 contains a "+basicArray.get(8) + ";"  );
        System.out.println("Slot 9 contains a "+basicArray.get(9) + ";"  );

    }
}
