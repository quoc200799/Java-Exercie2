package filereader;

import java.io.*;
import java.util.List;

public class MyFileReader<E> {
    public List<E> readDataFromFile(String filePath) {
        if(filePath == null || filePath.trim().equals("")){
            return null;
        }
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<E>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
    public List<E> writeDataFromFile(List<E> list,String filePath){
        if(filePath == null || filePath.trim().equals("")){
            return null;
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}
