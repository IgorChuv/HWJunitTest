import org.junit.jupiter.api.Assertions;

public class ContactsTest {

    @org.junit.jupiter.api.Test
    public void addContact_validArgument_success() {
        final Contact contact = new Contact("Name", "Surname", "+79345696708", "Group");

        Contacts.addContact(contact);

        final boolean keyResult = Contacts.contacts.containsKey(contact.getPhone());
        final boolean valueResult = Contacts.contacts.containsValue(contact);
        Assertions.assertTrue(keyResult);
        Assertions.assertTrue(valueResult);

    }
    @org.junit.jupiter.api.Test
    public void addContact_notValidArgument_success() {
        final Contact contact = new Contact(null, null, null, null);

        Contacts.addContact(contact);

        final boolean keyResult = Contacts.contacts.containsKey(contact.getPhone());
        final boolean valueResult = Contacts.contacts.containsValue(contact);

        Assertions.assertFalse(keyResult);
        Assertions.assertFalse(valueResult);

    }
    @org.junit.jupiter.api.Test
    public void addContact_argumentsEquals_success() {
        final Contact contact = new Contact("Name", "Surname", "+79345696708", "Group");

        Contacts.addContact(contact);
        
        final Contact result = Contacts.contacts.get(contact.getPhone());

        Assertions.assertEquals(contact, result);

    }


}
