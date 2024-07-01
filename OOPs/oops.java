

public class oops {
    public static void main(String[] args) {
        
    }
}

    class Student{
        int roll;
        String name;
        float cgpa;
        int marks[]=new int[3];

        Student(){
            System.out.println("Constructor is called.....");
        }

        Student(int roll, String name, float cgpa){
            this.roll=roll;
            this.name=name;
            this.cgpa=cgpa;
        }

        Student(Student s1){
            this.roll=s1.roll;
            this.name=s1.name;
            this.cgpa=s1.cgpa;
            //SHALLOW COPY-            
            this.marks=s1.marks;
            //DEEP COPY-
            // this.marks[0]=s1.marks[0];
            // this.marks[1]=s1.marks[1];
            // this.marks[2]=s1.marks[2];
        }
    }

