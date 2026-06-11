package lesson_6.task_1;

import java.util.ArrayList;
import java.util.Set;

public class Student {
    protected String name;
    protected String surname;
    protected String group;
    protected int course;
    protected int gradeBiology;
    protected int gradeChemistry;
    protected int gradeMath;
    protected int gradeRusLang;

    public Student(String name, String surname, String group, int course, int gradeBiology, int gradeChemistry, int gradeMath, int gradeRusLang) {
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.course = course;
        this.gradeBiology = gradeBiology;
        this.gradeChemistry = gradeChemistry;
        this.gradeMath = gradeMath;
        this.gradeRusLang = gradeRusLang;
    }

    public static void deleteStudent(ArrayList<Student> students) {
        ArrayList<Student> defectivesStudents = new ArrayList<>();
        for (Student man : students) {
            double gradeAverage = (man.gradeBiology + man.gradeChemistry + man.gradeMath + man.gradeRusLang) / 4.0;
            if(gradeAverage < 3) {
                defectivesStudents.add(man);
            }
        }
       students.removeAll(defectivesStudents);
    }

    public static void upCourseStudent(ArrayList<Student> students) {
        for (Student man : students) {
            if(man.course < 5) {
                man.course = man.course + 1;
            }
        }
    }

    public static void printStudents(Set<Student> setStudents, int course) {
        int index = 0;
        System.out.println("Студенты на " + course + " курсе:");
        for (Student man : setStudents) {
            if (man.course == course) {
                index++;
                System.out.println(index + ". " + man.name + " " + man.surname);
            }
        }
    }
}
