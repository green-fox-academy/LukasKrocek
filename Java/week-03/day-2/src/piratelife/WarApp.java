package piratelife;

public class WarApp {
    public static void main(String[] args) {
        Armada uSA = new Armada("USA");
        Armada china = new Armada("China");
        uSA.addShips(10);
        china.addShips(10);
        System.out.println("USA armada");
        System.out.println(uSA);
        System.out.println();
        System.out.println("Chinese armada");
        System.out.println(china);
        if (uSA.war(china)) {
            System.out.println("USA wins war");
        } else {
            System.out.println("China wins war");
        }
        System.out.println("---------");
        System.out.println("USA armada");
        System.out.println(uSA);
        System.out.println();
        System.out.println("Chinese armada");
        System.out.println(china);

    }
}
