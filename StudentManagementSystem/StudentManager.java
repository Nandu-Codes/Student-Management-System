import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.lang.classfile.BufWriter;
import java.util.*;
import java.io.*;
public class StudentManager {

    ArrayList<Student> students=new ArrayList<>();
    void addStudent(Student s){
        students.add(s);
    }
    void searchStudent(int id){
        for(Student s:students){
            if (s.id==id){
                System.out.println("Student found");
                s.display();
                return;
            }
            }
               System.out.println("Student not found");
        }
        void deleteStudent(int id){
            boolean removed =students.removeIf(s->s.id==id);
            if (removed){
                System.out.println("Student deleted");
            }
            else{
                 System.out.println("Student not found");
            }
                    
                }
        void sortbymarks(){
            students.sort((a,b)->Double.compare(b.marks,a.marks));
            System.out.println("Students sorted by marks(highest first)");
        }
        void sortbyname(){
            students.sort((a,b)->a.name.compareTo(b.name));
             System.out.println("Students sorted by name");
        }
    void displayAll(){
        for(Student s : students){
            s.display();
        }
    }
  void saveToFile() throws Exception{
    BufferedWriter writer=new BufferedWriter(new FileWriter("Students.txt"));
    for(Student s : students){
        writer.write(s.id+","+s.name+","+s.marks);
        writer.newLine();
    }
    writer.close();
    System.out.println("saving file");
  } 
void loadFromFile() throws Exception{
     File file=new File("Students.txt");
     if (!file.exists())return;
      BufferedReader reader=new BufferedReader(new FileReader(file));
      String line;
      while((line=reader.readLine())!=null){
        String[]data=line.split(",");
        int id=Integer.parseInt(data[0]);
        String name=data[1];
        double marks=Double.parseDouble(data[2]);
        students.add(new Student(id,name,marks));
      }
        reader.close();
    }
    void updateMarks(int id,double newMarks){
        for(Student s:students){
            if (s.id==id){
              s.marks = newMarks;
              System.out.println("Marks updated succesfully");
              return;
            } 
        }
         System.out.println("Student not found");       
    }
    
}