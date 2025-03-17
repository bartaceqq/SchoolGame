package Objects;

public class Item {
   public String info;
    public String interaction;
    public String name;
    public Boolean pickable;

    @Override
    public String toString() {
        return "Item{" +
                "info='" + info + '\'' +
                ", interaction='" + interaction + '\'' +
                ", name='" + name + '\'' +
                ", pickable=" + pickable +
                '}';
    }
}
