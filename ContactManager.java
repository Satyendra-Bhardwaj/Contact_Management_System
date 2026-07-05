import java.io.*;
import java.util.*;

public class ContactManager {

    private ArrayList<Contact> contacts = new ArrayList<>();
    private final String FILE_NAME = "contacts.txt";

    public ContactManager() {
        loadContacts();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        saveContacts();
        System.out.println("Contact Added Successfully.");
    }

    public void viewContacts() {

        if (contacts.isEmpty()) {
            System.out.println("No Contacts Found.");
            return;
        }

        for (Contact c : contacts) {
            System.out.println("------------------------");
            System.out.println("Name : " + c.getName());
            System.out.println("Phone: " + c.getPhone());
            System.out.println("Email: " + c.getEmail());
        }
    }

    public void searchContact(String name) {

        for (Contact c : contacts) {

            if (c.getName().equalsIgnoreCase(name)) {

                System.out.println("Found:");
                System.out.println(c.getName());
                System.out.println(c.getPhone());
                System.out.println(c.getEmail());
                return;
            }
        }

        System.out.println("Contact Not Found.");
    }

    public void deleteContact(String name) {

        Iterator<Contact> iterator = contacts.iterator();

        while (iterator.hasNext()) {

            Contact c = iterator.next();

            if (c.getName().equalsIgnoreCase(name)) {

                iterator.remove();
                saveContacts();

                System.out.println("Deleted Successfully.");
                return;
            }
        }

        System.out.println("Contact Not Found.");
    }

    public void updateContact(String name, String phone, String email) {

        for (Contact c : contacts) {

            if (c.getName().equalsIgnoreCase(name)) {

                c.setPhone(phone);
                c.setEmail(email);

                saveContacts();

                System.out.println("Updated Successfully.");
                return;
            }
        }

        System.out.println("Contact Not Found.");
    }

    private void saveContacts() {

        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {

            for (Contact c : contacts) {
                pw.println(c);
            }

        } catch (IOException e) {
            System.out.println("Error Saving Contacts.");
        }
    }

    private void loadContacts() {

        File file = new File(FILE_NAME);

        if (!file.exists())
            return;

        try (Scanner sc = new Scanner(file)) {

            while (sc.hasNextLine()) {

                String[] data = sc.nextLine().split(",");

                contacts.add(new Contact(data[0], data[1], data[2]));
            }

        } catch (Exception e) {

            System.out.println("Error Loading Contacts.");
        }
    }
}