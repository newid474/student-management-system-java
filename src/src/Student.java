public class Student {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String department;
    private int year;
    private double marks;

    public Student(int id, String name, String email, String phone,
                   String department, int year, double marks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.year = year;
        this.marks = marks;
    }

    public Student(String name, String email, String phone,
                   String department, int year, double marks) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.department = department;
        this.year = year;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDepartment() {
        return department;
    }

    public int getYear() {
        return year;
    }

    public double getMarks() {
        return marks;
    }

    public String getGrade() {

        if (marks >= 90)
            return "A+";
        else if (marks >= 80)
            return "A";
        else if (marks >= 70)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 50)
            return "D";
        else
            return "F";
    }
}
