package by.tc.task02.service;

import by.tc.task02.entity.SportEquipment;
import by.tc.task02.entity.criteria.Criteria;

import java.util.List;

/**
 * Created by Дима on 30.01.2018.
 */
public interface SportEquipmentService {

    void shopInitialization();
    SportEquipment find(Criteria criteria);
    void writeRentUnits(List<SportEquipment> list);
}
