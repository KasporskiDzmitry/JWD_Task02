package by.tc.task02.dao.impl;

import by.tc.task02.dao.util.LineParser;
import by.tc.task02.dao.util.Reader;
import by.tc.task02.dao.SportEquipmentDAO;
import by.tc.task02.dao.exception.DAOException;
import by.tc.task02.dao.util.Writer;
import by.tc.task02.entity.Shop;
import by.tc.task02.entity.SportEquipment;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Дима on 30.01.2018.
 */
public class SportEquipmentDAOImpl implements SportEquipmentDAO {

    @Override
    public Map<String, List<SportEquipment>> shopInitialization() throws DAOException {
        Reader reader = new Reader();
        return reader.readFile();
    }

    @Override
    public void writeRentsInFile(List<SportEquipment> rentList) throws DAOException {
        Writer writer = new Writer();
        writer.writeRents(rentList);
    }


    @Override
    public void reWriteFile(Map<String, List<SportEquipment>> goodsMap) throws DAOException {
        Writer writer = new Writer();;
        writer.reWrite(goodsMap);
    }

    //чтение арендованных объектов из файла
    @Override
    public List readRentsFromFile() throws DAOException {
        Reader reader = new Reader();
        return reader.readRents();
    }


    //возврат из аренды
    @Override
    public void returnRentUnits() throws DAOException {
        Reader reader = new Reader();
        LineParser lineParser = new LineParser();
        List<SportEquipment> rentsList = new ArrayList<>();
        rentsList = reader.readRents();
        for (int i = 0; i < rentsList.size(); i++) {
            if (rentsList.get(i) != null) {
                String type = lineParser.typeIdentification(rentsList.get(i).toString());
                if (Shop.getInstance().getGoodsMap().get(type) == null) {
                    Shop.getInstance().getGoodsMap().put(type, new ArrayList<SportEquipment>());
                }
                Shop.getInstance().getGoodsMap().get(type).add(rentsList.get(i));
            }
        }

        //очитска файла аренды
        try (FileWriter fileWriter = new FileWriter(".\\src\\main\\resources\\rent_units.txt")) {
            fileWriter.write("");
        } catch (FileNotFoundException e) {
            throw new DAOException("Файл не найден");
        } catch (IOException e) {
            throw new DAOException("Ошибка при работе с файлом");
        }
    }

}
