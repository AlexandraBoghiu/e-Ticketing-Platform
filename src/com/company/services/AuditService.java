package com.company.services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AuditService {
    public AuditService() {
    }

    public void writeToAudit(String write) throws IOException {
            File yourFile = new File("src\\com\\company\\csv\\audit.csv");
            yourFile.createNewFile();

            try (FileWriter writer = new FileWriter("src\\com\\company\\csv\\audit.csv", true)) {
                writer.append(write);
                writer.append(";");
                writer.append(System.lineSeparator());
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Something didn't work while writing to Audit.");
            }


    }
}
