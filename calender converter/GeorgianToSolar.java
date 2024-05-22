import java.util.Scanner;

public class GeorgianToSolar{

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
        int Shamsi[] = {31 , 31 , 31 , 31 , 31 , 31 , 30 , 30 , 30 , 30 , 30 , 29};
        // ShamsiMonth
        
        int yyyy=0 , dd=0 , mm=0;
        // Shamsi
        
        boolean leap = false;
        
        yyyy = (year - 621);
        // to check miladi year
        
        
        if ((year%4==0 && year%100!=0) || (year%400==0 && year%100==0)) { // is leap
            leap = true;
            Miladi[1]=29; // if leap: February ---> 29 days
            Shamsi[11]=30; // if leap: Esfand ---> 30 days
        }
        
        if (month<3 || (month==3 && day<=20)) {
            yyyy--;
        }

        for (int i=0 ; i<(month-1) ; i++){
           dd += Miladi[i];
        }

        dd += (day-79);

        if (dd<0) {
            dd += 365;
        } 
     
        for (int j=0 ; j<12 ; j++){
            
            if (dd>Shamsi[j]) {
                dd -= Shamsi[j];
            }
            
            else {
                mm = (j+1);
                break;
            }
            
        }
        
        
        if (leap!=true) {
            if (month==3 && day==20) {
                mm = 12;
                dd = 30;
            }
        }
        
        
        if (mm<10 && dd>=10) {
            System.out.println(yyyy + "/0" + mm + "/" + dd);
        }
        
        else if (mm>=10 && dd<10) {
            System.out.println(yyyy + "/" + mm + "/0" + dd);
        }
        
        else if (mm<10 && dd<10) {
            System.out.println(yyyy + "/0" + mm + "/0" + dd);
        }
        
        else {
            System.out.println(yyyy + "/" + mm + "/" + dd);
        }
        

    }
    
}