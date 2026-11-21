package collections;

import java.util.HashMap;
import java.util.Map;

public class ShoeSizeMap {
    public static void main(String[] args) {
        int[][] shoes = {{1, 26}, {0, 26}, {1, 27}, {0, 29}};

        System.out.println(checkPairs(shoes));
    }

    private static boolean checkPairs(int[][] shoes) {
        boolean result =true;

        Map<Integer, Integer> sizeCount = new HashMap<>();

        for(int[] arr : shoes) {
            int side = arr[0];
            int size = arr[1];

            int count = sizeCount.getOrDefault(size, 0);

            if(side ==1) {
                count++;
            } else {
                count--;
            }

            sizeCount.put(size, count);
        }

        for(int count : sizeCount.values()) {
            if(count != 0) {
                result = false;
                break;
            }
        }

        return result;
    }
}

