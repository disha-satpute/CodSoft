 /* Input: Take marks obtained (out of 100) in each subject.
    Calculate Total Marks: Sum up the marks obtained in all subjects.
    Calculate Average Percentage: Divide the total marks by the total number of subjects to get the average percentage.
    Grade Calculation: Assign grades based on the average percentage achieved.
    Display Results: Show the total marks, average percentage, and the corresponding grade to the user */ 

 import java.util.*;
 class StudentGradeCalculator {

    public int s1 , s2 ,s3 , s4 , s5,total;
    public float avg;

    //function for get input from user
    public void getMarks(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Student Grade Calculator ---");
        
        System.out.println("\nEnter marks of Physics : ");
        s1 = (sc.nextInt());

        System.out.println("Enter marks of Chemistry : ");
        s2 = (sc.nextInt());

        System.out.println("Enter marks of Maths : ");
        s3 = (sc.nextInt());

        System.out.println("Enter marks of English : ");
        s4 = (sc.nextInt());

        System.out.println("Enter marks of Hindi : ");
        s5 = (sc.nextInt());
    }
    public void totalMarks(){

        total = s1 + s2 + s3 + s4 + s5;
        System.out.println("Total Marks :"+total);
    }
    public void avgPercentage(){
        avg = (s1 + s2 + s3 + s4 + s5) / 5 ;
        System.out.println("Average Percentage :"+avg+"%");
    }
    public void gradeCalculation(){
               if(avg<100 && avg>=90){
                System.out.println("Grade = A1");
               }
               if(avg<90 && avg>=80){
                System.out.println("Grade = A2");
               }
               if(avg<80 && avg>=70){
                System.out.println("Grade = B1");
               }
               if(avg<70 && avg>=60){
                System.out.println("Grade = B2");
               }
               if(avg<60 && avg>=50){
                System.out.println("Grade = C1");
               }
               if(avg<50 && avg>=40){
                System.out.println("Grade = C2");
               }
               
    }
   
    public static void main(String args[]){
        StudentGradeCalculator sgc = new StudentGradeCalculator();
       
        sgc.getMarks();
        sgc.totalMarks();
        sgc.avgPercentage();
        sgc.gradeCalculation();
    }
 }