public class Main {
    public static void main(String[] args) {
        Components components = new Components();
        MapLoader mapLoader = new MapLoader(components);
        //loadnuti mapi s itemama
        mapLoader.loadMap();
        Movement movement = new Movement(components);
        //posunuti do mistnosti pomoci napsani jmena mistnosti
        movement.move("park");
        //kontrola pozice
        movement.checkposition();
        //vypis itemu a osob v mistnosti
    components.printroomsthings();
        //posunuti do mistnosti pomoci napsani jmena mistnosti
        movement.move("garage");
        //kontrola pozice
        movement.checkposition();
        //vypis itemu a osob v mistnosti
        components.printroomsthings();
        }
    }
