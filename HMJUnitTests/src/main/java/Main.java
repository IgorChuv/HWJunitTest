import java.util.*;
import java.time.*;
public class Main {

    public static void main(String[] args){
        Contacts phoneContacts  = new Contacts();
        MissedCalls missedCalls = new MissedCalls();
        Scanner scanner = new Scanner(System.in);

        System.out.printf("%40s","Программа: пропущенные вызовы.\n");
        while(true) {
            System.out.println("Меню:\n1.Добавить контакт\n2.Добавить пропущенный вызов\n3.Вывести все пропущенные вызовы\n4.Очистить пропущенные вызовы\n5.Выход\n ");
            System.out.println("Выберите пункт из меню: ");
            int input = scanner.nextInt();
            if(input == 5){
                break;
            }
            switch (input) {
                case 1:
                    System.out.println("Добавте новый контакт(Имя, Фамилия и номер телефона через пробел)");
                    scanner.nextLine();
                    String newContact = scanner.nextLine();
                    String [] sp = newContact.split(" ");
                    if(sp.length != 3){
                        System.out.println("\nНеверно введены данные!\n");
                        continue;
                    }
                    System.out.println("Выбирите группу контакта:\n" + "1." + Group.WORK.getName() + "\n2." + Group.FRIENDS.getName() + "\n3." + Group.FAMILY.getName());
                    int chooseGroup = scanner.nextInt();
                    String groupName = " ";

                    switch(chooseGroup){
                        case 1:
                            groupName = Group.WORK.getName();
                            break;
                        case 2:
                            groupName = Group.FRIENDS.getName();
                            break;
                        case 3:
                            groupName = Group.FAMILY.getName();
                            break;
                    }

                    Contact contact = new Contact(sp[0],sp[1],sp[2],groupName);
                    phoneContacts.addContact(contact);
                    System.out.println("\nnНовый контакт добавлен\n");
                    break;
                case 2:
                    System.out.println("Добавьте номер пропущенного вызова");
                    scanner.nextLine();
                    String missContact = scanner.nextLine();
                    LocalDateTime local = LocalDateTime.now();
                    missedCalls.addCall(local, missContact);
                    System.out.println("Вызов добавлен в пропущенные");
                    break;
                case 3:
                    missedCalls.printAll(phoneContacts);
                    break;
                case 4:
                    missedCalls.clearAllContacts();
                    break;
            }
        }
        scanner.close();
    }
}
