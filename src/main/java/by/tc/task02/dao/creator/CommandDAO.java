package by.tc.task02.dao.creator;

import by.tc.task02.entity.SportEquipment;

import java.util.Map;

/**
 * Created by Дима on 30.01.2018.
 */
public interface CommandDAO {

    SportEquipment execute (Map<String, Object> mapFromDB);
}
