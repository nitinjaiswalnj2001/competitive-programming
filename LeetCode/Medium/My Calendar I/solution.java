
import java.util.*;

class MyCalendar {
    private TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        Map.Entry<Integer, Integer> prev =
            calendar.floorEntry(startTime);

        if (prev != null && prev.getValue() > startTime) {
            return false;
        }

        Map.Entry<Integer, Integer> next =
            calendar.ceilingEntry(startTime);

        if (next != null && next.getKey() < endTime) {
            return false;
        }

        calendar.put(startTime, endTime);
        return true;
    }
}
