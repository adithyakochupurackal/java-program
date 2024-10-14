import java.util.*;

public class menudriven{
    
    static class Student {
        private String name;
        private String rollNumber;
        private Map<Integer, List<Integer>> semesterMarks; 
        public Student(String name, String rollNumber) {
            this.name = name;
            this.rollNumber = rollNumber;
            this.semesterMarks = new HashMap<>();
        }

        public String getName() {
            return name;
        }

        public String getRollNumber() {
            return rollNumber;
        }

        public void addMarks(int semester, List<Integer> marks) {
            semesterMarks.put(semester, marks);
        }

        public Map<Integer, List<Integer>> getSemesterMarks() {
            return semesterMarks;
        }

        public void displayStudentDetails() {
            System.out.println("Name: " + name);
            System.out.println("Roll Number: " + rollNumber);
            if (semesterMarks.isEmpty()) {
                System.out.println("No semester marks available.");
            } else {
                for (Map.Entry<Integer, List<Integer>> entry : semesterMarks.entrySet()) {
                    System.out.println("Semester " + entry.getKey() + " Marks: " + entry.getValue());
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Student> students = new HashMap<>();
        boolean loop= false;

        while (!loop){
            System.out.println("\n----- Menu -----");
            System.out.println("1. Add New Student");
            System.out.println("2. Add Marks for a Student");
            System.out.println("3. Display Student Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
        
                    System.out.print("Enter student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student's roll number: ");
                    String rollNumber = scanner.nextLine();
                    Student student = new Student(name, rollNumber);
                    students.put(rollNumber, student);
                    System.out.println("Student added successfully.");
                    break;

                case 2:
                   
                    System.out.print("Enter student's roll number: ");
                    rollNumber = scanner.nextLine();
                    student = students.get(rollNumber);

                    if (student == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.print("Enter semester number: ");
                    int semester = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter marks separated by spaces: ");
                    String[] marksInput = scanner.nextLine().split(" ");
                    List<Integer> marks = new ArrayList<>();
                    for (String mark : marksInput) {
                        marks.add(Integer.parseInt(mark));
                    }

                    student.addMarks(semester, marks);
                    System.out.println("Marks added successfully.");
                    break;

                case 3:
                   
                    System.out.print("Enter student's roll number: ");
                    rollNumber = scanner.nextLine();
                    student = students.get(rollNumber);

                    if (student == null) {
                        System.out.println("Student not found.");
                    } else {
                        student.displayStudentDetails();
                    }
                    break;

                case 4:
      
                    loop= true;
                    System.out.println("Exiting the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
