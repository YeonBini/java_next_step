import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    final private String rawString;
    final private Pattern pattern;

    // StringCalculator 생성 시에 rawString을 한 번만 받고 수정은 불가능하게 만든다.
    // Pattern도 초기 생성 시 생성하여 코드의 중복을 피한다.
    public StringCalculator(String rawString) {
        this.rawString = rawString;
        this.pattern = Pattern.compile("//(.)\n(.*)");
    }

    public String getRawString() {
        return this.rawString;
    }


    // 최종적으로 합계를 구하는 메소드
    public int addAll() {
        String [] stringForCalc = splitRawString();

        findNegative(stringForCalc);

        int answer = 0;
        for(String s :stringForCalc) {
            answer += Integer.parseInt(s);
        }

        return answer;
    }

    // 계산을 해야하는 부분을 split 해준다.
    // 별도 구분자가 있는 경우 seperator를 별도로 설정
    // 별도 구분자가 없는 경우 요구사항에 있는 대로 ",|:"가 구분자가 된다.
    public String[] splitRawString() {
        Matcher matcher = findMatcher();

        if(matcher.find()) {
            String sep = matcher.group(1);
            String stringForCalc = matcher.group(2);
            return stringForCalc.split(sep);
        }

        return rawString.split(",|:");
    }

    // Pattern에 맞는 Matcher를 리턴한다.
    // 별도의 구분자가 없을 경우 matcher.find()는 false를 리턴한다.
    public Matcher findMatcher() {
        return  pattern.matcher(rawString);
    }

    // 음수를 포함할 경우 RuntimeException을 날려준다.
    public void findNegative(String [] stringForCalc) {
        for(String s :stringForCalc) {
            int num = Integer.parseInt(s);
            if(num < 0) throw new RuntimeException("has negative numbers");
        }
    }
}
