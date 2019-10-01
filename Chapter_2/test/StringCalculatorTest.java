import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class StringCalculatorTest {

    StringCalculator stringCalculator;

    final String rawString = "1,2:4";
//    final String rawString = "//;\n1;2;4";

    @Before
    public void buildStringCalculator() {
        stringCalculator = new StringCalculator(rawString);
    }

    @Test
    public void findMatcher() {
//        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(rawString);
//        assertEquals(matcher.find(), true);
//        assertEquals(matcher.group(1), ";");
//        System.out.println(stringCalculator.findMatcher(rawString).group(1));
//        assertEquals(stringCalculator.findSeperator(rawString), ";");

        Matcher matcher = stringCalculator.findMatcher();

        System.out.println(matcher.find());

    }

    @Test(expected = RuntimeException.class)
    public void findNegative() {
        stringCalculator.findNegative(new String[]{"1", "2", "-3"});
    }

    @Test
    public void getRawString() {
    }

    @Test
    public void splitRawString() {
        System.out.println(Arrays.toString(stringCalculator.splitRawString()));
//        System.out.println(Arrays.toString(stringCalculator.splitRawString("1,2:5")));

    }

    @Test
    public void addAll() {
        // given
        String [] strings = stringCalculator.splitRawString();

        // when
        int answer = 0;
        for(String s :strings) {
            answer += Integer.parseInt(s);
        }

        // then
        assertEquals(answer, 7);
        assertEquals(stringCalculator.addAll(), 7);
    }


}