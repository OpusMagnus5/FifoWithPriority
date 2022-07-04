import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true){
            switch (in.nextLine()){
                case "1" :
                    FIFO.getInstance().add(in.nextLine(), Integer.parseInt(in.nextLine()));
                    break;
                case "2" :
                    FIFO.getInstance().addWithHighestPriority(in.nextLine());
                    break;
                case "3" :
                    System.out.println(FIFO.getInstance().get());
                    break;
                case "4" :
                    System.out.println(FIFO.getInstance().getHighestPriority());
            }
        }
    }
}
