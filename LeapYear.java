 public class LeapYear {
    public static boolean isLeapYear(int year){
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0 ) ;
    }
    public static void main(String[] args){
         if(isLeapYear(2000)) {
             System.out.print("is leap year");
         }else{
             System.out.print("is not leap year");
         }    
   
    }
    
 }