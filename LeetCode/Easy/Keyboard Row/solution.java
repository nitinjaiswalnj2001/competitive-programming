class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
        };

        List<String> ans = new ArrayList<>();

        for (String word : words) {
            String w = word.toLowerCase();

            for (String row : rows) {
                boolean valid = true;

                for (char ch : w.toCharArray()) {
                    if (row.indexOf(ch) == -1) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    ans.add(word);
                    break;
                }
            }
        }

        return ans.toArray(new String[0]);
    }
}