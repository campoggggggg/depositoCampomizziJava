public class ProvaCondizioniIf {
    public static void main(String[] args){
        if(20>18){
            System.out.println("20 is greater than 18");
        }

        int x = 20;
        int y = 18;
        if(x>y){
            System.out.println("x is greater than y");
        }
        
        int time = 20;
        if (time < 18){
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }

        int time_2 = 22;
        if(time_2 < 10){
            System.out.println("Good morning.");
        } else if (time < 18){
            System.out.println("Good day.");
        } else {
            System.out.println("Good evening.");
        }
    }
}