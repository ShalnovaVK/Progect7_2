package com.example.progect7_2.Data.DataSourse.Files;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;

import androidx.core.content.ContextCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class ExternalStorageDirectory{

    private final String fileName;
    private final  Context context;
    private File file;

    public ExternalStorageDirectory(Context context, String fileName) {
        this.fileName = fileName;
        this.context = context;
    }

    public boolean writeContent(String inputContent) {
        if (!inputContent.isEmpty()) {
            String state = Environment.getExternalStorageState();
            if (Environment.MEDIA_MOUNTED.equals(state)) {
                if (checkPermission()) {
                    File sdcard = Environment.getExternalStorageDirectory();

                    if (file == null || !file.exists()) {
                        String dir = sdcard.getAbsolutePath() + "/MyFolder/";
                        file = new File(dir + fileName + ".txt");

                    }
                    FileOutputStream os = null;
                    try {
                        os = new FileOutputStream(file);
                        os.write(inputContent.getBytes());
                        os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    return false;
                }
            }
        }

        return true;
    }

    public String readFile() {
        if (file == null || !file.exists()) return null;
        FileInputStream fis = null;
        StringBuilder content = new StringBuilder(); // Создаем StringBuilder для хранения содержимого файла
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) { // Читаем строки до тех пор, пока не достигнем конца файла
                content.append(line).append("\n"); // Добавляем каждую строку к StringBuilder
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }


    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(context, android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }
}