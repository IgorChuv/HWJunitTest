import java.time.*;
import java.util.*;

public class MissedCalls{
    public Map<String, LocalDateTime> missedCalls = new TreeMap<>();

    public void addCall(LocalDateTime date, String call){
        if(call==null){
            System.out.println("Ошибка добавления пропущенного вызова");
        }else{
            this.missedCalls.put(call, date);
        }
    }

   public void printAll(Contacts contacts){
       System.out.println("\nПропущенные вызовы:\n");
        if(this.missedCalls.isEmpty()){
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

    public void clearAllContacts(){
        System.out.println("\nВсе пропущенный вызовы удалены.\n");
        this.missedCalls.clear();
    }
}
