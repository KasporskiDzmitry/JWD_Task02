package by.tc.task02.dao.impl;

import by.tc.task02.dao.util.Reader;
import by.tc.task02.dao.SportEquipmentDAO;
import by.tc.task02.dao.exception.DAOException;
import by.tc.task02.dao.util.Writer;
import by.tc.task02.entity.SportEquipment;
import by.tc.task02.entity.criteria.Criteria;

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
    public void unitWriter(List<SportEquipment> rentList) throws DAOException {
        Writer writer = new Writer();
        writer.writeInFile(rentList);
    }

}
