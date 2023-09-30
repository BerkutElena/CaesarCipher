public class Validator {

/*
Проверяет не использует ли пользователь системные файлы для шифровки и расшифровки.
 */

    public static void ridingFilesValidator(String FileName) {
        boolean retVal;

        while (retVal = true) {
            if ((retVal = FileName.endsWith(".dull") || (retVal = FileName.endsWith(".sys")) || (retVal = FileName.endsWith(".cab")))) {
                System.out.println("Некорректный адрес файла. Выберите формат .txt");
            }
            break;
        }

    }

    public static void ridingFilesCopyValidator(String FileNameCopy) {
        boolean retVal;

        while (retVal = true) {
            if ((retVal = FileNameCopy.endsWith(".dull") || (retVal = FileNameCopy.endsWith(".sys")) || (retVal = FileNameCopy.endsWith(".cab")))) {
                System.out.println("Некорректный адрес файла. Выберите формат .txt");
            }
            break;

        }
    }

    public static void whithingFilesValidator(String FileNameCopy) {
        boolean retVal;

        while (retVal = true) {
            if ((retVal = FileNameCopy.endsWith(".dull") || (retVal = FileNameCopy.endsWith(".sys")) || (retVal = FileNameCopy.endsWith(".cab")))) {

                System.out.println("Некорректный адрес файла. Выберите формат .txt");
            }
            break;
        }

    }

    /*
    Проверка ключа. Могут быть только положительные цифры.
     */

    public static void keyValidator(int key) {
        if (key <= 0) {
            System.out.println("Ключ может быть только больше 0");
        }

    }


}
