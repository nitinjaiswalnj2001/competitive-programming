class Solution {
    public int maxSatisfied(
        int[] customers,
        int[] grumpy,
        int minutes
    ) {
        int baseSatisfied = 0;

        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                baseSatisfied += customers[i];
            }
        }

        int extra = 0;
        int maxExtra = 0;

        for (int right = 0; right < customers.length; right++) {

            if (grumpy[right] == 1) {
                extra += customers[right];
            }

            if (right >= minutes && grumpy[right - minutes] == 1) {
                extra -= customers[right - minutes];
            }

            maxExtra = Math.max(maxExtra, extra);
        }

        return baseSatisfied + maxExtra;
    }
}