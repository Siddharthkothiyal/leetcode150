package twoPointers;

import java.util.HashMap;

public class twosum {
  public int[] twoSum(int[] numbers, int target) {
          HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {

            int compli = target - numbers[i];

            if (map.containsKey(compli)) {

               return new int[]{map.get(compli), i + 1};

            } else {
                map.putIfAbsent( numbers[i], i+1);
            }
        }

        return new int[0];
    }

}
