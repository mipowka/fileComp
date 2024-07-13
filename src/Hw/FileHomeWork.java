package Hw;

import java.io.File;
import java.io.IOException;

/*
Задача на File

1. Написать метод, который принимает путь к файлу и выводит его название  и удаляет его
2. Создать новую директорию с заданным именем. Если директория уже существует, метод должен вывести ошибку.
3. Получить размер файла в байтах и мегабайтах.
 */
public class FileHomeWork {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Admin\\IdeaProjects\\mapTask\\src\\Hw\\file2.txt");
        file.createNewFile();
        deleteFile(file,file.getAbsolutePath());


        dirCreate("na1");



        getSize("C:\\Users\\Admin\\IdeaProjects\\mapTask\\src\\Hw\\file1");
        getSize("C:\\Users\\Admin\\IdeaProjects\\mapTask\\src\\Hw\\na");

    }

    public static void deleteFile(File file, String path) {
        if (file.getAbsolutePath().equals(path)) {
            System.out.println(file.getName());
            file.delete();
        }
    }

    public static void dirCreate(String nameOfDir){
        File dir = new File("C:\\Users\\Admin\\IdeaProjects\\mapTask\\src\\Hw");
        dir = new File(dir,nameOfDir);
        if (!dir.exists()) {
            dir.mkdir();
        }else {
            throw new RuntimeException("Такая директория уже создана");
        }
    }

    public static void getSize(String path){
        File file = new File(path);
        System.out.println(file.length() + " in bytes");
        System.out.println(file.length() / (1024*1024) + " MB");
    }
}
