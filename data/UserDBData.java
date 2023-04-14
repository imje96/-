package data;

import java.io.*;
import java.util.*;
import domain.model.*;

public class UserDBData implements Data<User> {
    private String filePath = "C:\\java\\Library-Proj_java_prof\\memeber.csv";
    
    @Override 
    public void save(List<User> users) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            for (User user : users) {
                bw.write(user.getId() + "," + user.getName() + "," + user.getAge() + "," + user.getAddress() + "," + user.getNumber() + "," + user.getBirthDate() + "," + user.getJoinDate());
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<User> load() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void backup() {
        // TODO Auto-generated method stub
        
    }

}