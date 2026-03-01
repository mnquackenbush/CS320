import java.util.ArrayList;
import java.util.List;

public class ContactService {
	// List to store contacts
    private List<Contact> contacts;

    /**
     * Constructor initializes the contact list
     */
    public ContactService() {
        contacts = new ArrayList<>();
    }

    /**
     * Adds a contact with a unique ID
     * @param contact The contact to add
     * @throws IllegalArgumentException if contact is null or ID already exists
     */
    public void addContact(Contact contact) {
        if (contact == null) {
            throw new IllegalArgumentException("Contact cannot be null");
        }
        
        // Check for unique ID
        for (Contact existingContact : contacts) {
            if (existingContact.getContactId().equals(contact.getContactId())) {
                throw new IllegalArgumentException("Contact ID already exists");
            }
        }
        
        contacts.add(contact);
    }

    /**
     * Deletes a contact by contact ID
     * @param contactId The ID of the contact to delete
     * @throws IllegalArgumentException if contact ID is not found
     */
    public void deleteContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        
        Contact contactToRemove = null;
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                contactToRemove = contact;
                break;
            }
        }
        
        if (contactToRemove == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        
        contacts.remove(contactToRemove);
    }

    /**
     * Updates the first name of a contact
     * @param contactId The ID of the contact to update
     * @param firstName The new first name
     * @throws IllegalArgumentException if contact ID is not found
     */
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = getContact(contactId);
        contact.setFirstName(firstName);
    }

    /**
     * Updates the last name of a contact
     * @param contactId The ID of the contact to update
     * @param lastName The new last name
     * @throws IllegalArgumentException if contact ID is not found
     */
    public void updateLastName(String contactId, String lastName) {
        Contact contact = getContact(contactId);
        contact.setLastName(lastName);
    }

    /**
     * Updates the phone number of a contact
     * @param contactId The ID of the contact to update
     * @param phone The new phone number
     * @throws IllegalArgumentException if contact ID is not found
     */
    public void updatePhone(String contactId, String phone) {
        Contact contact = getContact(contactId);
        contact.setPhone(phone);
    }

    /**
     * Updates the address of a contact
     * @param contactId The ID of the contact to update
     * @param address The new address
     * @throws IllegalArgumentException if contact ID is not found
     */
    public void updateAddress(String contactId, String address) {
        Contact contact = getContact(contactId);
        contact.setAddress(address);
    }

    /**
     * Retrieves a contact by contact ID
     * @param contactId The ID of the contact to retrieve
     * @return The contact with the specified ID
     * @throws IllegalArgumentException if contact ID is not found
     */
    public Contact getContact(String contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Contact ID cannot be null");
        }
        
        for (Contact contact : contacts) {
            if (contact.getContactId().equals(contactId)) {
                return contact;
            }
        }
        
        throw new IllegalArgumentException("Contact ID not found");
    }
}
