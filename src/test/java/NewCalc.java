import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * @author ZakrenichniyAN
 */

public class NewCalc {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        String task;
        do{
            System.out.println("Выберите номер задачи:");
            System.out.println("1 - calculator");
            System.out.println("2 - string array");
            task = getFromConsole();
        }while (!(task.equals("1") || task.equals("2")));

        switch (task){
            case "1": calc(); break;
            case "2": findMaxArrayElement();
        }

    }

    /**
     * Work with Calculator operations
     */
    public static void calc() throws IOException {
        String answer;
        do {
            System.out.println("Выберите операцию :");
            System.out.println("1 - Сложение");
            System.out.println("2 - Вычитание");
            System.out.println("3 - Умножение");
            System.out.println("4 - Деление");

            answer = getFromConsole().trim();

        }while (!(answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4")));

        double firstParam = getDoubleFromConsole("Введите первое число");
        double secondParam = getDoubleFromConsole("Введите второе число");

        double result = 0.0;
        try {
            switch (answer){
                case "1" :
                    result = sum(firstParam, secondParam);
                    break;
                case "2" :
                    result = subtraction(firstParam, secondParam);
                    break;
                case "3" :
                    result = multiplication(firstParam, secondParam);
                    break;
                case "4" :
                    result = division(firstParam, secondParam);
            }
            System.out.printf("%.4f", result);

        }catch (ArithmeticException e){
            System.out.println("Делить на 0 нельзя");
        }
    }

    /**
     * Find max value from array elements
     */
    public static void findMaxArrayElement() throws IOException {

        int count = 0;
        do {
            System.out.println("Укажите размерность массива");
            count = Integer.parseInt(getFromConsole());
        }while (count<=0);

        String[] dictionary = new String[count];
        int max = 0;
        for (int i = 0; i < count; i++) {
            System.out.println("Введите слово "+ (i+1) +"/" + count);
            dictionary[i] = getFromConsole();

        }
        for (int i = 0; i < dictionary.length; i++) {
            if (max< dictionary[i].length()) max = dictionary[i].length();
        }
        System.out.printf("Максимальная длина текста в массиве : %d", max);

    }

    /**
     * @param a first double param
     * @param b second double param
     * @return sum of two params
     */
    public static Double sum(double a, double b){
        return a+b;
    }

    /**
     * @param a first double param
     * @param b second double param
     * @return subtraction of two params
     */
    public static Double subtraction(double a, double b){
        return a-b;
    }

    /**
     * @param a first double param
     * @param b second double param
     * @return multiplication of two params
     */
    public static Double multiplication(double a, double b){
        return a*b;
    }

    /**
     * @param a first double param
     * @param b second double param
     * @return division of two params
     */
    public static Double division(double a, double b) throws ArithmeticException {
        if (b==0) throw new ArithmeticException();
        return a/b;
    }

    /**
     * @return answer from user, type String
     */
    public static String getFromConsole() throws IOException {
        return br.readLine();
    }

    /**
     * @param text question text
     * @return answer from user Double type
     */
    public static double getDoubleFromConsole(String text) throws IOException {
        double result = 0.0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println(text);
            String value = br.readLine();
            if (value.matches("\\d+(.\\d+)?")){
                result = Double.parseDouble(value);
                break;
            }
        }while(true);
        return result;
    }
}
