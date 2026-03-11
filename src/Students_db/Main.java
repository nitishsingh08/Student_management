package Students_db;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StudentsDAO dao = new StudentsDAO();
        while(true){
            System.out.println("\n========== STUDENT MANAGEMENT SYSTEM ==========");
            System.out.println("1️⃣ Add Student");
            System.out.println("2️⃣ Search Student");
            System.out.println("3️⃣ Show All Students");
            System.out.println("4️⃣ Update Marks");
            System.out.println("5️⃣ Delete Student");
            System.out.println("6️⃣ Exit");
            System.out.println("===============================================");

            System.out.print("Enter Choice: ");

            int ch = sc.nextInt();
            switch(ch){

                case 1:

                    System.out.print("Roll No: ");
                    int r=sc.nextInt();

                    System.out.print("Name: ");
                    String n=sc.next();

                    System.out.print("Age: ");
                    int a=sc.nextInt();

                    System.out.print("Course: ");
                    String c=sc.next();

                    System.out.print("Maths: ");
                    int m=sc.nextInt();

                    System.out.print("Chemistry: ");
                    int chm=sc.nextInt();

                    System.out.print("Physics: ");
                    int p=sc.nextInt();

                    Students s=new Students(r,n,a,c,m,chm,p);

                    dao.addStudents(s);
                    break;

                case 2:

                    System.out.print("Enter Roll No: ");
                    dao.searchStudent(sc.nextInt());
                    break;

                case 3:

                    dao.showAllStudents();
                    break;

                case 4:

                    System.out.print("Roll No: ");
                    int roll=sc.nextInt();

                    System.out.print("New Maths: ");
                    int nm=sc.nextInt();

                    System.out.print("New Chemistry: ");
                    int nc=sc.nextInt();

                    System.out.print("New Physics: ");
                    int np=sc.nextInt();

                    dao.updateMarks(roll,nm,nc,np);
                    break;

                case 5:

                    System.out.print("Enter Roll No: ");
                    dao.deleteStudent(sc.nextInt());
                    break;

                case 6:
                    System.exit(0);
            }
        }
        }
    }

