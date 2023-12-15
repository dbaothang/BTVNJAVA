package week8;

import java.util.*;

class Priorities {
    List<Student> getStudents(List<String> events) {
        PriorityQueue<Student> studentQueue = new PriorityQueue<>(new StudentComparator());
        List<Student> result = new ArrayList<>();

        for (String event : events) {
            if (event.equals("SERVED")) {
                if (!studentQueue.isEmpty()) {
                    studentQueue.poll();
                }
            } else {
                String[] parts = event.split(" ");
                studentQueue.offer(new Student(parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3])));
            }
        }

        while (!studentQueue.isEmpty()) {
            result.add(studentQueue.poll());
        }

        return result;
    }
}

class Student {
    private int id;
    private String name;
    private double gpa;

    public Student(String name, double gpa, int id) {
        this.gpa = gpa;
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getGpa() {
        return gpa;
    }
}

class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student x, Student y) {
        int cgpa = Double.compare(y.getGpa(), x.getGpa());
        if (cgpa != 0) {
            return cgpa;
        }

        int cname = x.getName().compareTo(y.getName());
        if (cname != 0) {
            return cname;
        }

        return Integer.compare(x.getId(), y.getId());
    }
}

public class JavaPriorityQueue {
    private final static Scanner scanner = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scanner.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            events.add(scanner.nextLine());
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            students.forEach(student -> System.out.println(student.getName()));
        }
    }
}
