import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            for (;;){
                Scanner line = new Scanner(System.in);
                System.out.println("Откуда скопировать");
                String sourcePath = line.nextLine();
                System.out.println("Куда скопировать");
                String destPath = line.nextLine();

                System.out.println("Копирование началось");
                File source = new File(sourcePath);
                File dest = new File(destPath);
                copyFolder(source, dest);
                System.out.println("Копирование закончилось");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

    public static void copyFolder(File sourceFile, File destFile) {

        if (sourceFile.isDirectory()) {
            destFile.mkdir();
            System.out.println("Создание директории - " + destFile.getAbsolutePath());
            String[] files = sourceFile.list();

            for (String file : files) {
                File srcFile = new File(sourceFile, file);
                File dstFile = new File(destFile, file);
                copyFolder(srcFile, dstFile);
            }

        } else {
            try {

                System.out.println("Копирование файла - " + sourceFile.getAbsolutePath() + " в " + destFile.getAbsolutePath());

                FileInputStream is = new FileInputStream(sourceFile);
                FileOutputStream os = new FileOutputStream(destFile);
                try {
                    byte[] buffer = new byte[1024];
                    int length;

                    while ((length = is.read(buffer)) > 0) {
                        os.write(buffer, 0, length);
                    }
                } finally {
                    is.close();
                    os.close();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
