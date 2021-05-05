import org.junit.jupiter.api.Assertions;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MissedCallsTest {

    private final MissedCalls missedCallsTest = new MissedCalls();

    @org.junit.jupiter.api.Test
    public void addCall_validArgument_success() {
        LocalDateTime local = LocalDateTime.now();
        final Contact contact = new Contact("Name", "Surname", "+79345696708", "Group");

        missedCallsTest.addCall(local,contact.getPhone());

        final boolean keyResult = missedCallsTest.missedCalls.containsKey(contact.getPhone());
        final boolean valueResult = missedCallsTest.missedCalls.containsValue(local);
        Assertions.assertTrue(keyResult);
        Assertions.assertTrue(valueResult);
    }

    @org.junit.jupiter.api.Test
    public void addCall_nullArgument_throwsException() {
        final Contact contact = new Contact(null, null, null, null);

        missedCallsTest.addCall(null,contact.getPhone());

        assertThrows(NullPointerException.class,() -> missedCallsTest.missedCalls.containsKey(contact.getPhone()));

    }
    @org.junit.jupiter.api.Test
    public void clearAllContacts_mapIsEmpty_success(){
        final Contact contact = new Contact("Name", "Surname", "+79345696708", "Group");
        LocalDateTime local = LocalDateTime.now();
        missedCallsTest.addCall(local,contact.getPhone());
        missedCallsTest.clearAllContacts();
        final boolean result = missedCallsTest.missedCalls.isEmpty();
        Assertions.assertTrue(result);

    }
}
