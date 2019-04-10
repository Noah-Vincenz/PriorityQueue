import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;
/*
 * Create the Student and Priorities classes here.
 */
class Student {
    public int id;
    public String name;
    public double cgpa;
    
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    
    public int getID() {
        return this.id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public double getCGPA() {
        return this.cgpa;
    }
}

class Priorities {
    
    public List<Student> getStudents(List<String> events) {
        List<Student> listToReturn = new ArrayList<Student>();
        for(String s : events) {
            String[] sArr = s.split("\\s+");
            if (sArr[0].equals("ENTER")) {
                String name = sArr[1];
                double cgpa = Double.parseDouble(sArr[2]);
                int id = Integer.parseInt(sArr[3]);
                Student st = new Student(id, name, cgpa);
                listToReturn.add(st);
            } else { // scan.next().equals("SERVED")
                if (!listToReturn.isEmpty()) {
                    Collections.sort(listToReturn, new CGPAComparator());
                    /*
                    System.out.println(" ");
                    for (Student stu : listToReturn) {
                        System.out.print(stu.getCGPA() + ", " + stu.getName() + ", " + stu.getID());
                        System.out.print("; ");
                    }
                    System.out.println(" ");
                    */
                    listToReturn.remove(0);
                }
            }
        }
        return listToReturn;
    }
}

class CGPAComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        if (a.getCGPA() < b.getCGPA()) return 1;
        else if (a.getCGPA() > b.getCGPA()) return -1;
        else if (a.getCGPA() == b.getCGPA() && !a.getName().equals(b.getName())) {
            return a.getName().compareToIgnoreCase(b.getName());
        } else {
            return b.getID() - a.getID();
        }
    }
}

