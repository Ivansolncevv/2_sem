package dolgoigraushiy_project;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Shmalman on 14.04.2017.
 */
public class ToDoMain {
    public static void main(String[] args) throws SQLException {
        ToDoList list=new ToDoList();
        Scanner s=new Scanner(System.in);
        while (true){
            System.out.println("1 Сделать\n2 Сделать \n3 Сделать ");
            String cmd= s.nextLine();
            switch(cmd){
                case "1" :
                    System.out.println("Добавьте сторчку");
                    String prnt =s.nextLine();
                    list.add(prnt);
                    break;
                case "2" :
                    List<Item> items = list.view();
                    for (Item item : items) {
                        System.out.println(item.id+". "+item.text);
                    }

                    break;
                case "3" :
                    System.out.println("Введите ID");
                    int id=Integer.parseInt (s.nextLine());
                    list.delete(id);
                    break;

            }
        }
    }
}
