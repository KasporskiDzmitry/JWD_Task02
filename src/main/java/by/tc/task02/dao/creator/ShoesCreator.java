package by.tc.task02.dao.creator;

import by.tc.task02.entity.Shoes;
import by.tc.task02.entity.SportEquipment;

import java.util.Map;

/**
 * Created by Дима on 30.01.2018.
 */
public class ShoesCreator implements CommandDAO {

    private static ShoesCreator instance = new ShoesCreator();

    public static ShoesCreator getInstance() {
        return instance;
    }

    @Override
    public SportEquipment execute (Map<String, Object> mapFromDB) {
        Shoes shoes = new Shoes();

        shoes.setType(String.valueOf(mapFromDB.get("TYPE")));
        shoes.setColor(String.valueOf(mapFromDB.get("COLOR")));
        shoes.setMaterial(String.valueOf(mapFromDB.get("MATERIAL")));
        shoes.setSize(Short.parseShort(String.valueOf(mapFromDB.get("SIZE"))));
        shoes.setPrice(Double.parseDouble(String.valueOf(mapFromDB.get("PRICE"))));

        return shoes;
    }
}
