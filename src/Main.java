import classes.Exam;
import classes.Test;
import csv.CSVReader;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main implements Serializable {

    // C:\Study\Java\java-basic-oop\src\csv\data.csv
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        PrintWriter log = new PrintWriter("logs.txt");
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss.SSS");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter path to csv file:");
        String path = br.readLine();

        File file = new File(path);

        // Проверка на существование csv файла

        if(file.exists() && !file.isDirectory()) {
            log.println(dateFormat.format(new Date()) + ": Переданный файл" + path + "\n");

            ArrayList<String[]> records = CSVReader.readCSV(file);

            System.out.println("File is exists \n");

            // Создание объектов Exam и Test, добавление в массив для сериализации

            int row_count = 0;

            Object[] arr = new Object[records.size()];

            for(String[] row : records)
            {
                switch (row[0]) {
                    case ("exam") -> {
                        Exam exam = new Exam(row[1], row[2], Integer.parseInt(row[3]), Integer.parseInt(row[4]), row[5], row[6], Integer.parseInt(row[7]));
                        arr[row_count] = exam;
                        log.println(dateFormat.format(new Date()) + ": Создание объекта Exam" + "\n" + exam.writeData() + "\n");
                    }
                    case ("test") -> {
                        Test test = new Test(row[1], row[2], Integer.parseInt(row[3]), Integer.parseInt(row[4]), row[5], row[6], Integer.parseInt(row[7]));
                        arr[row_count] = test;
                        log.println(dateFormat.format(new Date()) + ": Создание объекта Test" + "\n" + test.writeData() + "\n");
                    }
                    default -> {
                        log.println("\n" + dateFormat.format(new Date()) + ": Ошибка создания объекта, переданы неверные данные в строке " + row_count + "\n");
                        throw new IOException("Error! Data has error in row: " + row_count);
                    }
                }

                row_count += 1;
            }

            System.out.println("Before Serialization/Deserialization \n");

            log.println(dateFormat.format(new Date()) + ": Начало сериализации" + "\n");

            for(Object data : arr)
            {
                if (data instanceof Exam) {
                    System.out.println(((Exam) data).writeData());
                } else if (data instanceof Test) {
                    System.out.println(((Test) data).writeData());
                } else {
                    throw new InvalidClassException("Error! Object class is not defined!");
                }
                System.out.print("\n");
            }

            // Сериализация массива объектов

            FileOutputStream outputStream = new FileOutputStream(".\\save.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(arr);

            objectOutputStream.close();

            log.println(dateFormat.format(new Date()) + ": Сериализация законченна" + "\n");

            // Десериализация массива объектов

            log.println(dateFormat.format(new Date()) + ": Начало десериализации" + "\n");

            FileInputStream fileInputStream = new FileInputStream(".\\save.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object[] deserialized_arr = (Object[]) objectInputStream.readObject();

            // Вывод десериализованных данных

            System.out.println("After Serialization/Deserialization \n");

            log.println(dateFormat.format(new Date()) + ": Десериализация законченна" + "\n");

            for(Object data : deserialized_arr)
            {
                if (data instanceof Exam) {
                    System.out.println(((Exam) data).writeData());
                    log.println(dateFormat.format(new Date()) + ": Десериализованный объект Exam" + ((Exam) data).writeData() + "\n");
                } else if (data instanceof Test) {
                    System.out.println(((Test) data).writeData());
                    log.println(dateFormat.format(new Date()) + ": Десериализованный объект Test" + ((Test) data).writeData() + "\n");
                } else {
                    throw new InvalidClassException("Error! Object class is not defined!");
                }
                System.out.print("\n");
            }

            log.close();

        } else {
            throw new IOException("File is not exist");
        }
    }
}