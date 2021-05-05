import org.junit.jupiter.api.Assertions;

public class ContactsTest {

    private final Contacts phoneContacts  = new Contacts();

    @org.junit.jupiter.api.Test
    public void addContact_validArgument_success() {
        final Contact contact = new Contact("Name", "Surname", "+79345696708", "Group");

        phoneContacts.addContact(contact);

        final boolean keyResult = phoneContacts.contacts.containsKey(contact.getPhone());
        final boolean valueResult = phoneContacts.contacts.containsValue(contact);
        Assertions.assertTrue(keyResult);
        Assertions.assertTrue(valueResult);

    }
    @org.junit.jupiter.api.Test
    public void addContact_notValidArgument_success() {
        final Contact contact = new Contact(null, null, null, null);

        phoneContacts.addContact(contact);

        final boolean keyResult = phoneContacts.contacts.containsKey(contact.getPhone());
        final boolean valueResult = phoneContacts.contacts.containsValue(contact);

        Assertions.assertFalse(keyResult);
        Assertions.assertFalse(valueResult);

    }
    @org.junit.jupiter.api.Test
    public void addContact_argumentsEquals_success() {
        final Contact contact = new Contact("Name", "Surname", "+79345696708", "Group");

        phoneContacts.addContact(contact);

        final Contact result = phoneContacts.contacts.get(contact.getPhone());

        Assertions.assertEquals(contact, result);

    }


}
