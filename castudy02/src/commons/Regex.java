package commons;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    private static final String ID_REGEX = "SV\\w{2}-\\d{4}";
    private static final String NAME_REGEX = "^[A-Z]{1}[a-z]*";
    private static final String DATE_BIRTH_REGEX = "^\\d{2}\\/\\d{2}\\/\\d{4}$";

    private static Pattern pattern;
    private static Matcher matcher;

    public  static boolean validateId(String id) {
        pattern = Pattern.compile(ID_REGEX);
        matcher = pattern.matcher(id);
        return matcher.matches();
    }

    public static boolean validateName(String name) {
            pattern = Pattern.compile(NAME_REGEX);
            matcher = pattern.matcher(name);
            return matcher.matches();
    }
}
