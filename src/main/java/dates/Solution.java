package dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Solution {

    private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    public static int solution(String S, String T)
    {
        String temp = new String(S);
        int counter = 0;

        try
        {
            while (!temp.equals(T))
            {
                System.out.println(temp);

                if (hasAtMostTwoDigits(temp))
                    counter++;

                temp = addOneSecond(temp);
            }
        }
        catch (ParseException e)
        {
            return -1;
        }

        if (hasAtMostTwoDigits(temp))
            counter++;

        return counter;
    }

    private static boolean hasAtMostTwoDigits(String s)
    {
        Set<Character> digits = new HashSet<>();

        for (int i = 0; i < s.length(); i++)
        {
            if (':' != s.charAt(i))
                digits.add(s.charAt(i));
        }

        System.out.println("Contenuto del set : ");
        for (Character a : digits)
        {
            System.out.println(String.valueOf(a));
        }

        return digits.size() <= 2;
    }

    private static String addOneSecond(String time) throws ParseException
    {
        Calendar cal = new GregorianCalendar();
        Date d = sdf.parse(time);

        cal.setTime(d);
        cal.add(Calendar.SECOND, 1);

        return sdf.format(cal.getTime());
    }

    public static void main(String... args) {
        System.out.println(solution("09:10:00","13:00:00"));
    }
}