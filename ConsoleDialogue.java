import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleDialogue {

    static String FileName;
    static String FileNameCopy;
    static int key;

    static CeasarCipher ceasarCipher = new CeasarCipher();


    /*
    Стартовое меню для пользователя
     */

    public static void start() {


        System.out.println("***********************************************************\n" +
                "                  " + " Шифр Цезаря\n" + "                  \n" +
                "***********************************************************\n" +
                "                 Добро пожаловать!                          \n" +
                "***********************************************************");


        System.out.println("Выберите функцию");
        System.out.println("(1.)Зашифровать файл.\n"
                + "(2.)Расшифровать файл.\n" +
                "(3.)Взлом (Brute Force)\n");
        userSelection();

    }


    /*
    Позволяет пользователю сделать выбор. Пользователь не сможет ввести цифры >3  или буквы.
     */

    public static void userSelection() {


        Validator validator = new Validator();

        try {
            Scanner console = new Scanner(System.in);
            int choice = console.nextInt();


            if (choice == 1) {
                System.out.println("Введите адрес файла для зашифровки:");
                FileName = console.next();
                validator.ridingFilesValidator(FileName);
                //ridingFilesValidator();

                System.out.println("Введите ключ:");
                key = console.nextInt();
                validator.keyValidator(key);
                //keyValidator();

                System.out.println("Введите адрес файла для сохранения зашифрованного текста:");
                FileNameCopy = console.next();
                validator.whithingFilesValidator(FileNameCopy);
                //ridingFilesCopyValidator();


                ceasarCipher.readingFileEncryption(FileName, key);

                Main.end();
                //start();


            } else if (choice == 2) {
                System.out.println("Введите адрес файла для расшифровки:");
                FileName = console.next();
                validator.ridingFilesValidator(FileName);

                System.out.println("Введите ключ:");
                key = console.nextInt();
                validator.keyValidator(key);
                //keyValidator();

                System.out.println("Введите адрес файла для сохранения зашифрованного теста:");
                FileNameCopy = console.next();
                validator.whithingFilesValidator(FileNameCopy);
                //ridingFilesCopyValidator();


                ceasarCipher.readingFileDecryption(FileName, key);

                Main.end();
                //start();


            } else if (choice == 3) {
                System.out.println("Введите адрес файла для расшифровки методом Brute Force:");
                FileName = console.next();
                validator.ridingFilesValidator(FileName);

                System.out.println("Введите адрес файла для сохранения расшифрованного текста:");
                FileNameCopy = console.next();
                validator.whithingFilesValidator(FileNameCopy);
                //ridingFilesCopyValidator();


                ceasarCipher.bruteForce(FileName);

            } else if ((choice != 1) && (choice != 2) && (choice != 3)) {
                System.out.println("Выберите цифры : (1.)\n" + "(2.)\n" + "(3.)\n");
                userSelection();
            }

        } catch (InputMismatchException exception) {
            System.out.println("Ввод должен содержать цифры!");
            userSelection();
        }
    }

}