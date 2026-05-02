
import java.util.*;
public class Main{
  public static void main(String[]args){
    Scanner sc= new Scanner(System.in);
    StudentManager sm=new StudentManager();
    try{
      sm.loadFromFile();   
     }
     catch(Exception e){
        System.out.println("Error loading file");
     }

    while(true){
        System.out.println("\n 1.Add Student");
        System.out.println("\n 2.Display Student");
        System.out.println("\n 3. Search Student");  
        System.out.println("\n 4. Delete Student");
        System.out.println("\n 5. Sort by Marks");
        System.out.println("\n 6. Sort by Name");
        System.out.println("\n 7. update marks");
        System.out.println("\n 8.Exit");
        int choice=sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Enter ID: ");
                int id=sc.nextInt();
                sc.nextLine();
                System.out.println("Enter Name: ");
                String name=sc.nextLine();
                System.out.println("Enter Marks: ");
                double marks=sc.nextDouble();

                sm.addStudent(new Student(id,name,marks));
                break;
                case 2:
                    sm.displayAll();
                    break;
                case 3:
                    System.out.println("Enter ID: ");
                    sm.searchStudent(sc.nextInt());
                    break;
                case 4:
                    System.out.println("Enter ID: ");
                    sm.deleteStudent(sc.nextInt());
                    break;
                case 5:
                    sm.sortbymarks();
                    break;
                case 6:
                    sm.sortbyname();
                    break;
                case 7:
                    System.out.println("Enter ID: ");
                    int uid=sc.nextInt();
                    System.out.println("Enter new marks: ");
                    double newMarks =sc.nextDouble();
                    sm.updateMarks(uid,newMarks);
                    break;
                case 8:
                     try{
                        sm.saveToFile();   
                    }
                    catch(Exception e){
                        System.out.println("Error saving file");
                    }
               System.exit(0);

        }

    }
  }
}