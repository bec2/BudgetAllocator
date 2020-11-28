import java.util.ArrayList;
import java.util.Scanner;


public class Prog {
    public static void main(String[] args){
        System.out.println("*********************");
        System.out.println("BUDGET ALLOCATION HELPER");
        System.out.println("********************");
        System.out.println("");
        System.out.println("Please type your total budget in £: ");

        //Setting up the scanner and declaring our two arrays - one for percentages and one for names
        //Take the total budget value from the user
        Scanner scan = new Scanner(System.in);
        double total = scan.nextDouble();
        double sum = 0;
        int counter = 0;
        int i = 0;
        ArrayList<Double> percent = new ArrayList<Double>();
        ArrayList<String> label = new ArrayList<String>();

        System.out.println("Total budget set at £" + total);

        do {
            System.out.println("What proportion of budget does task "+(counter+1)+" get? ");
            double value = scan.nextDouble();
            percent.add(value);
            scan.nextLine(); //This line required or the next scanner takes the println and skips ahead
            sum += percent.get(counter);
            counter++;
            System.out.println("Give this task a name. ");
            String name = scan.nextLine();
            label.add(name);


        } while (sum < 100);
        scan.close();

        //Once we reach 100, stop taking values
        if (sum >= 100) {
            double cumSum = 0.0;
            for(int j = 0; j < percent.size() - 1; j++){
                cumSum += percent.get(j);
            }
            percent.set((percent.size()-1),100.0 - cumSum);
        }

        System.out.println("Any percentages over 100 have been decreased to fit the budget.");
        System.out.println(" ");

        //Do the maths and output the values
        for(double value : percent){
            String labelNum = label.get(i);
            double exp = value * total / 100.0;
            System.out.println("Allocation for " + labelNum + " (" + value + "%) equals: £"+ exp);
            i++;
        }

        System.out.println(" ");
        System.out.println("Thank you for using this tool!");
    }
}
