import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] action = {"+", "-", "/", "*"};
        String[] regexAction = {"\\+", "-", "/", "\\*"};
        Scanner enter = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String expression;
        expression = enter.nextLine();
        int actionIndex=-1;
        for (int i = 0; i < action.length; i++) {
            if(expression.contains(action[i])){
                actionIndex = i;
                break;
            }
        }
        if(actionIndex==-1){
            System.out.println("Неверное выражение!");
            return;
        }


        String[] data = expression.split(regexAction[actionIndex]);
        if(converter.isRoman(data[0]) == converter.isRoman(data[1])){
            int first,second;
            boolean isRoman = converter.isRoman(data[0]);
            if(isRoman){
                first = converter.romanToInt(data[0]);
                second = converter.romanToInt(data[1]);

            }else{
                first = Integer.parseInt(data[0]);
                second = Integer.parseInt(data[1]);
            }
            int result;
            switch (action[actionIndex]){
                case "+":
                    result = first+second;
                    break;
                case "-":
                    result = first-second;
                    break;
                case "*":
                    result = first*second;
                    break;
                default:
                    result = first/second;
                    break;
            }
            if(isRoman){
                System.out.println(converter.intToRoman(result));
            }
            else{
                System.out.println(result);
            }
        }else{
            System.out.println("Числа должны быть в одного формата");
        }


    }
}
