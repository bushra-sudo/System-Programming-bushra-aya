package part2;
// בושרא אבו סעד 325998870
// נבארי אייה 215798356
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GradesReport {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter students file name (e.g. CS.txt): ");
        String studentsFile = scanner.nextLine().trim();
        System.out.print("Enter grades file name (e.g. hedva.txt): ");
        String gradesFile = scanner.nextLine().trim();
        scanner.close();

        try (BufferedReader students = new BufferedReader(new FileReader(studentsFile));
             BufferedReader grades = new BufferedReader(new FileReader(gradesFile));
             BufferedWriter report = new BufferedWriter(new FileWriter("report.txt"))) {

            // Only one line from each file is held in memory at any time
            String[] student = readLine(students); // {first, last, id}
            String[] grade = readLine(grades);     // {id, grade1, grade2}

            // Both files are sorted by ID, so a single pass over each (merge) is enough
            while (student != null && grade != null) {
                long studentId = Long.parseLong(student[2]);
                long gradeId = Long.parseLong(grade[0]);

                if (studentId == gradeId) {
                    double avg = (Integer.parseInt(grade[1]) + Integer.parseInt(grade[2])) / 2.0;
                    report.write(student[2] + " " + student[0] + " " + student[1] + " " + format(avg));
                    report.newLine();
                    student = readLine(students);
                    grade = readLine(grades);
                } else if (studentId < gradeId) {
                    // student in the department who is not registered to the course
                    student = readLine(students);
                } else {
                    // student from another department
                    grade = readLine(grades);
                }
            }
            System.out.println("report.txt was created successfully.");

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid file format: " + e.getMessage());
        }
    }

    // Reads the next non-empty line and splits it by whitespace; returns null at end of file
    private static String[] readLine(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        while (line != null && line.trim().isEmpty()) {
            line = reader.readLine();
        }
        if (line == null) {
            return null;
        }
        return line.trim().split("\\s+");
    }

    // Prints 80 instead of 80.0, but keeps 87.5 as is
    private static String format(double avg) {
        if (avg == Math.floor(avg)) {
            return String.valueOf((int) avg);
        }
        return String.valueOf(avg);
}
}   
 