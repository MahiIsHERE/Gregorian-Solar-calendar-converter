import java.util.Scanner;

public class SolartoGeorgian{

    public static void main(String[] args) {
        
        Scanner input = new Scanner (System.in);
        
        String a;
        a = input.nextLine();
        
        int year = Integer.parseInt(a.substring(0 , 4));
        int month = Integer.parseInt(a.substring(5 , 7));
        int day = Integer.parseInt(a.substring(8 , 10));
        // Miladi
        // (or the old substring method)
        
        int Miladi[] = {31 , 28 , 31 , 30 , 31 , 30 , 31 , 31 , 30 , 31 , 30 , 31};
        // MiladiMonth
        
        int yyyy=0 , dd=0 , mm=0;
        // Shamsi
        
        boolean leap = false;
        
        yyyy = (year + 621);
        // to check shamsi year
        
        int DayDiff = 79;
        
        int DayCount = ((6*31)+((month-7)*30)+day);
        
        
        if ((yyyy%4==0 && yyyy%100!=0) || (yyyy%400==0 && yyyy%100==0)) { // is leap
            leap = true;
            Miladi[1]=29;
        }        

        if (month<=6){
           dd = (((month-1)*31)+day+DayDiff) ; 
        }
        
        if (month>6){
            
            if (DayCount<287) { // 287 ---> January 1
                dd = (DayCount+DayDiff);
            }
           
            else {
                dd = (DayCount+DayDiff)+1; // +1 
            }
            
        }
        
        if (dd>365) {
            dd = (dd-365);
            yyyy++;
        }
        
        
        if (leap==true && (DayCount>=287) && (DayCount<347)) { 
            
            if (DayCount==287){
                dd = 31;
            }
            
            else {
                dd -= 2;
            }
            
        } 
        
        else if (leap==true && (DayCount>=347)) {
            dd -= 1;
        }
        
        
        for (int i=0 ; i<12 ; i++){
            
            if (dd>Miladi[i]) {
                dd = (dd-Miladi[i]);
            }
            
            else {
                mm = (i+1);
                break;
            }
            
        }
        
        
        if (leap==true && (DayCount==287)) mm=12;
        
        
        if (mm<10 && dd>=10) {
            System.out.println(yyyy + "-0" + mm + "-" + dd);
        }
        
        else if (mm>=10 && dd<10) {
            System.out.println(yyyy + "-" + mm + "-0" + dd);
        }
        
        else if (mm<10 && dd<10) {
            System.out.println(yyyy + "-0" + mm + "-0" + dd);
        }
        
        else {
            System.out.println(yyyy + "-" + mm + "-" + dd);
        }
        
        
    }
    
}