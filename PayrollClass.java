package ch7pc2;
import java.util.Scanner;

/**
 *Michael Haugh
 *Project CH7PC2
 *Programming III - AP CS
 *12-19-18
 */

public class PayrollClass {
    
        //Creates the four arrays
        final static int[] EMPLOYEE_ID = {5658845, 4520125, 7895122, 8777541, 
        8451277, 1302850, 7580489}; 
        static int[] hours = new int[7];
        static double[] payRate = new double[7];
        static double[] wages = new double[7];
            
    public static void main(String[] args) {
        
        //Creates the Scanner object
        Scanner kb = new Scanner(System.in);   
    
        /*
        /FOR LOOP RUNS THROUGH EACH POSITION IN THE ARRAY AND RETURNS ID
        /NUMBER AND GROSS PAY
        */
        for(int x = 0; x < EMPLOYEE_ID.length; x++){
            
            //Tells the user to input the hours worked
            System.out.println("Enter the hours worked by employee number " 
                + EMPLOYEE_ID[x]);    

            //Declares the hoursWorked variable
            int hoursWorked;
    
            //Declares the set variable
            boolean set;
            
            //Inputs the hours worked from the user
            do{
                hoursWorked = kb.nextInt();
                set = setHours(hoursWorked, x);
            }while(set == false);
        
            //Tells the user to input the pay rate
            System.out.println("Enter the hourly pay rate for employee number " 
                + EMPLOYEE_ID[x]);    
        
            //Declares the hourlyPay variable
            double hourlyPay;
            
            //Inputs the hourly pay from the user
            do{
                hourlyPay = kb.nextDouble();
                set = setPayRate(hourlyPay, x);
            }while(set == false);
            
            setWages(x);
        }
        
        
        System.out.println("PAYROLL DATA");
        //For loop prints out the employee ID and gross pay for all 7 employees
        for(int x = 0; x < EMPLOYEE_ID.length; x++){
            System.out.println("Employee Identification: " + EMPLOYEE_ID[x]);
            System.out.println("Gross Pay: " + wages[x]);
        }
    
    }
    
    public static boolean setHours(int hoursWorked, int index){
        //Validates the hours worked entered by ensuring it is at least 0 hrs
        if(hoursWorked < 0){
            System.out.println("This number is not valid.  Please enter a valid"
                    + " number of hours worked. ");
            return false; 
        }
        //Places the hoursWorked input into the hours array
        hours[index] = hoursWorked;
        return true; 
    }
    
    
    public static boolean setPayRate(double hourlyPay, int index){
        //Validates the hourly pay entered by ensuring it is greater than $6/hr
        if(hourlyPay < 6.0){
            System.out.println("This number is not valid.  Please enter a valid"
                    + " hourly pay. ");
            return false;
        }
        //Places the hourly pay input into the payRate array
        payRate[index] = hourlyPay;
        return true;
    }
    
    //Mutator method creates the wages by multiplying hours and payRate
    public static void setWages(int index){
        //Wages = hours * payRate
        wages[index] = getHours(index) * getPayRate(index);
    }    
    
    //PayRate accessor method
    public static double getPayRate(int index){
        return payRate[index];
    }
    
    //Hours accessor method
    public static int getHours(int index){
        return hours[index];
    }
    
    //Wages accessor method
    public static double getWages(int index){
        return wages[index];
    }

        
}
