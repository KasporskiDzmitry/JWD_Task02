package by.tc.task02.service.impl;

import by.tc.task02.dao.DAOFactory;
import by.tc.task02.dao.SportEquipmentDAO;
import by.tc.task02.dao.exception.DAOException;
import by.tc.task02.entity.RentUnit;
import by.tc.task02.entity.Shop;
import by.tc.task02.entity.SportEquipment;
import by.tc.task02.entity.criteria.Criteria;
import by.tc.task02.main.PrintSportEquipmentInfo;
import by.tc.task02.service.SportEquipmentService;
import by.tc.task02.service.exception.ServiceException;
import by.tc.task02.service.util.MapsComparator;
import by.tc.task02.service.validation.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Дима on 30.01.2018.
 */
public class SportEquipmentServiceImpl implements SportEquipmentService {

    //инициализация магазина (Shop)
    public void shopInitialization() {
        DAOFactory factory = DAOFactory.getInstance();
        SportEquipmentDAO sportEquipmentDAO = factory.getSportEquipmentDAO();
        try {
            Shop.getInstance().setGoodsMap(sportEquipmentDAO.shopInitialization());
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
    }


    //поиск товара в магазине
    @Override
    public SportEquipment find(Criteria criteria) {
        Map<String, List<SportEquipment>> goodsMap = new HashMap<>();
        List<SportEquipment> goodsList = new ArrayList<>();

        try {
            Validator.criteriaValidator(criteria);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
            return null;
        }

        goodsMap = Shop.getInstance().getGoodsMap();
        goodsList = goodsMap.get(criteria.getSportEquipmentType());

        if (goodsList != null) {
            for (SportEquipment good : goodsList) {
                if (MapsComparator.compareTwoMaps(criteria, good.entityParameters())) {
                    goodsList.remove(good);
                    RentUnit.getInstance().getUnits().add(good);
                    return good;
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public void writeRentUnitsInFile(List<SportEquipment> unitList) {
        DAOFactory factory = DAOFactory.getInstance();
        SportEquipmentDAO sportEquipmentDAO = factory.getSportEquipmentDAO();
        try {
            sportEquipmentDAO.writeRentsInFile(unitList);
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List readRentUnits() {
        DAOFactory factory = DAOFactory.getInstance();
        SportEquipmentDAO sportEquipmentDAO = factory.getSportEquipmentDAO();
        try {
            return sportEquipmentDAO.readRentsFromFile();
        } catch (DAOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public void reWriteFile(Map<String, List<SportEquipment>> goodsMap) {
        DAOFactory factory = DAOFactory.getInstance();
        SportEquipmentDAO sportEquipmentDAO = factory.getSportEquipmentDAO();

        try {
            sportEquipmentDAO.reWriteFile(goodsMap);
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void doOrder() {
        DAOFactory factory = DAOFactory.getInstance();
        SportEquipmentDAO sportEquipmentDAO = factory.getSportEquipmentDAO();

        //перезапись файла
        reWriteFile(Shop.getInstance().getGoodsMap());

        try {
            if (RentUnit.getInstance().getUnits().size() > 3) {
                throw new ServiceException("Больше 3 товаров заказать нельзя!");
            } else {
                try {
                    RentUnit.getInstance().getUnits().addAll(sportEquipmentDAO.readRentsFromFile());
                } catch (DAOException e) {
                    System.out.println(e.getMessage());
                }
                writeRentUnitsInFile(RentUnit.getInstance().getUnits());
                PrintSportEquipmentInfo.printRentEquipmentInfo(RentUnit.getInstance().getUnits());
            }
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void returnRentUnits() {
        DAOFactory factory = DAOFactory.getInstance();
        SportEquipmentDAO sportEquipmentDAO = factory.getSportEquipmentDAO();
        try {
            sportEquipmentDAO.returnRentUnits();
            sportEquipmentDAO.reWriteFile(Shop.getInstance().getGoodsMap());
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
    }
}
