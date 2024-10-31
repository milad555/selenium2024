package ClassWork;

public class NewMain {
    public static void main(String[] args) {
//        DonutShop sanJose = new DonutShop("MK", 1220, 4000);
//        DonutShop fremont = new DonutShop("MKK", 1120, 4400);
//
//       // System.out.println(sanJose.makeDonuts("koo"));
//        int sjListPrice = sanJose.getLeasePrice();
//        int frListPrice = fremont.getLeasePrice();
//        System.out.println(sjListPrice);
//        System.out.println(fremont);
//        sanJose.setLeasePrice(9000);
//        fremont.setLeasePrice(8000);
//        sanJose.sellDonut("Choco Donut", 3);
//


        Hero pauk = new Hero("Pauk", "Petya");
        Hero deadForLook = new Hero("Dead for Loop", "John Doe");
       // pauk.fightCrime();

        Car car1 = new Car(50,100, "Mazda", "RX7");
      //  mazda.drive();
        Car car2 = new Car(10, 400, "", "");
        car2.setMake("Lexus");
        car2.setModel("CT200");
        car2.drive();
        car2.fuelUp(100);
        car2.drive();
    }
}
