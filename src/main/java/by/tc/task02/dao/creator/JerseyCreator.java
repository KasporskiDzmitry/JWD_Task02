package by.tc.task02.dao.creator;

import by.tc.task02.entity.Jersey;
import by.tc.task02.entity.SportEquipment;

import java.util.Map;

/**
 * Created by Дима on 30.01.2018.
 */
public class JerseyCreator implements CommandDAO {

    private static JerseyCreator instance = new JerseyCreator();

    public static JerseyCreator getInstance() {
        return instance;
    }

    @Override
    public SportEquipment execute (Map<String, Object> mapFromDB) {
        Jersey jersey = new Jersey();

        jersey.setLeague(String.valueOf(mapFromDB.get("LEAGUE")));
        jersey.setSize(String.valueOf(mapFromDB.get("SIZE")));
        jersey.setMaterial(String.valueOf(mapFromDB.get("MATERIAL")));
        jersey.setTeam(String.valueOf(mapFromDB.get("TEAM")));
        jersey.setPrice(Double.parseDouble(String.valueOf(mapFromDB.get("PRICE"))));

        return jersey;
    }
}
