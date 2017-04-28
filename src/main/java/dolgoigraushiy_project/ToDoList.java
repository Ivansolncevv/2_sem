package dolgoigraushiy_project;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shmalman on 14.04.2017.
 */
public class ToDoList {
    ArrayList<Item> items = new ArrayList<>();
    int count=1;

    void add(String task){
        int id = count++;
        items.add(new Item(id,task));
    }
    void delete (int id){
        for (Item item : items) {
            if (item.id == id) {
                items.remove(item);
                break;
            }
        }
    }
    List<Item> view(){
        return items;

    }
}
