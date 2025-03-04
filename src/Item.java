public class Item {
    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", pickable=" + pickable +
                '}';
    }

    String name;
    Boolean pickable;
}
