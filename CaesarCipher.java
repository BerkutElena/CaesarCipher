import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class CeasarCipher {

    /*
    *
    Читает и шифрует тест из файла.
    *
     */


    public static void readingFileEncryption(String FileName, int key) {

        String output = "";
        char c = 0;

        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(FileName)));
            for (String str : lines) {
                char[] chars = str.toCharArray();
                {
                    for (int i = 0; i < chars.length; ++i) {
                        c = chars[i];
                        for (int j = 0; j < Alphabet.ALPHABET.size(); ++j) {
                            char a = Alphabet.ALPHABET.get(j);
                            if (c == a) {
                                int x = (j + key) % Alphabet.ALPHABET.size();
                                char ch = Alphabet.ALPHABET.get(x);
                                output += ch;

                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Файл  для шифрования не найден.");
        }


        writingFile(ConsoleDialogue.FileNameCopy, output);
    }

/*
*
    Читает и расшифровывает тест из файла.
    *
     */


    public static void readingFileDecryption(String FileName, int key) {


        String output = "";
        char c = 0;

        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(FileName)));
            for (String str : lines) {
                char[] chars = str.toCharArray();
                {
                    for (int i = 0; i < chars.length; ++i) {
                        c = chars[i];
                        for (int j = 0; j < Alphabet.ALPHABET.size(); ++j) {
                            char a = Alphabet.ALPHABET.get(j);
                            if (c == a) {
                                int x = Math.abs(j - key) % Alphabet.ALPHABET.size();
                                char ch = Alphabet.ALPHABET.get(x);
                                output += ch;
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Файл для расшифровки не найден.");
        }

        writingFile(ConsoleDialogue.FileNameCopy, output);
    }


    /*
    *
    Записывает шифрованный и расшифрованный тест из файла в новый файл.
    *
     */

    private static void writingFile(String FileNameCopy, String output) {


        try {
            FileWriter writer = new FileWriter(FileNameCopy);
            writer.write(output);
            writer.close();

        } catch (IOException e) {
            System.out.println("Файл не найден.");
        }


    }


    /*
    *
     Расшифровывает методом подбора ключей.
     *
     */
    public static void bruteForce(String FileName) {

        String output = "";
        char c = 0;
        int letter = 33;
        for (int k = 1; k < letter; k++){
            try {
                ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(FileName)));
                for (String str : lines) {
                    char[] chars = str.toCharArray();
                    {
                        for (int i = 0; i < chars.length; ++i) {
                            c = chars[i];
                            for (int j = 0; j < Alphabet.BRUT_ALPHABET.size(); ++j) {
                                char a = Alphabet.BRUT_ALPHABET.get(j);
                                if (c == a) {
                                    int x = Math.abs(j - k) % Alphabet.BRUT_ALPHABET.size();
                                    char ch = Alphabet.BRUT_ALPHABET.get(x);
                                    output += ch;
                                }
                            }
                        }
                    }
                }

            }catch (IOException e) {
                System.out.println("Файл для расшифровки не найден.");
            }

    }






        writingFile(ConsoleDialogue.FileNameCopy, output);
    }


}

/*

 */
