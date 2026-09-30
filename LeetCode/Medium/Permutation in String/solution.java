class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] need = new int[26];
        int[] window = new int[26];

        for (char c : s1.toCharArray()) {
            need[c - 'a']++;
        }

        int k = s1.length();

        for (int right = 0; right < s2.length(); right++) {
            window[s2.charAt(right) - 'a']++;

            if (right >= k) {
                window[s2.charAt(right - k) - 'a']--;
            }

            if (java.util.Arrays.equals(need, window)) {
                return true;
            }
        }

        return false;
    }
}