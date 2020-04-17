import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Scanner;
interface money{
    void calculateORget();
}
abstract class Details{
    public String userName,goalName;
    public int no_FamilyMembers=0;
    public int no_MemberEarns=0;
    public int no_other_source,savingMonths;
    public double[] salary;
    public double[] salary_monthly;
    public double sum_salaryM,goalPrice;
    public double housing,transportation,insurance,food,loans,entertainment,taxes,totalExpenses;

    abstract void getInfo();
    
}

class Menu extends Details {
    public static Scanner scan = new Scanner(System.in);
    

    
    public void getInfo() {
        boolean choice = true;
        while(choice){
            System.out.print("# Please enter your name : ");
            userName = scan.nextLine();
            System.out.print("# How many family members are there in your house? : ");
            no_FamilyMembers=scan.nextInt();
            System.out.print("# How many members of your family members earn? : ");
            no_MemberEarns=scan.nextInt();
            salary_input();
            System.out.print("# If all information you entered is true then enter 'y' if not then enter 'n' : ");
            char choice_yn = scan.next().charAt(0);
            
            if(choice_yn=='y'){

                choice = false;
                System.out.println("Details updated sucessfully !!");
            }
        }                
    }
    void salary_input(){
        double salary[] = new double[no_MemberEarns];
        double salary_monthly[] = new double[no_MemberEarns];
        System.out.println("# So "+userName+" as you have "+no_MemberEarns+" out of "+no_FamilyMembers+" members earning at your home please mention there annual salaries(in lakhs) : ");
        for(int i=0;i<no_MemberEarns;i++){
            salary[i]=scan.nextInt();
            salary_monthly[i]=(salary[i]/12)*100000;
            sum_salaryM=salary_monthly[i]+sum_salaryM;
        }        
    }
    
        
}

class Salary extends Menu implements money{
    public static Scanner scan = new Scanner(System.in);
    public void calculateORget() {        //get
        boolean choice = true;
        while(choice){
            
            System.out.print("# Housing :");
            housing=scan.nextDouble();
            System.out.print("# Transportation : ");
            transportation=scan.nextDouble();
            System.out.print("# Insurance : ");
            insurance=scan.nextDouble();
            System.out.print("# Foods : ");
            food=scan.nextDouble();
            System.out.print("# Loans : ");
            loans=scan.nextDouble();
            System.out.print("# Entertainment : ");
            entertainment=scan.nextDouble();
            System.out.print("# Taxes : ");
            taxes=scan.nextDouble();
            System.out.print("# If all information you entered is true then enter 'y' if not then enter 'n' : ");
            char choice_yn = scan.next().charAt(0);
            
            if(choice_yn=='y'){

                choice = false;
                System.out.println("Details updated sucessfully !!");
            }
            totalExpenses=housing+transportation+insurance+food+loans+entertainment+taxes;
        }         
        scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    }
    
    void setGoals(){
        
        System.out.print("Enter the name of product you want to buy : ");
        
        goalName= scan.nextLine();
       
        System.out.print("Enter Price of "+goalName+" : ");
        goalPrice=scan.nextDouble();
        

    }
    void saveGoals(){
        System.out.println("System has generated some values as per your details :\nYour monthly total income is : "+sum_salaryM+" rupees\nYour monthly expenditure is : "+totalExpenses+" rupees");
        savingMonths =(int)((goalPrice/(sum_salaryM-totalExpenses))+1);
        System.out.println("To achieve your goal you need to save your "+savingMonths+" months savings");
    }
    void savings(){
        System.out.println("NOTE : if you save money exactly same amount of money i.e "+(sum_salaryM-totalExpenses)+" rupees\nyou will save the below amount in comming months");
        System.out.println("|^^^^^^^^^^^^^^^^SAVINGS TABLE^^^^^^^^^^^^^^^^^|");
        System.out.println("|``````````````````````````````````````````````|");
        System.out.println("| One Month : "+((sum_salaryM-totalExpenses))+" rupees");
        System.out.println("| Three Months : "+((sum_salaryM-totalExpenses)*3)+" rupees");
        System.out.println("| Six Months : "+((sum_salaryM-totalExpenses)*6)+" rupees");
        System.out.println("| One Year : "+((sum_salaryM-totalExpenses)*12)+" rupees");
        System.out.println("| Three Years : "+((sum_salaryM-totalExpenses)*36)+" rupees");
        System.out.println("| Five Years : "+((sum_salaryM-totalExpenses)*60)+" rupees");
    }
    
}



