package by.tc.task02.dao.util.serialization_util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by Дима on 05.02.2018.
 */
public class SerialReader implements AutoCloseable{

    private final FileInputStream fileInputStream;
    private final ObjectInputStream objectInputStream;

    public SerialReader(File fileName) throws IOException {
        fileInputStream = new FileInputStream(fileName);
        objectInputStream = new ObjectInputStream(fileInputStream);
    }

    public Object readObject() throws IOException, ClassNotFoundException {
        return objectInputStream.readObject();
    }

    @Override
    public void close() throws Exception {
        objectInputStream.close();
        fileInputStream.close();
    }
}
