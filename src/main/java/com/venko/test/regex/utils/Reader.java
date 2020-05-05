package com.venko.test.regex.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Reader {


    public static String textReader (String fileName){
        StringBuilder result = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            stream.forEach((resultado)-> result.append(resultado));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    /***
     *
     * @param linetoWrite  cadena de texto a guardar
     * @param fileName nombre del archivo de guardado
     * @throws IOException
     */
    public static void textWriter(String linetoWrite, String fileName) throws  IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.append(linetoWrite);
        writer.append("\n");
        writer.close();
    }


}
