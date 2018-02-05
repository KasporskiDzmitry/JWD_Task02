package by.tc.task02.dao;

import by.tc.task02.dao.exception.DAOException;
import by.tc.task02.entity.SportEquipment;

import java.util.List;
import java.util.Map;

/**
 * Created by Дима on 30.01.2018.
 */
public interface SportEquipmentDAO {

    Map<String, List<SportEquipment>> shopInitialization() throws DAOException;
    void writeRentsInFile(List<SportEquipment> rentList) throws DAOException;
    void reWriteFile(Map<String, List<SportEquipment>> goodsMap) throws DAOException;
    List readRentsFromFile() throws DAOException;
    void returnRentUnits() throws DAOException;
}
