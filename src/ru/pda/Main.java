package ru.pda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int size, maxValue, treshold;
        String msg;

        Logger logger = Logger.getInstance();

        Scanner scanner = new Scanner(System.in);
        logger.log("Запуск программы\n");

        System.out.println("Следуйте указаниям программы.\n" +
                "Для выхода введите любое отрицательное число или 0.\n");
        logger.log("Запрос у пользователя вводных данных\n");

        while (true) {

            msg = "Введите размер массива (>0):";
            System.out.println(msg);
            size = scanner.hasNextInt() ? scanner.nextInt() : 0;
            msg = size > 0 ? "Введен размер массива: " + size + "\n" : "Введен 0 или текст\n";
            logger.log(msg);

            msg = "Введите верхнюю границу значений (>0):";
            System.out.println(msg);
            maxValue = scanner.hasNextInt() ? scanner.nextInt() : 0;
            msg = maxValue > 0 ? "Введена верхняя граница значений: " + maxValue + "\n" : "Введен 0 или текст\n";
            logger.log(msg);

            msg = "Введите порог фильтра (больше 0 и меньше " + maxValue + ")";
            System.out.println(msg);
            treshold = scanner.hasNextInt() ? scanner.nextInt() : 0;
            msg = treshold > 0 ? "Введена верхняя граница значений: " + treshold + "\n" : "Введен 0 или текст\n";
            logger.log(msg);

            if (size > 0 && maxValue > 0 && (treshold > 0 && treshold < maxValue)) {
                logger.log("Ввод данных завершен\n");
                logger.log("Размер массива = " + size + "\n");
                logger.log("Верхняя граница значений = " + maxValue + "\n");
                logger.log("Порог фильтрации = " + treshold + "\n");
                logger.log("Создаем массив\n");
                List<Integer> array = new ArrayList<>(size);
                logger.log("Пустой массив - " + array + ".\n");
                logger.log("Наполняем массив случайными числами\n");
                Random rnd = new Random();
                for (int i = 0; i < size; i++) {
                    array.add(rnd.nextInt(maxValue));
                }
                logger.log("Заполненый массив - " + array + ".\n");
                logger.log("Запускаем процесс фильтрации.\n");
                Filter filter = new Filter(treshold);
                List<Integer> result = filter.filterOut(array);
                System.out.println("Отфильтрованный список: " + result);
                logger.log("Отфильтрованный список: " + result + "\n");
                logger.log("Завершаем программу\n");
                break;
            } else {
                System.out.println("Введите корректные данные или любое отрицательное число для выхода");
            }

            if (scanner.nextInt() < 0) {
                msg = "Запрошено завершение программы\n";
                logger.log(msg);
                msg = "Программа завершена.\n";
                logger.log(msg);
                break;
            }
        }
    }
}
