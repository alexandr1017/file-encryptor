package org.ru.alexandr1017;


import javax.swing.*;

public class Application {
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
