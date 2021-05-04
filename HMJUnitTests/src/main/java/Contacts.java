

import java.util.*;

public class Contacts {
    public static Map<String, Contact> contacts = new HashMap<>();

    public  static void addContact(Contact contact){
        if(contact.getPhone() == (null)){
            System.out.println("Ошибка добавления контакта");
        }else{
        contacts.put(contact.getPhone(), contact);
        }
    }

    public static void printAll(){
        System.out.println(contacts.values());
    }

    public static String getFullName (String number){
        if(contacts.containsKey(number)){
            return " - " + contacts.get(number).getName() + " " + contacts.get(number).getSurname() + " ";
        }
        else{
            return " - Неизвестный контакт";
        }
    }
}
