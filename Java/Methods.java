public class Methods {
    public static void main(String[] args) {

        Computer obj = new Computer();
        obj.playMusic();
        String str = obj.getName(12);
        System.out.println(str);
    }
}

class Computer {

    public void playMusic() {
        System.out.println("Playing Music...");
    }

    public String getName(int cost) {
        if (cost > 10) {
            return "New Computer";
        }
        return "Money is not enough";
    }
}
