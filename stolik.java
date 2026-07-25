import java.util.concurrent.ThreadLocalRandom;


public class stolik {
    private int tableNumber, sizeStolik = 0, seating = 2;
    private boolean isFree = true;

    public stolik(int newTableNumber) {
        tableNumber = newTableNumber;
        isFree = true;
        seating = ThreadLocalRandom.current().nextInt(2, 5);
    }

    public void getIt() {
        System.out.printf("Столик №%d занят.%n", tableNumber);
        this.isFree = false;
        this.sizeStolik = 0;
    }

    public void getFree() {
        System.out.printf("Столик №%d освобожден.%n", tableNumber);
        this.isFree = true;
        this.sizeStolik = 0;
    }

    public int getSize() { return sizeStolik; }
    public int getNumber() { return tableNumber; }
    public boolean isFree() { return isFree; }
    public int getSeating() { return seating; }

    public void addSize(int newSizeNumber) {
        if ((this.getSize() + newSizeNumber > 100) || (this.getSize() == 100)) {
            this.getFree();
        } else {
            this.sizeStolik += newSizeNumber;
        }
    }
    public void tick() {
        if(isFree) return;
        int randomIncrement = ThreadLocalRandom.current().nextInt(1, 16);
        this.addSize(randomIncrement);
    }

}
