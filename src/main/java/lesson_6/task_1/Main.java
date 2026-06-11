package lesson_6.task_1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Евгений", "Малинов", "БХ-26-01", 2, 5, 5, 3, 4);
        Student student2 = new Student("Иван", "Горшков", "БХ-26-01", 2, 5, 5, 3, 3);
        Student student3 = new Student("Ольга", "Воронова", "БХ-26-02", 2, 5, 5, 5, 5);
        Student student4 = new Student("Александр", "Гуркович", "БХ-26-02", 2, 3, 2, 2, 2);
        Student student5 = new Student("Василий", "Теркин", "БХ-26-03", 2, 2, 2, 2, 1);
        Student student6 = new Student("Валерия", "Моисеева", "БХ-26-03", 2, 1, 2, 3, 4);

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);

        System.out.println("Задание 1");
        Student.deleteStudent(students);
        Student.upCourseStudent(students);

        Set<Student> setStudents = new HashSet<>(students);
        Student.printStudents(setStudents, 3);
    }
}
