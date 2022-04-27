package com.company.services;

import com.company.models.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WriteService<T> {
    private static WriteService instance = null;
    static ReadService<String> readService = ReadService.getInstance();

    private WriteService() {
    }

    public static WriteService getInstance() {
        if (instance == null) {
            instance = new WriteService();
        }
        return instance;
    }

    public void writeToCsvFile(List<String[]> write, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
            for (String[] strings : write) {
                for (int i = 0; i < strings.length; i++) {
                    writer.append(strings[i]);
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
            System.out.println("nope");
        }
    }
}
