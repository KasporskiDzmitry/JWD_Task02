package by.tc.task02.service.util;

import by.tc.task02.entity.criteria.Criteria;
import by.tc.task02.entity.criteria.SearchCriteriaByValue;

import java.util.Map;

/**
 * Created by Дима on 03.02.2018.
 */
public class MapsComparator {

    public static <E> boolean compareTwoMaps(Criteria<E> criteria, Map<String, Object> entityFieldsMap) {
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
}
