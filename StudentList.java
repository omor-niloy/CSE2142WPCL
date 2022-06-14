import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
    public static void main(String[] args) {
//      Check arguments
        if(args[0].equals("a")) {
            System.out.println("Loading data ...");         
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
                String studentNames = bufferedReader.readLine();
                String names[] = studentNames.split(", ");  
                for(String name : names) { 
                    System.out.println(name); 
                }
            } catch (Exception e){

            } 
            System.out.println("Data Loaded.");
        } else if(args[0].equals("r")) {
            System.out.println("Loading data ...");         
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
                String studentNames = bufferedReader.readLine();
                String names[] = studentNames.split(", ");  
                Random ran = new Random();
                int randomIndex = ran.nextInt(names.length);
                System.out.println(names[randomIndex]);
            } catch (Exception e){

            } 
            System.out.println("Data Loaded.");         
        } else if(args[0].contains("+")) {
            System.out.println("Loading data ...");         
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
                String studentNames = bufferedReader.readLine();
                bufferedReader.close();

                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("students.txt", false));
                bufferedWriter.flush();
                String newName = args[0].substring(1);
                studentNames = studentNames + ", " + newName;
                Date d = new Date();
                String df = "dd/mm/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(df);
                String fd= dateFormat.format(d);
                bufferedWriter.write(studentNames + "\nList last updated on " + fd);
                bufferedWriter.close();
            } catch (Exception e){

            }       
            System.out.println("Data Loaded."); 
        } else if(args[0].contains("?")) {
            System.out.println("Loading data ...");         
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
                String studentNames = bufferedReader.readLine();
                String names[] = studentNames.split(",");   
                boolean done = false;
                String name = args[0].substring(1);
                for(int idx = 0; idx < names.length && (!done); idx++) {
                    if(names[idx].equals(name)) {
                        System.out.println("We found it!");
                        done=true;
                    }
                }
                if (!done) {
                    System.out.println("Not found");
                }
            } catch (Exception e){

            } 
            System.out.println("Data Loaded.");             
        } else if(args[0].equals("c")) {
            System.out.println("Loading data ...");         
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt"))); 
                String studentNames = bufferedReader.readLine();
                char arr[] = studentNames.toCharArray();            
                boolean in_word = false;
                int count = 0;
                for(char ch : arr) {
                    if(ch == ' ' && in_word) {
                        count++;
                        in_word = false;            
                    } else {
                        in_word = true;
                    }
                }
                if (in_word) {
                    count++;
                }
                System.out.println(count + " word(s) found");
            } catch (Exception e){
 
            } 
            System.out.println("Data Loaded.");             
        }
    }
}
