package by.tc.task02.service;

import by.tc.task02.entity.SportEquipment;
import by.tc.task02.entity.criteria.Criteria;

import java.util.List;
import java.util.Map;

/**
 * Created by Дима on 30.01.2018.
 */
public interface SportEquipmentService {

    void shopInitialization();
    SportEquipment find(Criteria criteria);
    void writeRentUnitsInFile(List<SportEquipment> goodsListByType);
    List readRentUnits();
    void reWriteFile(Map<String, List<SportEquipment>> goodsMap);
    void doOrder();
    void returnRentUnits();
}
