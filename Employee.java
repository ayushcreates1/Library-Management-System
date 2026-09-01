{

    static Scanner sc = new Scanner(System.in);

    static Employee[] employees = new Employee[100];
    static int count = 0;

    // Add Employee
    static void addEmployee() {

        if (count >= employees.length) {
            System.out.println("Employee storage is full!");
            return;
        }

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // Check duplicate ID
        for (int i = 0; i < count; i++) {
            if (employees[i].id == id) {
                System.out.println("Employee ID already exists!");
                return;
            }
        }

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        if (salary < 0) {
            System.out.println("Salary cannot be negative!");
            return;
        }

        employees[count] =
            new Employee(id, name, department, salary);

        count++;

        System.out.println("Employee added successfully!");
    }

    // View All Employees
    static void viewEmployees() {

        if (count == 0) {
            System.out.println("No employee records found!");
            return;
        }

        System.out.println("\n================================");
        System.out.println("       ALL EMPLOYEE DETAILS");
        System.out.println("================================");

        for (int i = 0; i < count; i++) {
            employees[i].displayEmployee();
        }
    }

    // Search Employee
    static void searchEmployee() {

        if (count == 0) {
            System.out.println("No employee records found!");
            return;
        }

        System.out.print("Enter Employee ID to search: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (employees[i].id == id) {
                System.out.println("\nEmployee found!");
                employees[i].displayEmployee();
                return;
            }
        }

        System.out.println("Employee not found!");
    }

    // Update Salary
    static void updateSalary() {

        if (count == 0) {
            System.out.println("No employee records found!");
            return;
        }

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (employees[i].id == id) {

                System.out.print("Enter New Salary: ");
                double salary = sc.nextDouble();

                if (salary < 0) {
                    System.out.println("Salary cannot be negative!");
                    return;
                }

                employees[i].salary = salary;

                System.out.println("Salary updated successfully!");
                return;
            }
        }

        System.out.println("Employee not found!");
    }

    // Delete Employee
    static void deleteEmployee() {

        if (count == 0) {
            System.out.println("No employee records found!");
            return;
        }

        System.out.print("Enter Employee ID to delete: ");
        int id = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (employees[i].id == id) {

                // Shift elements to left
                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }

                employees[count - 1] = null;
                count--;

                System.out.println("Employee deleted successfully!");
                return;
            }
        }

        System.out.println("Employee not found!");
    }

    // Main Method
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n======================================");
            System.out.println("       EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("======================================");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.println("======================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addEmployee();
                    break;

                case 2:
                    viewEmployees();
                    break;

                case 3:
                    searchEmployee();
                    break;

                case 4:
                    updateSalary();
                    break;

                case 5:
                    deleteEmployee();
                    break;

                case 6:
                    System.out.println(
                        "Thank you for using Employee Management System!"
                    );
                    break;

                default:
                    System.out.println(
                        "Invalid choice! Please enter 1-6."
                    );
            }

        } while (choice != 6);

        sc.close();
    }
}