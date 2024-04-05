
import java.util.Scanner;

public class TestKata {
    public static void main(String[] args) throws Exception {

        System.out.println("Input:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));

    }

    public static String calc(String input) throws Exception {

        int num1;
        int num2;
        String op;
        int result = 0;
        boolean romanIs;
        String[] operands = input.split(" ");
        if(operands.length <3 ) {
            throw new Exception("//т.к. строка не является математической операцией");}
        else if (RomAlf.isAlfRom(operands[0]) && RomAlf.isAlfRom(operands[2])){
            romanIs = true;
            num1 = RomAlf.convert(operands[0]);
            num2 = RomAlf.convert(operands[2]);
        }
        else  if(!RomAlf.isAlfRom(operands[0]) && !RomAlf.isAlfRom(operands[2])) {
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[2]);
            romanIs = false;
        }
        else {
            throw new Exception("т.к. используются одновременно разные системы счисления");}
        if (num1 > 10 || num2 > 10) {
            throw new Exception("Число должно быть не больше 10");}
        if (num1 < 1 || num2 < 1) {
            throw new Exception("Число должно быть начинаться с 1 - 10");}

        if (operands.length != 3){
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");}
        op = operands[1];
         switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                throw new Exception("Не поддерживается калькулятором");

        }
        String strNumber = null;
        if (romanIs){
                if (result < 1){
                    throw new Exception("//т.к. в римской системе нет отрицательных чисел");
                }
        strNumber = RomAlf.isConvert(result);}
        else {
        strNumber = String.valueOf(result);}
        return strNumber;
    }
}