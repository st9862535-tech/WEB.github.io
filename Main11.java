package practika;
import java.util.*;

public class Main11 {


    static class Student implements Comparable<Student> {
        private final String id; // Final для змінної
        private String name;
        private double averageGrade;

        public Student(String id, String name, double averageGrade) {
            this.id = id;
            this.name = name;
            this.averageGrade = averageGrade;
        }

        public String getId() { return id; }
        public String getName() { return name; }
        public double getAverageGrade() { return averageGrade; }

        @Override
        public int compareTo(Student other) {
            return Double.compare(other.averageGrade, this.averageGrade);     //  від більшого до меншого
        }

        @Override
        public String toString() {
            return String.format("Student[ID: %-5s | Name: %-8s | Grade: %.2f]", id, name, averageGrade);
        }
    }

    // 2. cортировка за іменем
    static class NameComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getName().compareTo(s2.getName());
        }
    }

    // 3. сортировка за id
    static class IdComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s1.getId().compareTo(s2.getId());
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("S105", "Олена", 4.8));
        students.add(new Student("S101", "Андрій", 3.9));
        students.add(new Student("S103", "Іван", 4.5));
        students.add(new Student("S102", "Марія", 5.0));
        students.add(new Student("S104", "Денис", 4.2));

        System.out.println("--- Без сортування ---");
        students.forEach(System.out::println);

        System.out.println("\n--- Сортування Comparable (за балом) ---");
        Collections.sort(students);
        students.forEach(System.out::println);

        System.out.println("\n--- Сортування за name (NameComparator) ---");
        students.sort(new NameComparator());
        students.forEach(System.out::println);

        System.out.println("\n--- Сортування за id (IdComparator) ---");
        students.sort(new IdComparator());
        students.forEach(System.out::println);
    }
}