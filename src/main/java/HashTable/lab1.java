package HashTable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class lab1 {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, Integer> map = new HashMap<>();
        try (Scanner s = new Scanner(
                new File("text.txt"), "Cp1251")) {
            while (s.hasNext()) {
                String word = s.next();
                if (map.containsKey(word)) {
                    int count = map.get(word);
                    map.put(word, count + 1);
                } else {
                    map.put(word, 1) ;
                }
            }

        }
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((p1, p2) -> -p1.getValue().compareTo(p2.getValue()));
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry);
        }
    }

}
