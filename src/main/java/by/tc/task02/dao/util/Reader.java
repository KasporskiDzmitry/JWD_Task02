package by.tc.task02.dao.util;

import by.tc.task02.dao.creator.CommandDAO;
import by.tc.task02.dao.creator.SportEquipmentDAODirector;
import by.tc.task02.dao.exception.DAOException;
import by.tc.task02.dao.util.serialization_util.SerialFile;
import by.tc.task02.dao.util.serialization_util.SerialReader;
import by.tc.task02.entity.SportEquipment;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Дима on 30.01.2018.
 */
public class Reader {

    private String lastReadedType;

    //считывание исходного файла
    public Map<String, List<SportEquipment>> readFile() throws DAOException {
        File file = new File(".\\src\\main\\resources\\sport_equipments_db.txt");
        LineParser lineParser = new LineParser();
        Map<String, Object> mapFromDB;
        String str = "";
        Map<String, List<SportEquipment>> goodsMap = new HashMap<>();
        List<SportEquipment> goodsList = new ArrayList<>();

        CommandDAO commandDAO;
        SportEquipmentDAODirector sportEquipmentDAODirector = new SportEquipmentDAODirector();

        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            while (str != null) {
                str = br.readLine();
                try {
                    if (!str.isEmpty()) {
                        mapFromDB = lineParser.parseLine(str);
                        lastReadedType = lineParser.typeIdentification(str);
                        commandDAO = sportEquipmentDAODirector.getCommand(lastReadedType);
                        goodsList.add(commandDAO.execute(mapFromDB));
                        goodsMap.put(lastReadedType, goodsList);
                    }
                    else if (str.isEmpty()) {
                        goodsMap.put(lastReadedType, goodsList);
                        goodsList = new ArrayList<>();
                    }
                } catch (NullPointerException e) {
                    goodsMap.put(lastReadedType, goodsList);
                }
            }
            return goodsMap;
        } catch (FileNotFoundException e) {
            throw new DAOException("Файл 'sport_equipments_db' не найден");
        } catch (IOException e) {
            throw new DAOException("Ошибка при работе с файлом 'sport_equipments_db'");
        }
    }


    //десериализация арендованных товаров
    public List readRents() throws DAOException {
        List rentUnit = new ArrayList();

        try (SerialReader in = new SerialReader(SerialFile.fileRent)) {
            rentUnit = (ArrayList) in.readObject();
            return rentUnit;
        } catch (FileNotFoundException e) {
            throw new DAOException("Файл 'rent_units' не найден");
        } catch (EOFException e) {
            return rentUnit;
        } catch (IOException e) {
            throw new DAOException("Ошибка при работе с файлом 'rent_units'");
        } catch (ClassNotFoundException e) {
            throw new DAOException("Несуществующий класс");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
