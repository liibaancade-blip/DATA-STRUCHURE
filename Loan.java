import java.util.Date;
// Exercise 2.0 - Loan
class Loan {

    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;
    private Date loanDate;

    // NO_ARGUMENTS CONSTPTOR
    public Loan() {
        annualInterestRate = 2.5;
        numberOfYears = 1;
        loanAmount = 1000;
        loanDate = new Date();
    }
    // BARA METIRAAS ARGUMENT
    public Loan(double annualInterestRate, int numberOfYears,
                double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        this.loanDate = new Date();
    }
    // GETTERS
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    //GETTERS
    public int getNumberOfYears() {
        return numberOfYears;
    }
    // GETTERS
    public double getLoanAmount() {
        return loanAmount;
    }
    // GETTERS
    public Date getLoanDate() {
        return loanDate;
    }
    // SETTERS
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    // SETTERS
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    // SETTERS
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    //
    public double getMonthlyPayment() {

        double monthlyRate = annualInterestRate / 1200;
        int totalMonths = numberOfYears * 12;

        return loanAmount * monthlyRate /
                (1 - 1 / Math.pow(1 + monthlyRate, totalMonths));
    }

    // Calculate the total amount paid
    public double getTotalPayment() {
        return getMonthlyPayment() * numberOfYears * 12;
    }
}


// =====================================================
// Exercise 2.1 - BMI
// =====================================================

class BMI {

    private String name;
    private int age;
    private double weight;
    private double height;

    // Constructor with all information
    public BMI(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    // Constructor with default age of 20
    public BMI(String name, double weight, double height) {
        this.name = name;
        this.age = 20;
        this.weight = weight;
        this.height = height;
    }

    // Calculate BMI
    public double getBMI() {
        return (weight * 703) / (height * height);
    }

    // Determine BMI category
    public String getStatus() {

        double value = getBMI();

        if (value < 18.5) {
            return "Underweight";
        }
        else if (value < 25.0) {
            return "Normal";
        }
        else if (value < 30.0) {
            return "Overweight";
        }
        else {
            return "Obese";
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
}


// =====================================================
// Exercise 2.2 - Course
// =====================================================

class Course {

    private String courseName;
    private String[] students;
    private int numberOfStudents;

    // Create a course with initial student capacity
    public Course(String courseName) {
        this.courseName = courseName;
        students = new String[100];
        numberOfStudents = 0;
    }

    public String getCourseName() {
        return courseName;
    }

    // Add a student
    public void addStudent(String student) {

        // Increase the array size when it is full
        if (numberOfStudents == students.length) {

            String[] biggerList = new String[students.length * 2];

            for (int i = 0; i < students.length; i++) {
                biggerList[i] = students[i];
            }

            students = biggerList;
        }

        students[numberOfStudents] = student;
        numberOfStudents++;
    }

    // Remove a student from the course
    public void dropStudent(String student) {

        for (int i = 0; i < numberOfStudents; i++) {

            if (students[i].equals(student)) {

                // Move the students after the removed one
                // one position to the left
                for (int j = i; j < numberOfStudents - 1; j++) {
                    students[j] = students[j + 1];
                }

                students[numberOfStudents - 1] = null;
                numberOfStudents--;

                return;
            }
        }
    }

    public String[] getStudents() {
        return students;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }
}


// =====================================================
// Main Program
// =====================================================

class Test {


    public static void main(String[] args) {

        // -------------------------------------------------
        // Testing Loan
        // -------------------------------------------------

        System.out.println("========== LOAN INFORMATION ==========");

        Loan myLoan = new Loan(5.0, 5, 50000);

        System.out.println("Interest Rate: "
                + myLoan.getAnnualInterestRate());

        System.out.println("Years: "
                + myLoan.getNumberOfYears());

        System.out.println("Loan Amount: "
                + myLoan.getLoanAmount());

        System.out.println("Loan Created: "
                + myLoan.getLoanDate());

        System.out.println("Monthly Payment: "
                + myLoan.getMonthlyPayment());

        System.out.println("Total Payment: "
                + myLoan.getTotalPayment());


        // -------------------------------------------------
        // Testing BMI
        // -------------------------------------------------

        System.out.println("\n========== BMI INFORMATION ==========");

        BMI myBMI = new BMI("Liibaan", 24, 150, 68);

        System.out.println("Name: " + myBMI.getName());
        System.out.println("Age: " + myBMI.getAge());
        System.out.println("Weight: " + myBMI.getWeight());
        System.out.println("Height: " + myBMI.getHeight());
        System.out.println("BMI Value: " + myBMI.getBMI());
        System.out.println("BMI Status: " + myBMI.getStatus());


        // -------------------------------------------------
        // Testing Course
        // -------------------------------------------------

        System.out.println("\n========== COURSE INFORMATION ==========");

        Course javaCourse = new Course("Java Programming");

        javaCourse.addStudent("Liibaan");
        javaCourse.addStudent("Ahmed");
        javaCourse.addStudent("Abdi");

        System.out.println("Course: "
                + javaCourse.getCourseName());

        System.out.println("Students Enrolled: "
                + javaCourse.getNumberOfStudents());

        System.out.println("\nStudent List:");

        for (int i = 0; i < javaCourse.getNumberOfStudents(); i++) {
            System.out.println("- " + javaCourse.getStudents()[i]);
        }


        // Remove one student
        javaCourse.dropStudent("Ahmed");

        System.out.println("\nAfter Removing Ahmed:");

        System.out.println("Students Enrolled: "
                + javaCourse.getNumberOfStudents());

        for (int i = 0; i < javaCourse.getNumberOfStudents(); i++) {
            System.out.println("- " + javaCourse.getStudents()[i]);
        }
    }
}