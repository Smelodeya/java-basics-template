package com.epam.izh.rd.online.service;

import java.util.Arrays;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     *
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        return Integer.compare(value1, value2);
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        return Math.max(value1, value2);
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int maxValue = values[0];
        for (int i = 1; i < values.length; i++ ) {
            if (maxValue < values[i]) {
                maxValue = values[i];
            }
        }
        return maxValue;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sumValues = 0;
        for (int value : values) {
            sumValues = sumValues + value;
        }
        return sumValues;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        int[] evenValues = new int[values.length];
        int j = 0;
        for (int value : values ) {
            if (value % 2 == 0) {
                evenValues[j] = value;
                j++;
            }
        }
        return Arrays.copyOf(evenValues, j);
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        int factorial = 1;
        for (int i = 1; i <= initialVal; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     *
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     *
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        long[] arrFibonacci = new long[number + 1];
        if (number == 0) {
            arrFibonacci[number] = number;
        } else {
            arrFibonacci[0] = 0;
            arrFibonacci[1] = 1;
            for (int i = 2; i <= number; i++) {
                arrFibonacci[i] = arrFibonacci[i - 1] + arrFibonacci[i - 2];
            }
        }
        return arrFibonacci[number];
    }


    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < values.length - 1; i++) {
                if (values[i] > values[i+1]) {
                    temp = values[i];
                    values[i] = values[i+1];
                    values[i+1] = temp;
                    sorted = false;
                }
            }
        }

        return values;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     *
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {

        //первая версия - проверяла остаток от деления на любое число, входящее в диапазон от 2 до (number - 1)
        /*boolean isPrimary = true;
        for (int i = 2; i < number); i++) {
            if (number % i == 0)  {
                isPrimary = false;
                break;
            }
        }*/

        //вторая версия - проверяю остаток от деления на любое число,
        // входящее в диапазон от 2 до квадратного корня из number, т.е. убрала заведомо лишние итерации.
        // В этом  варианте тоже есть лишние проверки, например нет смысла проверять четные числа,
        // если число не делится без остатка на 2, но по-моему это излишнее усложнение алгоритма.
        double endCalculation = Math.sqrt(number);
        boolean isPrimary = true;
        int i = 2;
        while ((i <= endCalculation) && (isPrimary)){
            if (number % i == 0)  {
                isPrimary = false;
            }
            i++;
        }
        return isPrimary;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     *
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        int[] reverseValues = new int[values.length];
        for (int i = 0; i < values.length; i++){
            reverseValues[values.length - i - 1] = values[i];
        }
        return reverseValues;
    }
}

