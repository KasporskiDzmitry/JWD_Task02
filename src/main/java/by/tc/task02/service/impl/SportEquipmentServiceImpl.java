package by.tc.task02.service.impl;

import by.tc.task02.dao.DAOFactory;
import by.tc.task02.dao.SportEquipmentDAO;
import by.tc.task02.dao.exception.DAOException;
import by.tc.task02.entity.RentUnit;
import by.tc.task02.entity.Shop;
import by.tc.task02.entity.SportEquipment;
import by.tc.task02.entity.criteria.Criteria;
import by.tc.task02.entity.criteria.SearchCriteriaByValue;
import by.tc.task02.service.SportEquipmentService;
import by.tc.task02.service.validation.Validator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Дима on 30.01.2018.
 */
public class SportEquipmentServiceImpl implements SportEquipmentService {

    public void shopInitialization() {

        DAOFactory factory = DAOFactory.getInstance();
        SportEquipmentDAO sportEquipmentDAO = factory.getSportEquipmentDAO();

        try {
            Shop.getInstance().setGoodsMap(sportEquipmentDAO.shopInitialization());
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public SportEquipment find(Criteria criteria) {

        if (!Validator.criteriaValidator(criteria)) {
            return null;
        }

        Map<String, List<SportEquipment>> goodsMap = new HashMap<>();
        List<SportEquipment> goodsList = new ArrayList<>();
        List<SportEquipment> rentUnits = new ArrayList<>();

        goodsMap = Shop.getInstance().getGoodsMap();
        goodsList = goodsMap.get(criteria.getSportEquipmentType());

        for (SportEquipment good : goodsList) {
            if (compareTwoMaps(criteria, good.entityFields())) {
                rentUnits.add(good);
                RentUnit.getInstance().setUnits(rentUnits);
                goodsList.remove(good);
                return good;
            } else {
                continue;
            }
        }
        return null;
    }



    public <E> boolean compareTwoMaps(Criteria<E> criteria, Map<String, Object> entityFieldsMap) {
        int numberOfMatches = 0;

        for (Map.Entry<E, Object> pair : criteria.getCriteria().entrySet()) {
            String parameterFromCriteria = String.valueOf(pair.getKey()).toLowerCase();
            Object parameterValueFromCriteria = pair.getValue();
            if (SearchCriteriaByValue.numberCriteria.contains(parameterFromCriteria.toUpperCase())) {
                if (Double.parseDouble(String.valueOf(parameterValueFromCriteria)) == Double.parseDouble(String.valueOf(entityFieldsMap.get(parameterFromCriteria)))) {
                    numberOfMatches++;
                }
            } else if (String.valueOf(parameterValueFromCriteria).equalsIgnoreCase(String.valueOf(entityFieldsMap.get(parameterFromCriteria)))) {
                numberOfMatches++;
            }
        }
        if (numberOfMatches == criteria.getCriteria().size()) {
            return true;
        } else {
            return false;
        }
    }


    public void writeRentUnits(List<SportEquipment> unitList) {
        DAOFactory factory = DAOFactory.getInstance();
        SportEquipmentDAO sportEquipmentDAO = factory.getSportEquipmentDAO();

        try {
            sportEquipmentDAO.unitWriter(unitList);
        } catch (DAOException e) {
            System.out.println(e.getMessage());
        }
    }
}
