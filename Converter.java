import java.sql.SQLOutput;
import java.util.TreeMap;

public class Converter {
    TreeMap<Character, Integer> romanKey = new TreeMap<>();
    TreeMap<Integer, String> arabianKey = new TreeMap<>();

    public Converter(){
        romanKey.put('I', 1);
        romanKey.put('V', 5);
        romanKey.put('X', 10);
        romanKey.put('L', 50);
        romanKey.put('C', 100);
        romanKey.put('D', 500);
        romanKey.put('M',1000);

        arabianKey.put(1000, "M");
        arabianKey.put(900, "CM");
        arabianKey.put(500, "D");
        arabianKey.put(400, "CD");
        arabianKey.put(100, "C");
        arabianKey.put(90, "XC");
        arabianKey.put(10, "X");
        arabianKey.put(9, "IX");
        arabianKey.put(5, "V");
        arabianKey.put(4, "IV");
        arabianKey.put(1, "I");
    }

    public boolean isRoman(String number){
        return romanKey.containsKey(number.charAt(0));
    }

    public String intToRoman (int number) {
        String roman = "";
        int aKey;

        do {
            aKey = arabianKey.floorKey(number);
            roman += arabianKey.get(aKey);
            number -= aKey;
        }
        while (number != 0);
        return roman;
    }



    public int romanToInt(String s) {
        int end = s.length() - 1;
        char [] arr = s.toCharArray();
        int arabian;
        int result = romanKey.get(arr[end]);
        for (int i = end -1; i >= 0; i--) {
            arabian = romanKey.get(arr[i]);

            if (arabian < romanKey.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }
        return result;
    }
}
