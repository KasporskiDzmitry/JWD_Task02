package by.tc.task02.dao.util;

import by.tc.task02.dao.exception.DAOException;
import by.tc.task02.entity.SportEquipment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Дима on 02.02.2018.
 */
public class Writer {

    public void writeInFile(List<SportEquipment> rentList) throws DAOException {

        List fileList = new ArrayList();

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(".\\src\\main\\resources\\rent_units.txt")))) {
            String line;
            try {
                while ((line = bf.readLine()) != null) {
                    fileList.add(line);
                }
            } catch (IOException e) {
                throw new DAOException("Ошибка при работе с файлом");
            }
        }catch (FileNotFoundException e) {
            throw new DAOException("Файл не найден");
        } catch (IOException e) {
            throw new DAOException("Ошибка при работе с файлом");
        }


        try (FileWriter fileWriter = new FileWriter(".\\src\\main\\resources\\rent_units.txt")){
            for (int i = 0; i < fileList.size(); i++) {
                fileWriter.write(fileList.get(i) + "\n");
            }
            for (int i = 0; i < rentList.size(); i++) {
                fileWriter.write(rentList.get(i) + "\n");
            }
        } catch (FileNotFoundException e) {
            throw new DAOException("Файл не найден");
        } catch (IOException e) {
            throw new DAOException("Ошибка при работе с файлом");
        }
    }
}
