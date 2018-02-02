package by.tc.task02.dao;

import by.tc.task02.dao.impl.SportEquipmentDAOImpl;

/**
 * Created by Дима on 30.01.2018.
 */
public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final SportEquipmentDAO sportEquipmentDAO = new SportEquipmentDAOImpl();

    private DAOFactory() {}

    public SportEquipmentDAO getSportEquipmentDAO() {
        return sportEquipmentDAO;
    }

    public static DAOFactory getInstance() {
        return instance;
    }
}
