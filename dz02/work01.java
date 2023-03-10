package dz02;

/**
 * 1 . Дана строка sql-запроса "select * from students where ". Сформируйте
 * часть WHERE этого запроса, используя StringBuilder. Данные для фильтрации
 * приведены ниже в виде json строки.
 * Если значение null, то параметр не должен попадать в запрос.
 * Параметры для фильтрации: {"name":"Ivanov", "country":"Russia",
 * "city":"Moscow", "age":"null"}
 */
public class work01 {
    private static String jsonToSql(String[] jsonText) {
        StringBuilder builder = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < jsonText.length; i++) {
            String key = jsonText[i].split(":")[0].replaceAll("\"", "");
            String value = jsonText[i].split(":")[1].replaceAll("\"", "'");
            if (!value.equals("'null'") & counter == 0) {
                builder.append(String.join("", " " + key, " = " + value));
            } else {
                builder.append(String.join("", " AND " + key, " = " + value));
            }
            counter++;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String jsonStr = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        String sqlText = "select * from students where";
        String[] sqlParamsIn = jsonStr
                .replace("{", "")
                .replace("}", "")
                .replaceAll(" ", "")
                .split(",");

        String sqlParamsTotal = jsonToSql(sqlParamsIn);
        System.out.println(sqlText + sqlParamsTotal);
    }
}