class HomeBudget {
        public static void main(String[] args){
            int countWaste=1;
            Salary obj1 = new Salary();
            Scanner scan = new Scanner(System.in);
            while(true){
                justPrint();
                System.out.println("| 1. Update User Personal Details.             |");
                System.out.println("| 2. Add Monthly Expenses.                     |");
                System.out.println("| 3. Calculate Savings.                        |");
                System.out.println("| 4. Set Goals.                                |");
                System.out.println("| 5. Get Notification.                         |");
                System.out.println("| 6. Exit.                                     |");
                System.out.println("************************************************");
                System.out.println("\t\tEnter Your Choice : ");
                int choiceMenu =scan.nextInt();
                switch(choiceMenu){
                    case 1:{
                        justPrint();
                        System.out.println();
                        System.out.println("\t#|||| UPDATE DETAILS ||||#");
                        obj1.getInfo();
                        System.out.print("Enter Any Integer to Continue .....");
                        countWaste=scan.nextInt();
                        break;
                    } 
                    case 2:{
                        justPrint();
                        System.out.println();
                        System.out.println("#|||| PLEASE ADD YOUR MONTHLY EXPENSES ||||#");
                        obj1.calculateORget();//get
                        System.out.print("Enter Any Integer to Continue .....");
                        countWaste=scan.nextInt();
                        break;
                    } 
                    case 3:{
                        justPrint();
                        System.out.println();
                        System.out.println("\t#|||| CALCULATE SAVINGS ||||#");
                        obj1.savings();
                        System.out.print("Enter Any Integer to Continue .....");
                        countWaste=scan.nextInt();
                        break;
                    } 
                    case 4:{
                        justPrint();
                        System.out.println();
                        System.out.println("\t#|||| SET GOALS ||||#");
                        obj1.setGoals();
                        obj1.saveGoals();
                        System.out.print("Enter Any Integer to Continue .....");
                        countWaste=scan.nextInt();
                        break;
                    } 
                    case 5:{
                        justPrint();
                        System.out.println();
                        System.out.println("\t#|||| GET NOTIFICATION ||||#");
                        
                        try{
                            //File file = new File("append.txt");
                            OutputStream os = new FileOutputStream(new File("miniStatement.txt"),true);                         
                            os.write("@".getBytes());   
                            os.write(("\n###^^^^^^PERSONAL DETAILS^^^^^^###  \nNAME : "+obj1.userName+"\nNO.OF FAMILY MEMBERS : "+obj1.no_FamilyMembers+"\nNO. OF FAMILY MEMBERS EARN : "+obj1.no_MemberEarns).getBytes());
                            os.write(("\n###^^^^^^MONTHLY EXPENSES^^^^^^###  \nHOUSING : "+obj1.housing+" rupees\nTRANSPORATION : "+obj1.transportation+" rupees\nINSURANCE : "+obj1.insurance+" rupees\nFOOD : "+obj1.food+" rupees\nLOANS : "+obj1.loans+" rupees\nENTERTAINMENT : "+obj1.entertainment+" rupees\nTAXES : "+obj1.taxes+" rupees").getBytes());
                            os.write(("\n###^^^^^^^^^^SAVINGS^^^^^^^^^^^###  \nONE MONTH : "+(obj1.sum_salaryM-obj1.totalExpenses)+" rupees\nTHREE MONTHS : "+((obj1.sum_salaryM-obj1.totalExpenses)*3)+" rupees\nSIX MONTHS : "+((obj1.sum_salaryM-obj1.totalExpenses)*6)+" rupees\nONE YEAR : "+((obj1.sum_salaryM-obj1.totalExpenses)*12)+" rupees\nTHREE YEARS : "+((obj1.sum_salaryM-obj1.totalExpenses)*36)+" rupees\nFIVE MONTHS : "+((obj1.sum_salaryM-obj1.totalExpenses)*3)+" rupees").getBytes());
                            os.write(("\n###^^^^^^^^^^^GOALS^^^^^^^^^^^^###  \nGOAL TO BUY : "+obj1.goalName+"\nGOAL COST : "+obj1.goalPrice+" rupees\nNO. OF MONTHS YOU NEED TO SAVE : "+obj1.savingMonths).getBytes());
                            os.write("\n\n\tTHANKS FOR USING HOME BUDGET MANAGEMENT SYSTEM !!!!\n\n\n".getBytes()); 
                        }catch(IOException e){
                            e.printStackTrace();
                
                        }
                        System.out.println("ALL YOUR DETAILS ARE SAVED IN THE FILE AND EXPORTED AS miniStatement\nPLEASE CHECK YOUR DIRECTORY");
                        System.out.print("Enter Any Integer to Continue .....");
                        countWaste=scan.nextInt();
                        break;
                    } 
                    case 6: System.out.println("Thanks for using Home Budget Management System !!");
                    System.exit(0);
                    break;
                    default: System.out.println("Incorrect input!!! Please re-enter choice from our menu");
                    }
                
            }
            
    }

    private static void justPrint() {
                System.out.println("************************************************");
                System.out.println("| WELCOME TO THE HOME BUDGET MANAGEMENT SYSTEM |");
                System.out.println("************************************************");
    }
}

