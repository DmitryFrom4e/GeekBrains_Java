package dz05.work01;

import java.util.HashMap;

public class withLoaded {
    public void reOrganize(String[] array, HashMap<Integer, String> hm) {
        String[] lineArray;
        System.out.println(array.length);
        for (int i = 0; i < array.length; i++) {
            lineArray = array[i].split(",");
            user user = new user();
            user.Id = Integer.parseInt(lineArray[0].substring(lineArray[0].indexOf(":") + 1, lineArray[0].length()));
            user.FirstName = lineArray[1].substring(lineArray[1].indexOf(":") + 1, lineArray[1].length()).trim();
            user.MiddleName = lineArray[2].substring(lineArray[2].indexOf(":") + 1, lineArray[2].length()).trim();
            user.LastName = lineArray[3].substring(lineArray[3].indexOf(":") + 1, lineArray[3].length()).trim();
            user.Telephone = lineArray[4].substring(lineArray[4].indexOf(":") + 1, lineArray[4].length()).trim();
            if (!hm.containsKey(user.Id))
                hm.put(user.Id,
                        String.format("%s %s %s%s",
                                user.FirstName,
                                user.MiddleName,
                                user.LastName,
                                ", телефон(ы): " + user.Telephone));
            else
                hm.put(user.Id, hm.get(user.Id) + ", " + user.Telephone);
        }

    }
}
