package aircraftcarrier;

public class Main {
    public static void main(String[] args) {

        Carrier carrier = new Carrier(15, 20000);
        F16 f16 = new F16();
        System.out.println(f16.getStatus());
        carrier.add (f16);
        carrier.add(new F35());
        carrier.add(new F35());
        carrier.add(new F16());

        Carrier carrier2 = new Carrier(500, 750);
        carrier2.add(new F16());
        carrier2.add(new F16());
        carrier2.add(new F16());
        carrier2.add(new F16());
        carrier2.add(new F35());
        carrier2.add(new F35());
        carrier2.add(new F35());
        System.out.println(carrier.getStatus());
        carrier.fill();
        System.out.println(carrier.getStatus());
        carrier.fight(carrier2);
        System.out.println(carrier.getStatus());
        System.out.println(carrier2.getStatus());
    }
}
