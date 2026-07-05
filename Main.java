import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        while (true) {

            System.out.println("\n===== CONTACT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");

            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    manager.addContact(new Contact(name, phone, email));
                    break;

                case 2:
                    manager.viewContacts();
                    break;

                case 3:
                    System.out.print("Enter Name: ");
                    manager.searchContact(sc.nextLine());
                    break;

                case 4:
                    System.out.print("Name: ");
                    String n = sc.nextLine();

                    System.out.print("New Phone: ");
                    String p = sc.nextLine();

                    System.out.print("New Email: ");
                    String e = sc.nextLine();

                    manager.updateContact(n, p, e);
                    break;

                case 5:
                    System.out.print("Enter Name: ");
                    manager.deleteContact(sc.nextLine());
                    break;

                case 6:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}