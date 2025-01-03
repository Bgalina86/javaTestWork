package help;

//import static java.lang.runtime.ObjectMethods.split;

import constClass.CodeError;

import static constClass.CodeError.*;
import static constClass.ConstString.*;

public class Validation {

    /**
     * Определяет, есть ли в строке числа
     *
     * @param sym Символ для проверки
     * @return false или true
     */
    private static boolean isNotNumberChars(char sym) {
        for (int i = 0; i < kNumberChars.length(); i++) {
            if (kNumberChars.charAt(i) != sym) {
                return false;
            }
        }
        return true;
    }

    /**
     * Определяет, является ли символ латиницей
     *
     * @param sym Символ для проверки
     * @return false или true
     */
    private static boolean isLetterEng(char sym) {
        for (int i = 0; i < kLetterEng.length(); i++) {
            if (kLetterEng.charAt(i) == sym) {
                return false;
            }
        }
        return true;
    }

    /**
     * Определяет, является ли символ кириллицей
     *
     * @param sym Символ для проверки
     * @return false или true
     */
    private static boolean isLetterRus(char sym) {
        for (int i = 0; i < kLetterRus.length(); i++) {
            if (kLetterRus.charAt(i) == sym) {
                return false;
            }
        }
        return true;
    }

    /**
     * Определяет, является ли символ спецсимволом
     *
     * @param sym Символ для проверки
     * @return false или true
     */

    private static boolean isSpecialSymbol(char sym) {
        for (int i = 0; i < kSpecialSymbol.length(); i++) {
            if (kSpecialSymbol.charAt(i) == sym) {
                return true;
            }
        }
        return false;
    }

    /**
     * Определяет, является ли знак математической операцией
     *
     * @param sym Символ для проверки
     * @return false или true
     */
    private static boolean isOperationsChars(char sym) {
        for (int i = 0; i < kOperationsChars.length(); i++) {
            if (kOperationsChars.charAt(i) == sym) {
                return true;
            }
        }
        return false;
    }

    /**
     * Организация допустимых знаков
     *
     * @param sym Символ для проверки
     * @return
     */
    private static boolean isAllowedChar(char sym) {
        return Character.isDigit(sym) || isOperationsChars(sym) || sym == ' ';
    }

    /**
     * Проверка на допустимые знаки
     *
     * @param line
     * @return false или true
     */
    private static boolean hasValidCharsOnly(String line) {
        for (int i = 0; i < line.length(); i++) {
            char sym = line.charAt(i);
            if (!isAllowedChar(sym))
                return false;
        }
        return true;
    }


    /**
     * Проверяет пароль на валидность по правилам
     *
     * @param password Пароль
     * @return Код ошибки, если пароль невалидный, или 0 - если правильный.
     */
    private static CodeError checkStringValidation(final String password) {

        if (password.length() < 3) {
            return Error_NoStringLength;
        }

        int amountOfDigits = 0;           // Число встреченных цифр
        int amountOfOperationChars = 0;   // Число встреченных математических операций
        int amountOfLetterRus = 0;       // Число встречаемых символов кириллицы
        int amountOfLetterEng = 0;     //
        int amountOfSpecialSymbol = 0; //

        for (int i = 0; i < password.length(); i++) {
            char currChar = password.charAt(i);
            if ((Character.isDigit(currChar) || isOperationsChars(currChar))
                && !isLetterEng(currChar) && !isLetterRus(currChar) && !isSpecialSymbol(currChar)){
                if (Character.isDigit(currChar)){amountOfDigits++;}
                if (isOperationsChars(currChar)) {amountOfOperationChars++;}
                return null;
            } else if (isSpecialSymbol(currChar)){amountOfSpecialSymbol++;}
              else if (isLetterRus(currChar)){amountOfLetterRus++;}
              else if (isLetterEng(currChar)){amountOfLetterEng++;}
            return Error_StringNotValidation;
        }
//        for (int i = 0; i < kOperationsChars.length(); i++) {
//            char currOperation = kOperationsChars.charAt(i);
//            String[] name1 = stringSplit(password, String.valueOf(currOperation));
//            System.out.println(name1);
//        }
        if (amountOfSpecialSymbol != 0) {
            return Error_SpecialChar;
        }
        if (amountOfOperationChars == 0) {
            return Error_NoOperationsChars;
        } else if (amountOfOperationChars > 1) {
            return Error_OperationsCharsMin;
        }
        if (amountOfLetterRus != 0) {
            return Error_LetterRus;
        }
        if (amountOfLetterEng != 0) {
            return Error_LetterEnglish;
        }

        //
        // Правило: должна быть хотя бы две цифры
        //
        if (amountOfDigits == 0) {
            return Error_NoNumberChars;
        } else if (amountOfDigits == 1) {
            return Error_NoMinNumberChars;
        }

        //
        // Правило: должен быть хотя бы один спец-символ
        //

        return null;

    }

    /**
     * Разбиваем на лексемы относительно математических операций
     * @param password введенная строка
     * @return разбивает на лексемы или возвращаем false
     */
    private static boolean stringSplitST(String password) {
        for (int i = 0; i < kOperationsChars.length(); i++) {
            char currOperation = kOperationsChars.charAt(i);
            String[] name1 = stringSplit(password, String.valueOf(currOperation));
            // проверка лексемы на на личные не допустимых символов
            System.out.println(name1);
        }
        return false;
    }

    /**
     * Организация правила разбития на лексемы
     *
     * @param st введенная строка
     * @param regex правило разделения на лексемы
     * @return возвращаем массив строк
     */
    private static String[] stringSplit(String st, String regex) {
        st.split(regex);
        return new String[0];
    }

    private static void assertBool(boolean rv, String msg) {
        if (!rv) {
            System.out.print("Condition false, message is:");
            System.out.println(msg);
        }
    }

//    public static void main(String[] args) {
//        System.out.print("Запуск тестов...");
//
//        assertBool(hasValidCharsOnly("123 + 456"), "Правильная строка расценена как ошибочная");
//        assertBool(!hasValidCharsOnly("123+ФИЫ"), "Незамеченная ошибка");
//
//        //разбитие на лексемы
//        assertBool(stringSplitST("123 + 456"), "Ntcn");
//        assertBool(stringSplitST("123+ФИЫ"), "qre");
//        ;
//
//        System.out.println("All ok");
//        return;
//    }
}