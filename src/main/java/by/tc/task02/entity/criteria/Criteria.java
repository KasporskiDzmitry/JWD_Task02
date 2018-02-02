package by.tc.task02.entity.criteria;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Дима on 30.01.2018.
 */
public class Criteria<E> {

    String sportEquipmentType;

    private Map<E, Object> criteria = new HashMap<E, Object>();

    public void add(E searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }

    public String getSportEquipmentType() {
        return sportEquipmentType;
    }

    public void setSportEquipmentType(String sportEquipmentType) {
        this.sportEquipmentType = sportEquipmentType;
    }

    public Map<E, Object> getCriteria() {
        return criteria;
    }
}
