

import java.time.*;
import java.util.*;

public class MissedCalls{
    public static Map<String, LocalDateTime> missedCalls = new TreeMap<>();

    public static void addCall(LocalDateTime date, String call){

        missedCalls.put(call, date);
    }

   public static void printAll(Contacts contacts){
       System.out.println("\nПропущенные вызовы:\n");
        if(missedCalls.isEmpty()){
            System.out.println("Список пропущенных вызовов пуст.\n");
        }
        for (Map.Entry<String, LocalDateTime> entry : missedCalls.entrySet()){
                System.out.println(entry.getValue().getDayOfMonth()
                        + "-" + entry.getValue().getMonth()
                        + "-" + entry.getValue().getYear()
                        + " " + entry.getValue().getHour()
                        + ":" + entry.getValue().getSecond()
                        + ":" + entry.getValue().getMinute()
                        + " Вызов: " + entry.getKey()
                        + contacts.getFullName(entry.getKey()) + "\n");
        }
    }

    public static void clearAllContacts(){
        System.out.println("\nВсе пропущенный вызовы удалены.\n");
        missedCalls.clear();
    }
}
