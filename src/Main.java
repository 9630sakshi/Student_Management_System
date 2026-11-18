import java.net.Socket;
import java.util.Scanner;
import java.util.logging.SocketHandler;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static boolean addStudent(int[] ids, String[] names, int[] marks, int count, Scanner sc) {

        System.out.print("Enter Student ID: ");
        int newId = sc.nextInt();

        for (int i = 0; i < count; i++) {
            if (ids[i] == newId) {
                System.out.println("This Student ID already exists!");
                return false;
            }
        }

        ids[count] = newId;
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        names[count] = sc.nextLine();

        System.out.print("Enter Student Marks: ");
        marks[count] = sc.nextInt();

        System.out.println("Student Added Successfully!");
        return true;
    }

    static void displayStudent( int[] ids, String[] name, int[] marks, int count){
        for (int i =0; i<count;i++){
            System.out.println("Student id: " +ids[i]);
            System.out.println("Student name : "+ name[i]);
            System.out.println("Stuent marks: " + marks[i]);

        }
    }


    static void searchStudent(int[] ids, String[] name, int[] marks , int count , Scanner sc ){
        System.out.print("Enter Student id to Search : ");
        int searchId = sc.nextInt();

        boolean found = false;

        for (int i =0 ;i<count; i++){
            if (ids[i] == searchId){
                System.out.println("Student found! ");
                System.out.println("Id : " + ids[i]);
                System.out.println("name : "+ name[i]);
                System.out.println("marks : "+ marks[i]);
                found = true;
                break;
            }
        }

        if (!found){
            System.out.println("Student not found!");
        }
    }

    static  void updateStudent(int[] ids , String[] name , int[] marks, int count , Scanner sc){
        System.out.print("Enter student id to update : ");
         int updateId = sc.nextInt();

         for (int i =0;i<count;i++){
             if (ids[i] == updateId){
                 sc.nextLine();

                 System.out.print("Enter new name: ");
                 name[i] = sc.nextLine();

                 System.out.print("Enter new marks: ");
                 marks[i] = sc.nextInt();

                 System.out.println("Student Update Successfully.");
                 return;
             }

         }
        System.out.println("Student not found.");
    }







    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] studentIds = new int[5];
        String[] studentName = new String[5];
        int[] studentMarks = new int[5];


        int count = 0;
        int choice;

        do{
            System.out.println("/n========Student Managment Sysytem=======");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student");
            System.out.println("3. Search Student ");
            System.out.println("4. Update Student ");
            System.out.println("5. Exit");

            System.out.print("Enter your Choice : ");
            choice = sc.nextInt();

            switch (choice){

                case 1:
                    if (count < 5) {
                        if (addStudent(studentIds, studentName, studentMarks, count, sc)) {
                            count++;
                        }
                    } else {
                        System.out.println("Student limit reached.");
                    }
                    break;


                case 2:
                    displayStudent(studentIds, studentName , studentMarks, count);
                    break;

                case 3:
                    searchStudent(studentIds, studentName, studentMarks, count, sc);
                    break;

                case 4:
                    updateStudent(studentIds, studentName, studentMarks, count, sc);
                    break;

                case 5:
                    System.out.println("Thank you.");
                    break;
                default:
                    System.out.println("Invalid Choice.");
            }
        }
        while (choice !=5);
            sc.close();
        }

    }
