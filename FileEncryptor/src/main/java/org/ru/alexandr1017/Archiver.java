package org.ru.alexandr1017;


import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import javax.swing.*;
import java.io.File;

public class Archiver {
    public static void main(String[] args) {

        JFrame frame = new JFrame("File Encrypter - Шифровальщик файлов и папок");
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        GUIForm form = new GUIForm();
        frame.add(form.getRootPanel());
        frame.setVisible(true);


    }
}
