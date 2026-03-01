import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
	private ContactService contactService;

    @BeforeEach
    public void setUp() {
        contactService = new ContactService();
    }

    // Test adding a valid contact
    @Test
    public void testAddContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        Contact retrievedContact = contactService.getContact("1234567890");
        assertNotNull(retrievedContact);
        assertEquals("1234567890", retrievedContact.getContactId());
        assertEquals("John", retrievedContact.getFirstName());
    }

    // Test adding a null contact
    @Test
    public void testAddNullContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(null);
        });
    }

    // Test adding a contact with duplicate ID
    @Test
    public void testAddDuplicateContactId() {
        Contact contact1 = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        Contact contact2 = new Contact("1234567890", "Jane", "Smith", "5559876543", "456 Oak Ave");
        
        contactService.addContact(contact1);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
    }

    // Test deleting a contact
    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        contactService.deleteContact("1234567890");
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact("1234567890");
        });
    }

    // Test deleting a non-existent contact
    @Test
    public void testDeleteNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("9999999999");
        });
    }

    // Test deleting with null contact ID
    @Test
    public void testDeleteNullContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact(null);
        });
    }

    // Test updating first name
    @Test
    public void testUpdateFirstName() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updateFirstName("1234567890", "Jane");
        
        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("Jane", updatedContact.getFirstName());
    }

    // Test updating first name with invalid value
    @Test
    public void testUpdateFirstNameInvalid() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("1234567890", "JohnJohnJon");
        });
    }

    // Test updating first name for non-existent contact
    @Test
    public void testUpdateFirstNameNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateFirstName("9999999999", "Jane");
        });
    }

    // Test updating last name
    @Test
    public void testUpdateLastName() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updateLastName("1234567890", "Smith");
        
        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("Smith", updatedContact.getLastName());
    }

    // Test updating last name with invalid value
    @Test
    public void testUpdateLastNameInvalid() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName("1234567890", "SmithSmithS");
        });
    }

    // Test updating last name for non-existent contact
    @Test
    public void testUpdateLastNameNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateLastName("9999999999", "Smith");
        });
    }

    // Test updating phone
    @Test
    public void testUpdatePhone() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updatePhone("1234567890", "5559876543");
        
        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("5559876543", updatedContact.getPhone());
    }

    // Test updating phone with invalid value
    @Test
    public void testUpdatePhoneInvalid() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone("1234567890", "555");
        });
    }

    // Test updating phone for non-existent contact
    @Test
    public void testUpdatePhoneNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updatePhone("9999999999", "5559876543");
        });
    }

    // Test updating address
    @Test
    public void testUpdateAddress() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        contactService.updateAddress("1234567890", "456 Oak Ave");
        
        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("456 Oak Ave", updatedContact.getAddress());
    }

    // Test updating address with invalid value
    @Test
    public void testUpdateAddressInvalid() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("1234567890", "1234567890123456789012345678901");
        });
    }

    // Test updating address for non-existent contact
    @Test
    public void testUpdateAddressNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateAddress("9999999999", "456 Oak Ave");
        });
    }

    // Test getting a contact
    @Test
    public void testGetContact() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        Contact retrievedContact = contactService.getContact("1234567890");
        
        assertNotNull(retrievedContact);
        assertEquals("1234567890", retrievedContact.getContactId());
        assertEquals("John", retrievedContact.getFirstName());
        assertEquals("Doe", retrievedContact.getLastName());
        assertEquals("5551234567", retrievedContact.getPhone());
        assertEquals("123 Main St", retrievedContact.getAddress());
    }

    // Test getting a non-existent contact
    @Test
    public void testGetNonExistentContact() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact("9999999999");
        });
    }

    // Test getting contact with null ID
    @Test
    public void testGetContactNullId() {
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact(null);
        });
    }

    // Test multiple operations in sequence
    @Test
    public void testMultipleOperations() {
        // Add contact
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contactService.addContact(contact);
        
        // Update fields
        contactService.updateFirstName("1234567890", "Jane");
        contactService.updateLastName("1234567890", "Smith");
        contactService.updatePhone("1234567890", "5559876543");
        contactService.updateAddress("1234567890", "456 Oak Ave");
        
        // Verify updates
        Contact updatedContact = contactService.getContact("1234567890");
        assertEquals("Jane", updatedContact.getFirstName());
        assertEquals("Smith", updatedContact.getLastName());
        assertEquals("5559876543", updatedContact.getPhone());
        assertEquals("456 Oak Ave", updatedContact.getAddress());
        
        // Delete contact
        contactService.deleteContact("1234567890");
        
        // Verify deletion
        assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact("1234567890");
        });
    }

    // Test service with boundary values
    @Test
    public void testBoundaryValues() {
        Contact contact = new Contact("1234567890", "JohnJohnJo", "DoeDoeDoeD", "5551234567", "123456789012345678901234567890");
        contactService.addContact(contact);
        
        Contact retrievedContact = contactService.getContact("1234567890");
        assertEquals("JohnJohnJo", retrievedContact.getFirstName());
        assertEquals("DoeDoeDoeD", retrievedContact.getLastName());
        assertEquals("123456789012345678901234567890", retrievedContact.getAddress());
    }
}
