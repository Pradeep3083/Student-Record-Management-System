
import java.util.ArrayList;
import java.util.Scanner;



public class StudentManagementSystem{
    public static ArrayList<Student> studentList = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do { 
            System.out.println("\n==== Student Record Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student details by id");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("Enter your choice: ");

            choice = sc.nextInt();

            switch(choice){
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> viewStudentById();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> System.out.println("Existing program...");
                default -> System.out.println("Invalid choice! Try again.");
            }

        } while (choice!=6);
    }

    private static void addStudent() {
        System.out.println("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Marks: ");
        double marks = sc.nextDouble();

        studentList.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    private static void viewStudents() {
        if(studentList.isEmpty()){
            System.out.println("No student record found.");
        } else{
            System.out.println("\n--- Student Record ---");
            for(Student s : studentList){
                System.out.println(s);
            }
        }
    }

    private static void updateStudent(){
        System.out.println("Enter Student ID to update: ");
        int id = sc.nextInt();

        for(Student s : studentList){
            if(s.getId() == id){
                sc.nextLine();
                System.out.println("Enter new name: ");
                String newName = sc.nextLine();
                System.out.println("Enter new marks: ");
                double newMarks = sc.nextDouble();

                s.setName(newName);
                s.setMarks(newMarks);
                System.out.println("Student updated successfully!");
                return;
            }
        }
        System.out.println("Student with ID "+id+" not found.");
    }

    private static void deleteStudent(){
        System.out.println("Enter Student ID to delete: ");
        int id = sc.nextInt();
        for(Student s : studentList){
            if(s.getId() == id){
                studentList.remove(s);
                System.out.println("Student deleted successfully!");
                return;
            }
        }
        System.out.println("Student with ID "+id+" not found.");
    }

    private static void viewStudentById() {
        System.out.println("Enter Student ID: ");
        int id = sc.nextInt();
        for(Student s : studentList){
            if(s.getId() == id){
                System.out.println("Student [ ID = "+s.getId()+", Name = "+s.getName()+", Marks = "+s.getMarks()+" ]");
                return;
            }
        }
        System.out.println("Student with ID "+id+" not found.");
    }

}