package piratelife;

public class WarApp {
    public static void main(String[] args) {
        Armada uSA = new Armada();
        Armada china = new Armada();
        uSA.addShips(5);
        china.addShips(5);
        System.out.println(uSA);
        System.out.println();
        System.out.println(china);
        uSA.war(china);
        System.out.println("---------");
        System.out.println(uSA);
        System.out.println();
        System.out.println(china);

    }
}
