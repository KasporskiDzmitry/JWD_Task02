package by.tc.task02.service.validation;

import by.tc.task02.entity.criteria.Criteria;
import by.tc.task02.entity.criteria.SearchCriteriaByValue;

import java.util.Map;

/**
 * Created by Дима on 30.01.2018.
 */
public class Validator {

    public static <E> boolean criteriaValidator(Criteria<E> criteria) {
        for (Map.Entry<E, Object> pair : criteria.getCriteria().entrySet()) {
            E key = pair.getKey();
            Object value = pair.getValue();

            if (SearchCriteriaByValue.numberCriteria.contains(key.toString())) {
                try {
                    Double.parseDouble(value.toString());
                } catch (NumberFormatException e) {
                    System.out.println("Неверное значение параметра " + key.toString() + ": " + value.toString());
                    return false;
                }
            }
        }
        return true;
    }
}
