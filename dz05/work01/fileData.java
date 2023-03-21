package dz05.work01;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import sem02.stringBuilder;

/**
 * Реализуйте структуру телефонной книги с помощью HashMap,
 * учитывая, что 1 человек может иметь несколько телефонов.
 */
public class fileData {

    public String[] fileRead() throws Exception {
        FileReader fr = new FileReader("DZ\\dz05\\work01\\telephone.txt");
        StringBuilder builder = new StringBuilder();
        Scanner scanner = new Scanner(fr);

        while (scanner.hasNextLine())
            builder.append(scanner.nextLine()
                    .replaceAll("\\{", "")
                    .replaceAll("\"", ""));

        builder.delete(0, 2);
        builder.delete(builder.lastIndexOf("]"), builder.length());
        builder.delete(builder.lastIndexOf("}"), builder.length());

        fr.close();
        scanner.close();
        return builder.toString().split("},");
    }

    public void fileWrite(String[] args) throws Exception {
        FileWriter fw = new FileWriter("DZ\\dz05\\work01\\telephone.txt", true);
        fw.flush();
        fw.close();
    }

}
