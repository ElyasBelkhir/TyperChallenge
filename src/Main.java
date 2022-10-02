import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class Main {


    public static void main(String[] args) throws IOException {

        boolean restart = false;


        do {

            long startTime = System.nanoTime();

            int num = typeTest();

            long endTime = System.nanoTime();


            long time = endTime - startTime;


            double seconds = time / 1E+9;

            double minutes = time / 6E+10;


            int words = (int) (num / minutes);

            if (num != -1) {
                JOptionPane.showMessageDialog(null, "Wow! You finished in " + String.format("%.2f", seconds) + " seconds\nYou have an average speed of about " + words +
                        " words per minute(s)");

            }
            if (JOptionPane.showConfirmDialog(null, "Would You Like to Play Again?", "CONTINUE?",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                restart = true;


            } else {

                System.exit(0);

            }
        } while (restart);




    }

    public static int typeTest() throws IOException {


        File fileName = new File("new 1.txt");


        BufferedReader newString = new BufferedReader(new FileReader(fileName));

        List<String> listOfStrings = new ArrayList<String>();

        String line = newString.readLine();

        while (line != null) {
            listOfStrings.add(line);
            line = newString.readLine();
        }

        newString.close();

        String[] array = listOfStrings.toArray(new String[0]);

        JOptionPane.showMessageDialog(null,"Type the sentence as quickly as possible!");


        int num = randomNum();


        int word = words(array[num]);




        String answer = JOptionPane.showInputDialog(null, array[num]);

        if (answer.equals(array[num]) == false) {
            JOptionPane.showMessageDialog(null,"Sorry! You need perfect accuracy!");
            return -1;

        }


        return word;




    }

    public static int randomNum() {

        int min = 0;
        int max = 49;

        int randomNum = new Random().nextInt(min, max + 1);

        return randomNum;

    }

    public static int words(String str) {

        String[]words = str.split(" ");
        return words.length;
    }


}