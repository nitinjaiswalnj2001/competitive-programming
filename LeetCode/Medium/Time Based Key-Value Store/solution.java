import java.util.*;

class TimeMap {

    private static class Pair {
        String value;
        int timestamp;

        Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private final Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
           .add(new Pair(value, timestamp));
    }

    public String get(String key, int timestamp) {

        if (!map.containsKey(key)) {
            return "";
        }

        List<Pair> list = map.get(key);

        int low = 0;
        int high = list.size() - 1;

        String answer = "";

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid).timestamp <= timestamp) {
                answer = list.get(mid).value;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }
}