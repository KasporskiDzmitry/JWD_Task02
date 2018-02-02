package by.tc.task02.dao.util;

import by.tc.task02.dao.creator.CommandDAO;
import by.tc.task02.dao.creator.SportEquipmentDAODirector;
import by.tc.task02.dao.exception.DAOException;
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


    public Map<String, List<SportEquipment>> readFile() throws DAOException {
        File file = new File(".\\src\\main\\resources\\sport_equipments_db.txt");
        LineParser lineParser = new LineParser();
        Map<String, Object> mapFromDB;
        String str = "";
        Map<String, List<SportEquipment>> goodsMap = new HashMap<>();
        List<SportEquipment> goodsList = new ArrayList<>();

        SportEquipmentDAODirector sportEquipmentDAODirector = new SportEquipmentDAODirector();

        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            while (str != null) {
                str = br.readLine();
                try {
                    if (!str.isEmpty()) {
                        mapFromDB = lineParser.parseLine(str);
                        CommandDAO commandDAO = sportEquipmentDAODirector.getCommand(lineParser.typeIdentification(str));
                        goodsList.add(commandDAO.execute(mapFromDB));
                    } else {
                        goodsMap.put(goodsList.get(0).getClass().getSimpleName(), goodsList);
                        goodsList = new ArrayList<>();
                    }
                } catch (NullPointerException e) {
                    goodsMap.put(goodsList.get(0).getClass().getSimpleName(), goodsList);
                }
            }
            return goodsMap;
        } catch (FileNotFoundException e) {
            throw new DAOException("Файл не найден");
        } catch (IOException e) {
            throw new DAOException("Ошибка при работе с файлом");
        }
    }
}
