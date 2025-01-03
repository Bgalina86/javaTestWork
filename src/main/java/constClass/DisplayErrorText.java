package constClass;

public class DisplayErrorText {
    private static String displayErrorText(CodeError code) {
        switch (code) {
            case null:
                return "Строка введена корректно согласно примеру";
            case Error_LetterEnglish:
                return "Строка содержит латиницу. Введите, пожалуйста, вновь выражение для вычисления";
            case Error_LetterRus:
                return "Строка содержит кириллицу. Введите, пожалуйста, вновь выражение для вычисления";
            case Error_SpecialChar:
                return "Строка содержит спецсимволы. Введите, пожалуйста, вновь выражение для вычисления";
            case Error_NoNumberChars:
                return "Строка не содержит числа. Введите, пожалуйста, вновь выражение для вычисления";
            case Error_NoMinNumberChars:
                return "Строка содержит 1 число. Введите, пожалуйста, вновь выражение для вычисления";
            case Error_NoOperationsChars:
                return "Строка не содержит знаков операций. Введите, пожалуйста, вновь выражение для вычисления";
            case Error_OperationsCharsMin:
                return "Строка содержит знаков операций больше чем 1. Введите, пожалуйста, вновь выражение для вычисления";
            case Error_NoStringLength:
                return "Строка не является арифметическим примером. Количество символов в строке меньше 3. Введите, пожалуйста, вновь выражение для вычисления";
            case Error_StringStartWith:
                return "Строка начинается на знак арифмтической операции. Введите, пожалуйста, вновь выражение для вычисления";
            case Error_StringNotValidation:
                return "Строка не валидна. Содержит не допустимые символы. Введите, пожалуйста, вновь выражение для вычисления";
            default:
                return "Неизвестный код ошибки. Введите, пожалуйста, вновь выражение для вычисления";
        }
    }
}
