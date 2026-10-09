import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);

        int[] answer = new int[spells.length];
        int n = potions.length;

        for (int i = 0; i < spells.length; i++) {

            int low = 0;
            int high = n - 1;
            int firstSuccessful = n;

            while (low <= high) {
                int mid = low + (high - low) / 2;

                long product = (long) spells[i] * potions[mid];

                if (product >= success) {
                    firstSuccessful = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            answer[i] = n - firstSuccessful;
        }

        return answer;
    }
}