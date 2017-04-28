package dolgoigraushiy_project;


public class Item {
    int id;

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    String text;

    public Item(int id, String text) {
        this.id = id;
        this.text = text;
    }
}
