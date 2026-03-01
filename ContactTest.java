import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
	// Test valid contact creation
    @Test
    public void testContactCreation() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("5551234567", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    // Test contact ID validation - null
    @Test
    public void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "5551234567", "123 Main St");
        });
    }

    // Test contact ID validation - too long
    @Test
    public void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "5551234567", "123 Main St");
        });
    }

    // Test contact ID validation - exactly 10 characters (boundary test)
    @Test
    public void testContactIdExactly10Characters() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
    }

    // Test first name validation - null
    @Test
    public void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Doe", "5551234567", "123 Main St");
        });
    }

    // Test first name validation - too long
    @Test
    public void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "JohnJohnJon", "Doe", "5551234567", "123 Main St");
        });
    }

    // Test first name validation - exactly 10 characters (boundary test)
    @Test
    public void testFirstNameExactly10Characters() {
        Contact contact = new Contact("1234567890", "JohnJohnJo", "Doe", "5551234567", "123 Main St");
        assertEquals("JohnJohnJo", contact.getFirstName());
    }

    // Test last name validation - null
    @Test
    public void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", null, "5551234567", "123 Main St");
        });
    }

    // Test last name validation - too long
    @Test
    public void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "DoeDoeDoeDo", "5551234567", "123 Main St");
        });
    }

    // Test last name validation - exactly 10 characters (boundary test)
    @Test
    public void testLastNameExactly10Characters() {
        Contact contact = new Contact("1234567890", "John", "DoeDoeDoeD", "5551234567", "123 Main St");
        assertEquals("DoeDoeDoeD", contact.getLastName());
    }

    // Test phone validation - null
    @Test
    public void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", null, "123 Main St");
        });
    }

    // Test phone validation - not exactly 10 digits (too short)
    @Test
    public void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "555123456", "123 Main St");
        });
    }

    // Test phone validation - not exactly 10 digits (too long)
    @Test
    public void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "55512345678", "123 Main St");
        });
    }

    // Test phone validation - contains non-digits
    @Test
    public void testPhoneContainsNonDigits() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "555-123-456", "123 Main St");
        });
    }

    // Test phone validation - exactly 10 digits (valid)
    @Test
    public void testPhoneExactly10Digits() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertEquals("5551234567", contact.getPhone());
    }

    // Test address validation - null
    @Test
    public void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "5551234567", null);
        });
    }

    // Test address validation - too long
    @Test
    public void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "John", "Doe", "5551234567", "1234567890123456789012345678901");
        });
    }

    // Test address validation - exactly 30 characters (boundary test)
    @Test
    public void testAddressExactly30Characters() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123456789012345678901234567890");
        assertEquals("123456789012345678901234567890", contact.getAddress());
    }

    // Test setFirstName with valid input
    @Test
    public void testSetFirstNameValid() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    // Test setFirstName with null
    @Test
    public void testSetFirstNameNull() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }

    // Test setFirstName with too long
    @Test
    public void testSetFirstNameTooLong() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("JaneJaneJan");
        });
    }

    // Test setLastName with valid input
    @Test
    public void testSetLastNameValid() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    // Test setLastName with null
    @Test
    public void testSetLastNameNull() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    // Test setLastName with too long
    @Test
    public void testSetLastNameTooLong() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("SmithSmithS");
        });
    }

    // Test setPhone with valid input
    @Test
    public void testSetPhoneValid() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contact.setPhone("5559876543");
        assertEquals("5559876543", contact.getPhone());
    }

    // Test setPhone with null
    @Test
    public void testSetPhoneNull() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
    }

    // Test setPhone with invalid length
    @Test
    public void testSetPhoneInvalidLength() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("555123");
        });
    }

    // Test setPhone with non-digits
    @Test
    public void testSetPhoneNonDigits() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("555-123-456");
        });
    }

    // Test setAddress with valid input
    @Test
    public void testSetAddressValid() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contact.setAddress("456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    // Test setAddress with null
    @Test
    public void testSetAddressNull() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }

    // Test setAddress with too long
    @Test
    public void testSetAddressTooLong() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("1234567890123456789012345678901");
        });
    }

    // Test that contactId cannot be updated (no setter exists)
    @Test
    public void testContactIdNotUpdatable() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        // Verify ID is accessible but cannot be changed
        assertEquals("1234567890", contact.getContactId());
        // There should be no setContactId method available
    }
}
