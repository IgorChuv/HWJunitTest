import java.util.*;

public class Contacts {
    public Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact){
        if(contact.getPhone() == (null)){
            System.out.println("Ошибка добавления контакта");
        }else{
        this.contacts.put(contact.getPhone(), contact);
        }
    }

    public void printAll(){
        System.out.println(this.contacts.values());
    }

    public String getFullName (String number){
        if(this.contacts.containsKey(number)){
            return " - " + contacts.get(number).getName() + " " + contacts.get(number).getSurname() + " ";
        }
        else{
            return " - Неизвестный контакт";
        }
    }
}
