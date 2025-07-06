import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    ArrayList<Integer> grades = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    void addGrade(int grade) {
        grades.add(grade);
    }

    double getAverage() {
        if (grades.isEmpty()) return 0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.size();
    }

    int getHighest() {
        if (grades.isEmpty()) return 0;
        int max = grades.get(0);
        for (int g : grades) if (g > max) max = g;
        return max;
    }

    int getLowest() {
        if (grades.isEmpty()) return 0;
        int min = grades.get(0);
        for (int g : grades) if (g < min) min = g;
        return min;
    }
}

public class Gradetracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            scanner.nextLine(); // consume newline
            System.out.print("\nEnter student name: ");
            String name = scanner.nextLine();
            Student student = new Student(name);

            System.out.print("Enter number of grades: ");
            int numGrades = scanner.nextInt();

            for (int j = 0; j < numGrades; j++) {
                System.out.print("Enter grade #" + (j + 1) + ": ");
                int grade = scanner.nextInt();
                student.addGrade(grade);
            }

            students.add(student);
        }

        // Display report
        System.out.println("\n--- Summary Report ---");
        for (Student s : students) {
            System.out.println("Name: " + s.name);
            System.out.println("Grades: " + s.grades);
            System.out.printf("Average: %.2f\n", s.getAverage());
            System.out.println("Highest: " + s.getHighest());
            System.out.println("Lowest: " + s.getLowest());
            System.out.println("---------------------------");
        }

        scanner.close();
    }
}
