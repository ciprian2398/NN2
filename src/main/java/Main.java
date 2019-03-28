public class Main {
    public static void main(String[] args) {
        Bulk bulk1 = new Bulk(1);
        Bulk bulk2 = new Bulk(2);
        Bulk bulk3 = new Bulk(3);

        bulk2.setAsInput(bulk1);
        bulk2.setAsOutput(bulk3);

        bulk1.neurons.get(0).outputsCascade(1);
        System.out.println("-------------");
        bulk3.neurons.get(0).inputsCascade(1);
    }
}
