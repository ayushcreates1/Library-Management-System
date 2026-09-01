{

    int bookId;
    int totalCopy = 0;
    int avlCopy = 0;

    String bookName = "";
    String author = "";
    String bookCategory = "";

    boolean bookAdded = false;

    Scanner sc = new Scanner(System.in);

    // ================= ADD BOOK =================
    void addBook() {

        System.out.println("\n===== ADD BOOK =====");

        System.out.print("Enter Book ID: ");
        bookId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Name: ");
        bookName = sc.nextLine();

        System.out.print("Enter Book Author: ");
        author = sc.nextLine();

        System.out.print("Enter Book Category: ");
        bookCategory = sc.nextLine();

        System.out.print("Enter Total No. of Books: ");
        totalCopy = sc.nextInt();

        avlCopy = totalCopy;
        bookAdded = true;

        System.out.println("\nBook Added Successfully!");
    }

    // ================= VIEW BOOK =================
    void viewBook() {

        if (!bookAdded) {
            System.out.println("\nNo Book Added!");
            return;
        }

        System.out.println("\n===== BOOK DETAILS =====");
        System.out.println("Book ID          : " + bookId);
        System.out.println("Book Name        : " + bookName);
        System.out.println("Book Author      : " + author);
        System.out.println("Book Category    : " + bookCategory);
        System.out.println("Total Copies     : " + totalCopy);
        System.out.println("Available Copies : " + avlCopy);
    }

    // ================= SEARCH BOOK =================
    void searchBook() {

        if (!bookAdded) {
            System.out.println("\nNo Book Added!");
            return;
        }

        System.out.println("\n===== SEARCH BOOK =====");
        System.out.println("1. Search by Book ID");
        System.out.println("2. Search by Book Name");

        System.out.print("Enter Your Choice: ");
        int choice = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        if (choice == 1) {

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();

            if (id == bookId) {
                viewBook();
                found = true;
            }

        } else if (choice == 2) {

            System.out.print("Enter Book Name: ");
            String name = sc.nextLine();

            if (name.equalsIgnoreCase(bookName)) {
                viewBook();
                found = true;
            }

        } else {
            System.out.println("Invalid Choice!");
            return;
        }

        if (!found) {
            System.out.println("\nBook Not Found!");
        }
    }

    // ================= ISSUE BOOK =================
    void issueBook() {

        if (!bookAdded) {
            System.out.println("\nNo Book Added!");
            return;
        }

        if (avlCopy > 0) {

            avlCopy--;

            System.out.println("\nBook Issued Successfully!");
            System.out.println("Available Copies: " + avlCopy);

        } else {
            System.out.println("\nBook is Not Available!");
        }
    }

    // ================= RETURN BOOK =================
    void returnBook() {

        if (!bookAdded) {
            System.out.println("\nNo Book Added!");
            return;
        }

        if (avlCopy < totalCopy) {

            avlCopy++;

            System.out.println("\nBook Returned Successfully!");
            System.out.println("Available Copies: " + avlCopy);

        } else {
            System.out.println("\nAll Books are Already Available!");
        }
    }

    // ================= DELETE BOOK =================
    void deleteBook() {

        if (!bookAdded) {
            System.out.println("\nNo Book Added!");
            return;
        }

        bookId = 0;
        bookName = "";
        author = "";
        bookCategory = "";
        totalCopy = 0;
        avlCopy = 0;

        bookAdded = false;

        System.out.println("\nBook Deleted Successfully!");
    }

    // ================= LIBRARY REPORT =================
    void libraryReport() {

        if (!bookAdded) {
            System.out.println("\nNo Book Added!");
            return;
        }

        System.out.println("\n===== LIBRARY REPORT =====");
        System.out.println("Book ID          : " + bookId);
        System.out.println("Book Name        : " + bookName);
        System.out.println("Total Copies     : " + totalCopy);
        System.out.println("Available Copies : " + avlCopy);
        System.out.println("Issued Copies    : " + (totalCopy - avlCopy));
    }

    // ================= MAIN MENU =================
    void mainMenu() {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("     LIBRARY MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Book");
            System.out.println("2. View Book");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Library Report");
            System.out.println("8. Exit");
            System.out.println("=================================");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBook();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    issueBook();
                    break;

                case 5:
                    returnBook();
                    break;

                case 6:
                    deleteBook();
                    break;

                case 7:
                    libraryReport();
                    break;

                case 8:
                    System.out.println("\nThank You!");
                    System.out.println("Program Exited Successfully.");
                    break;

                default:
                    System.out.println("\nInvalid Choice! Please Try Again.");
            }

        } while (choice != 8);

        sc.close();
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        Main obj = new Main();

        obj.mainMenu();
    }
}