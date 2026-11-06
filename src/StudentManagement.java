import java.util.ArrayList;
import java.util.Scanner;


public class StudentManagement {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;
        do{
            while(true){
                System.out.println(" 1. View Students list \n 2. Add Student details \n 3. Modify Student details \n 4. Delete Student details \n 5. Exit Application");
                System.out.print("Enter the choice : ");
                String input = scanner.nextLine().trim();

                try {
                    choice = Integer.parseInt(input);

                    if (choice >= 1 && choice <= 5) {
                        break; // This breaks the VALIDATION loop, proceeding to the switch below
                    } else {
                        System.out.println("Error: Please enter a number between 1 and 5.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Invalid input. Letters are not allowed. Please enter a number.");
                }
            }
            switch(choice){
                case 1 -> viewStudent();

                case 2 -> addStudent();

                case 3 -> modifyStudent();

                case 4 -> deleteStudent();

                case 5 -> {
                    System.out.println("exiting application bye bye tata");
                    System.exit(0);
                }

                default -> System.out.println("invalid choice");
            }
        }while(choice < 5);
    }

    private static void deleteStudent() {

        System.out.println("enter the StudentId to search : ");
        int sid = scanner.nextInt();

        Student student = findStudentById(sid);

        if(student==null){
            System.out.println("no record found on that uid ");

        }else{
            studentList.remove(student);
            System.out.println("Student entry deleted");
        }

    }

    private static void modifyStudent() {
        System.out.println("Enter the StudentId to Search : ");
        int sid = scanner.nextInt();

        scanner.nextLine();

        Student student = findStudentById(sid);

        if(student == null){
            System.out.println("Student with ID "+sid +" not found .");
            return;
        }

        System.out.print("Enter new name (Leave blank if not name change needed) :");
        String newName = scanner.nextLine();

        if(!newName.trim().isEmpty()){
            student.setName(newName);
        }

        System.out.print("Enter the new Age (Enter 0 if not age change needed) :");
        int newAge= scanner.nextInt();
        scanner.nextLine();

        if(newAge > 0){
           student.setAge(newAge);
        }

        System.out.print("Enter the Course name (Leave blank if not course change needed :");
        String newCourse = scanner.nextLine();

        if(!newCourse.trim().isEmpty()){
            student.setCourse(newCourse);
        }

        System.out.println("Student details updated ");

    }

    private static void addStudent() {
        System.out.print("Enter the Student id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the Name : ");
        String name = scanner.nextLine();
        System.out.print("Enter the Age : ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the Course : ");
        String course = scanner.nextLine();

        studentList.add(new Student(id,name,age,course));
        System.out.println("Details added ");
    }

    private static void viewStudent() {
        if(studentList.isEmpty()){
            System.out.println("No records found");
            return;
        }
        System.out.println("========Current Student Details ========");
        for(Student st : studentList){
            System.out.println(st);
        }
    }

    private static Student findStudentById(int id) {
        for (Student s : studentList) {
            if (s.getStudentId() == id) {
                return s;
            }
        }
        return null;
    }
}

