import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        nevjegy();
        //Fejrész kiírása
        System.out.println("Jelszavak");
        //Verzió kiírása
        System.out.println("Verzió: 0.0.1");
        
        //Az scan objektummal kérhetünk be a konzolról
        Scanner scan = new Scanner(System.in);

        System.out.print("Felhasználónév: ");
        // A name változó tárolja a felhasználónevet
        String name = scan.nextLine();
        System.out.print("Jelszó: ");
        String password = scan.nextLine();
        System.out.print("Hely: ");
        String place = scan.nextLine();
        scan.close();
        int iSiker = 0;
        try {
            /* 
            A jelszó, a felhasználónév és a 
            használati helye a passList 
            objektumban van tárolva            
            */
            Store passList = new Store(name, password, place);
            FileWriter filewriter = new FileWriter("pass.txt");
            PrintWriter pwr = new PrintWriter(filewriter);
            pwr.print(passList.user);
            if(!passList.hollow()) { pwr.print(passList.retrieval()); }
            pwr.print(passList.place);
            pwr.close();
            iSiker = 1;
        } catch (IOException ex) {
            System.err.println("Hiba! A fájlbaírás sikertelen. Keresse meg a fejlesztőt.");
        }

        if(iSiker == 1) { System.out.println("Ok. A kiírás sikeres.");  }else {  System.out.println("Hiba! A kiírás sikertelen"); }

    }

    public static void nevjegy() {
        System.out.println("Nagy János");
    }
}
