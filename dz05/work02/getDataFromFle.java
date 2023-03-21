package dz05.work02;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class getDataFromFle {
    public void fileRead(HashMap<String, String> people) throws Exception {
        FileReader fr = new FileReader("DZ\\dz05\\work02\\people.txt");
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(fr);

        try {
            while (scanner.hasNextLine())
                people.put(scanner.nextLine().split(" ")[1], scanner.nextLine().split(" ")[0]);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        fr.close();
        scanner.close();

    }
}
