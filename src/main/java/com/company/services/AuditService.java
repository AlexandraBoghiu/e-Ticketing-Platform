package com.company.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class AuditService {
    private static AuditService instance = null;

    private AuditService() {

    }

    public static AuditService getInstance() throws IOException {
        if (instance != null) {
            return instance;
        }
        instance = new AuditService();
        File yourFile = new File("src\\main\\java\\com\\company\\resources\\audit.csv");
        if (yourFile.createNewFile()) {
            try (FileWriter writer = new FileWriter("src\\main\\java\\com\\company\\resources\\audit.csv", true)) {
                writer.append("Action");
                writer.append(",");
                writer.append("Time");
                writer.append(System.lineSeparator());
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Something didn't work while writing to Audit.");
            }
        }
        return instance;
    }

    public void writeToAudit(String write) throws IOException {

        try (FileWriter writer = new FileWriter("src\\main\\java\\com\\company\\resources\\audit.csv", true)) {
            writer.append(write);
            writer.append(",");
            writer.append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")).toString());
            writer.append(System.lineSeparator());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Something didn't work while writing to Audit.");
        }


    }
}
