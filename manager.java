import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class manager {
    private Map<Integer, stolik> allStolik = new HashMap<>();
    private ScheduledExecutorService timer = Executors.newScheduledThreadPool(1);

    public manager(int countOfTables) {
        for (int i = 0; i < countOfTables; i++) {
            addStolik(i);
        }
        timer.scheduleAtFixedRate(() -> {
            for (stolik table : allStolik.values()) {
                table.tick();
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    public void addStolik(int numberTable) {
        allStolik.put(numberTable, new stolik(numberTable));
    }

    public void getStolik(int numberTable, int requestSeating) {
        stolik table = allStolik.get(numberTable);

        if (table == null) {
            System.out.printf("Столик №%d не существует!%n", numberTable);
            return;
        }
        if(table.getSeating() < requestSeating){
            System.out.printf("У столика №%d не хватает заданных мест (Стол вмещает %d)!%n", numberTable, table.getSeating());
            return;
        }

        if (table.isFree()) {
            table.getIt();
        } else {
            System.out.printf("Столик №%d уже занят!%n", numberTable);
        }
    }
}
