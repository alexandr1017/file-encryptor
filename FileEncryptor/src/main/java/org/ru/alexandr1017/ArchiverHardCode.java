package org.ru.alexandr1017;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ArchiverHardCode {
    public static void main(String[] args) {

        String path = "C:/Users/alexa/OneDrive/Рабочий стол/";

        String in = path + "Квартира документы.zip";
        String out = path + "result/";
        try {

            //Creating archive
//            FileOutputStream outputStream = new FileOutputStream(out);
//            ZipOutputStream zipOut = new ZipOutputStream(outputStream);
//            writeFileToZip(new File(in), zipOut, "");
//            zipOut.flush();
//            zipOut.close();
//            outputStream.close();

            //Extracting archive
            FileInputStream inputStream = new FileInputStream(in);
            ZipInputStream zipInput = new ZipInputStream(inputStream);
            extractAllFromZip(inputStream, zipInput, out);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void extractAllFromZip(FileInputStream fos, ZipInputStream zis, String out) throws IOException {

        while (true) {
            ZipEntry entry = zis.getNextEntry();
            if (entry == null) {
                break;
            }

            File file = new File(out + entry.getName());
            if (entry.isDirectory()) {
                file.mkdirs();
            } else {
                byte[] bytes = zis.readAllBytes();
                Files.write(
                        Paths.get(file.getAbsolutePath()),
                        bytes,
                        StandardOpenOption.CREATE
                );
            }
        }
    }

    public static void writeFileToZip(File file, ZipOutputStream zipOut, String path) throws Exception {
        if (file.isDirectory()) {
            String folder = path + file.getName() + "/";
            ZipEntry entry = new ZipEntry(folder);
            zipOut.putNextEntry(entry);
            zipOut.closeEntry();
            File[] files = file.listFiles();
            for (File subfile : files) {
                writeFileToZip(subfile, zipOut, folder);
            }
            return;
        }

        ZipEntry entry = new ZipEntry(path + file.getName());
        zipOut.putNextEntry(entry);
        byte[] bytes =
                Files.readAllBytes(Paths.get(file.getAbsolutePath()));
        zipOut.write(bytes);
    }
}