package bayes;


import java.util.*;
import java.util.Map.Entry;

public class RankingList {

    public static Map<String, Float> sortByComparator(Map<String, Float> unsortMap, final boolean order) {
        List<Entry<String, Float>> list = new LinkedList<Entry<String, Float>>(unsortMap.entrySet());
        // Sorting the list based on values
        Collections.sort(list, new Comparator<Entry<String, Float>>() {
            public int compare(Entry<String, Float> o1,
                               Entry<String, Float> o2) {
                if (order) {
                    return o1.getValue().compareTo(o2.getValue());
                } else {
                    return o2.getValue().compareTo(o1.getValue());
                }
            }
        });
        Map<String, Float> sortedMap = new LinkedHashMap<String, Float>();
        for (Entry<String, Float> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public static void printMap(Map<String, Float> map) {
        for (Entry<String, Float> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }
    }

   
}
