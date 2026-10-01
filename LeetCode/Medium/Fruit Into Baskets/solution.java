import java.util.*;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> freq = new HashMap<>();

        int left = 0;
        int ans = 0;

        for (int right = 0; right < fruits.length; right++) {
            freq.put(
                fruits[right],
                freq.getOrDefault(fruits[right], 0) + 1
            );

            while (freq.size() > 2) {
                int fruit = fruits[left];

                freq.put(fruit, freq.get(fruit) - 1);

                if (freq.get(fruit) == 0) {
                    freq.remove(fruit);
                }

                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}