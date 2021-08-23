import java.util.Scanner;

public class Q {
    public static void main(String[] args) {
        System.out.println("Enter the String: ");
        String str = new String();
        System.out.println(((int) 'A'));
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        if (a.matches("^[a-zA-Z]+$")){
            str = a;
        }else{
            System.out.println("Enter correct sentence to not include special character or number.");
            System.exit(0);
        }
        int len = str.length();
        int count = 0;
        char ch = '\0';
        for (int i = 0; i < len-1 ; i++){
            ch = str.charAt(i);
            int j = 0;
            while ( j < len){
                if (ch == str.charAt(j))
                    count++;
                if (count == 2)
                    break;
                j++;
            }
            if (count == 1)
                break;
            count = 0;

        }
        if (count == 1)
            System.out.println("The first non repeating letter is: "+ ch);
        else
            System.out.println("No non-repeating element.");
    }
}
