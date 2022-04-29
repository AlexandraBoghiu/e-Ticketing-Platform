package com.company.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ReadService<T> {

    public ReadService() {
    }

    public List<T[]> read(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        List<T[]> data = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            T[] items = (T[]) (line.split(","));
            data.add(items);
        }

        scanner.close();
        return data;
    }

}
