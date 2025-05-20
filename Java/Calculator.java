public class Calculator {
    public static void main(String[] args) {
        AdvCalc obj = new AdvCalc();
        int r1 = obj.add(49, 0);
        int r2 = obj.sub(10, 7);
        int r3 = obj.multi(12, 7);
        int r4 = obj.divide(14, 2);
        System.out.println(r1 + " " + r2 + " " + r3 + " " + r4);
    }
}
