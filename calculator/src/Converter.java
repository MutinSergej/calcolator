import java.util.TreeMap;

public class Converter {
    TreeMap<Character, Integer> roman_numerals_KeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabic_numerals_KeyMap = new TreeMap<>();

    public Converter() {
        roman_numerals_KeyMap.put('I', 1);
        roman_numerals_KeyMap.put('V', 5);
        roman_numerals_KeyMap.put('X', 10);
        roman_numerals_KeyMap.put('L', 50);
        roman_numerals_KeyMap.put('C', 100);
        roman_numerals_KeyMap.put('D', 500);
        roman_numerals_KeyMap.put('M', 1000);

        arabic_numerals_KeyMap.put(1000, "M");
        arabic_numerals_KeyMap.put(900, "CM");
        arabic_numerals_KeyMap.put(500, "D");
        arabic_numerals_KeyMap.put(400, "CD");
        arabic_numerals_KeyMap.put(100, "C");
        arabic_numerals_KeyMap.put(90, "XC");
        arabic_numerals_KeyMap.put(50, "L");
        arabic_numerals_KeyMap.put(40, "XL");
        arabic_numerals_KeyMap.put(10, "X");
        arabic_numerals_KeyMap.put(9, "IX");
        arabic_numerals_KeyMap.put(5, "V");
        arabic_numerals_KeyMap.put(4, "IV");
        arabic_numerals_KeyMap.put(1, "I");

    }


    public boolean isRoman(String number){
        return roman_numerals_KeyMap.containsKey(number.charAt(0));
    }

    public String intToRoman(int number) {
        String roman = "";
        int arabic_Key;
        do {
            arabic_Key = arabic_numerals_KeyMap.floorKey(number);
            roman += arabic_numerals_KeyMap.get(arabic_Key);
            number -= arabic_Key;
        } while (number != 0);
        return roman;


    }
    public int romanToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int arabian;
        int result = roman_numerals_KeyMap.get(arr[end]);
        for (int i = end - 1; i >= 0; i--) {
            arabian = roman_numerals_KeyMap.get(arr[i]);

            if (arabian < roman_numerals_KeyMap.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }


        }
        return result;

    }
}
