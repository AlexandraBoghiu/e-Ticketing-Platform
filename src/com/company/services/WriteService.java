package com.company.services;

import java.io.*;
import java.util.List;


public class WriteService<T> {

    public WriteService() {
    }

    public void writeToCsvFile(List<T[]> write, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            for (T[] strings : write) {
                for (int i = 0; i < strings.length; i++) {
                    writer.append((CharSequence) strings[i]);
                    if (i < (strings.length - 1))
                        writer.append(",");
                }
                writer.append(System.lineSeparator());
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            System.out.println("Something didn't work while writing to the cvs file.");
        }
    }
}
