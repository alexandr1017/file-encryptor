package org.ru.alexandr1017;


import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.File;

public class Archiver {
    public static void main(String[] args) {
        String path = "C:/Users/alexa/OneDrive/Рабочий стол/";

        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        zipParameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_ULTRA);
//        zipParameters.setEncryptFiles(true);
//        zipParameters.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
//        zipParameters.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
//        zipParameters.setPassword("123456");

        try {
            ZipFile zipFile = new ZipFile(path + "archive.zip");
            //zip
            zipFile.addFolder(new File(path + "Квартира документы"), zipParameters);
            //unzip
            if (zipFile.isEncrypted()) {
                zipFile.setPassword("123456");
            }
            zipFile.extractAll(path + "result/");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
