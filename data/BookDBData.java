package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import domain.model.*;

public class BookDBData implements Data<Book>{
    private String filePath = "C:\\java\\Library-Proj_java_prof\\book.csv";

    @Override 
    public void save(List<Book> books) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            for (Book book : books) {
                bw.write(book.getId() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getPublisher() + "," + book.getPublicationDate() + "," + book.getRegistrationDate());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Book> load() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void backup() {
        // TODO Auto-generated method stub
        
    }

}