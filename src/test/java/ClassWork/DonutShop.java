package ClassWork;

public class DonutShop {

    public String name;
    public int squareFeet;

    private int leasePrice;

    public DonutShop(String storeName, int squareFeet, int leasePrice){
        this.name = storeName;
        this.squareFeet = squareFeet;
        this.leasePrice = leasePrice;
    }

    public String[] sellDonut(String type, int quantity){

        //ArrayList<String> donut = new ArrayList<>();
        String[] donut = new String[quantity];
        for (int i = 0; i < quantity; i++) {
            donut[i] = makeDonuts(type);
            System.out.println("your donuts: " + donut[i]);
        }

        return donut;
    }
    private String makeDonuts(String type){
        return  type + " for Milad";
    }

    public int getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(int leasePrice) {
        this.leasePrice = leasePrice;
    }
}
