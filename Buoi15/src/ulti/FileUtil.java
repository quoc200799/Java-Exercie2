package ulti;

import entity.Staff;

import java.io.*;
import java.util.List;

public class FileUtil {
    public static Object[] readDataFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Object[]) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
        return null;
    }

    public static List readDataFromFileVer2(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
        return null;
    }

    public static void writeDateToFile(List data, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
