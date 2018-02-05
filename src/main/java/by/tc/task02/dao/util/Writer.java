package by.tc.task02.dao.util;

import by.tc.task02.dao.exception.DAOException;
import by.tc.task02.dao.util.serialization_util.SerialFile;
import by.tc.task02.dao.util.serialization_util.SerialWriter;
import by.tc.task02.entity.Shop;
import by.tc.task02.entity.SportEquipment;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Дима on 02.02.2018.
 */
public class Writer {

    //сериализация арендованных объектов
    public void writeRents(List<SportEquipment> rentList) throws DAOException {
        try (SerialWriter out = new SerialWriter(SerialFile.fileRent);) {
            out.writeObject(rentList);
        } catch (FileNotFoundException e) {
            throw new DAOException("Файл 'rent_unit' не найден");
        } catch (IOException e) {
            throw new DAOException("Ошибка при работе с файлом 'rent_units'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //перезапись исходного файла (в конце работы программы для последующих запусков)
    public void reWrite(Map<String, List<SportEquipment>> goodsMap) throws DAOException {
        try (FileWriter fileWriter = new FileWriter(".\\src\\main\\resources\\sport_equipments_db.txt")) {
            fileWriter.write(Shop.getInstance().goodsMapFileView());
        } catch (FileNotFoundException e) {
            throw new DAOException("Файл 'sport_equipments_db' не найден");
        } catch (IOException e) {
            throw new DAOException("Ошибка при работе с файлом 'sport_equipments_db'");
        }
    }
}
