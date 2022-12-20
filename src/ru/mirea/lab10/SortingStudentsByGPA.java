package ru.mirea.lab10;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class SortingStudentsByGPA extends Student implements Comparable {
    private static Scanner in = new Scanner(System.in);
    private static Student []objects;
    private static Student[] objectsTwo;
    private static Student[] LastStudents;

    //// Merge Sort by Scores and Group
    public static void mergesortByScores(Student[] LastStudents)    // Главный метод сортировки слиянием по баллам
    {
        Student[] buffer1 = LastStudents;   //Создаем копию массива для последующей сортировки
        Student[] buffer2 = new Student[LastStudents.length]; //Создаем пустой массив, длина которого равна количеству студентов
        Student[] result = mergesortInnerByScores(buffer1, buffer2, 0, LastStudents.length);
    }
    public static Student[] mergesortInnerByScores(Student[] buffer1, Student[] buffer2, int startIndex, int endIndex)
    {
        if (startIndex >= endIndex - 1) // Если стартовый индекс дошел до конца
        {
            return buffer1;             // Возвращаем результат
        }

        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;  //Находим индекс середины
        Student[] sorted1 = mergesortInnerByScores(buffer1, buffer2, startIndex, middle);
        //Инициализируем массив результатом метода сортировки от начала до середины
        Student[] sorted2 = mergesortInnerByScores(buffer1, buffer2, middle, endIndex);
        // Иницилизируем массив результатов метода сортировки от середины до конца

        // Слияние
        int index1 = startIndex; // Инициализируем стартовый индекс
        int index2 = middle;     // Инициализируем индекс середины
        int destIndex = startIndex; // Инициализируем дополнительный индекс
        Student[] result = sorted1 == buffer1 ? buffer2 : buffer1; //Инициализируем массив результата
        while (index1 < middle && index2 < endIndex) //Пока выполняется условие заполняем результат
        {
            result[destIndex++] = sorted1[index1].getScores() < sorted2[index2].getScores() ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) // Пока стартовый индекс меньше индекса середины
        {
            result[destIndex++] = sorted1[index1++]; // Присваиваем результату результат метода сортировки
            //от начала до серединного индекса
        }
        while (index2 < endIndex)
        {
            result[destIndex++] = sorted2[index2++]; // Присваиваем результату результат метода сортировки
            // от серединного индекса до конца
        }
        return result;      //Возвращаем результат
    } // Помощник сортировки слиянием по очкам
    public static void mergesortByGroup(Student[] LastStudents)    // Главный метод сортировки слиянием по группам
    {
        Student[] buffer1 = LastStudents;   //Создаем копию массива для последующей сортировки
        Student[] buffer2 = new Student[LastStudents.length]; //Создаем пустой массив, длина которого равна количеству студентов
        Student[] result = mergesortInnerByGroup(buffer1, buffer2, 0, LastStudents.length);
    } // Помощник сортировки слиянием по группам
    public static Student[] mergesortInnerByGroup(Student[] buffer1, Student[] buffer2, int startIndex, int endIndex)
    {
        if (startIndex >= endIndex - 1) // Если стартовый индекс дошел до конца
        {
            return buffer1;             // Возвращаем результат
        }

        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;  //Находим индекс середины
        Student[] sorted1 = mergesortInnerByGroup(buffer1, buffer2, startIndex, middle);
        //Инициализируем массив результатом метода сортировки от начала до середины
        Student[] sorted2 = mergesortInnerByGroup(buffer1, buffer2, middle, endIndex);
        // Иницилизируем массив результатов метода сортировки от середины до конца

        // Слияние
        int index1 = startIndex; // Инициализируем стартовый индекс
        int index2 = middle;     // Инициализируем индекс середины
        int destIndex = startIndex; // Инициализируем дополнительный индекс
        Student[] result = sorted1 == buffer1 ? buffer2 : buffer1; //Инициализируем массив результата
        while (index1 < middle && index2 < endIndex) //Пока выполняется условие заполняем результат
        {
            result[destIndex++] = sorted1[index1].getGroup() < sorted2[index2].getGroup() ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) // Пока стартовый индекс меньше индекса середины
        {
            result[destIndex++] = sorted1[index1++]; // Присваиваем результату результат метода сортировки
            //от начала до серединного индекса
        }
        while (index2 < endIndex)
        {
            result[destIndex++] = sorted2[index2++]; // Присваиваем результату результат метода сортировки
            // от серединного индекса до конца
        }
        return result;      //Возвращаем результат
    }
    public static void combineArrays(Student[] objects, Student[] objectsTwo) // Метод для объединения двух групп студентов
    {
        LastStudents = new Student[objects.length + objectsTwo.length];
        for(int i = 0 ; i < LastStudents.length; i++) //Цикл для заполнения массива студентов
        {
            if (i < objects.length)
            {
                LastStudents[i] = objects[i];
            }
            else
            {
                LastStudents[i] = objectsTwo[i- objects.length];
            }
        }

    }
    ////

    //// Quick Sort by Scores and Group
    public static void QuickSortByScores(Student[] objects, int begin, int end) // Быстрая сортировка по баллам
    {
        if (begin < end)
        {
            int partitionIndex = ByScores(objects, begin, end);

            QuickSortByScores(objects, begin, partitionIndex-1);
            QuickSortByScores(objects, partitionIndex+1, end);
        }
    }

    public static void QuickSortByGroup(Student[] objects, int begin, int end) // Быстрая сортировка по группам
    {
        if (begin < end)
        {
            int partitionIndex = ByGroup(objects, begin, end);

            QuickSortByGroup(objects, begin, partitionIndex-1);
            QuickSortByGroup(objects, partitionIndex+1, end);
        }
    }

    private static int ByGroup(Student[] objects, int begin, int end) {
        int pivot = objects[objects.length-1].getGroup();
        int i = (begin-1);

        for (int j = begin; j < end; j++)
        {
            if (objects[j].getGroup() <= pivot)
            {
                i++;
                Student swapTemp=objects[i];
                objects[i]=objects[j];
                objects[j]=swapTemp;
            }
        }
        Student swapTemp = objects[i+1];
        objects[i+1]=objects[objects.length-1];
        objects[objects.length-1]=swapTemp;

        return i+1;
    }  // Помощник сортировки по группам
    private static int ByScores(Student[] objects, int begin, int end) {
        int pivot = objects[objects.length-1].getScores();
        int i = (begin-1);

        for (int j = begin; j < end; j++)
        {
            if (objects[j].getScores() <= pivot)
            {
                i++;
                Student swapTemp=objects[i];
                objects[i]=objects[j];
                objects[j]=swapTemp;
            }
        }
        Student swapTemp = objects[i+1];
        objects[i+1]=objects[objects.length-1];
        objects[objects.length-1]=swapTemp;

        return i+1;
    } // Помощник сортировки по баллам
    //
    public static void setArray(Student[] objects) // Метод для заполения информации о студентах
    {
        for(int i = 0; i < objects.length; i++)
        {
            System.out.print((i+1)+": ");
            objects[i]=new Student(in.next(),in.next(), in.next(),in.nextInt(), in.nextInt(),in.nextInt());
        }
    }

    public static void outArray(Student[] objects) // Метод для вывода отсортированных студентов
    {
        for(int i = 0;i < objects.length; i++)
        {
            System.out.println((i+1)+") "+objects[i].toString());
        }
    }
    public SortingStudentsByGPA(String Name, String Surname, String Profession, int Kurs, int Group,int Scores)
    {
        super(Name, Surname, Profession, Kurs, Group, Scores);
    } // Конструктор

    @Override
    public int compareTo(@NotNull Object o)
    {
        return 0;
    }

    public static void main(String[] args)
    {
        System.out.println("Введите, какую сортировку вы хотите использовать: 'Быстрая' или 'Слияние'");
        String Choice = in.next();
        if(Choice.equals("Быстрая"))
        {
            System.out.println("Введите номер студента");
            objects = new Student[in.nextInt()];
            System.out.println("Введите Имя,Фамилия,Специальность,Курс,Группа,Оценка студента:");
            setArray(objects);
            System.out.println("Введите 'Оценка', если нужна сортировка по оценкам. Введите 'Группа', если нужна сортировка по группам:");
            String choice = in.next();
            if (choice.equals("Группа")) {
                QuickSortByGroup(objects, 0, objects.length - 1);
            } else {
                QuickSortByScores(objects, 0, objects.length - 1);
            }
            outArray(objects);
        }
        if(Choice.equals("Слияние"))
        {
            System.out.println("Введите количество студентов из первого списка");
            objects = new Student[in.nextInt()];
            System.out.println("Введите Имя,Фамилия,Специальность,Курс,Группа,Оценка студента:");
            setArray(objects);
            System.out.println("Введите номер студента из первого списка:");
            objectsTwo = new Student[in.nextInt()];
            System.out.println("Введите Имя,Фамилия,Специальность,Курс,Группа,Оценка студента:");
            setArray(objectsTwo);
            combineArrays(objects,objectsTwo);
            System.out.println("Введите 'Оценка', если нужна сортировка по оценкам. Введите 'Группа', если нужна сортировка по группам:");
            String choice = in.next();
            if (choice.equals("Группа")) {
                mergesortByGroup(LastStudents);
            } else {
                mergesortByScores(LastStudents);
            }
            outArray(LastStudents);
        }
    }
}
