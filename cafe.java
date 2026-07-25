import java.util.Scanner;

public class cafe{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        manager mgr = new manager(10);


        while (true) {
            int number = input.nextInt();

            if (number == -1) {
                break;
            }
            int seats = input.nextInt();

            mgr.getStolik(number, seats);
        }

        input.close();
    }
}
