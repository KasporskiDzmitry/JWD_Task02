package by.tc.task02.dao.util.serialization_util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by Дима on 05.02.2018.
 */
public class SerialWriter implements AutoCloseable{

    private final FileOutputStream fileOutputStream;
    private final ObjectOutputStream objectOutputStream;

    public SerialWriter(File fileName) throws IOException {
        this.fileOutputStream = new FileOutputStream(fileName);
        this.objectOutputStream = new ObjectOutputStream(fileOutputStream);
    }

    public void writeObject(Object object) throws IOException {
        objectOutputStream.writeObject(object);
    }

    @Override
    public void close() throws Exception {
        objectOutputStream.close();
        fileOutputStream.close();
    }
}
