package by.tc.task02.dao.creator;

import by.tc.task02.entity.Ball;
import by.tc.task02.entity.SportEquipment;

import java.util.Map;

/**
 * Created by Дима on 30.01.2018.
 */
public class BallCreator implements CommandDAO {

    private static BallCreator instance = new BallCreator();

    public static BallCreator getInstance() {
        return instance;
    }

    @Override
    public SportEquipment execute (Map<String, Object> mapFromDB) {
        Ball ball = new Ball();

        ball.setType(String.valueOf(mapFromDB.get("TYPE")));
        ball.setColor(String.valueOf(mapFromDB.get("COLOR")));
        ball.setMaterial(String.valueOf(mapFromDB.get("MATERIAL")));
        ball.setSize(Short.parseShort(String.valueOf(mapFromDB.get("SIZE"))));
        ball.setPrice(Double.parseDouble(String.valueOf(mapFromDB.get("PRICE"))));

        return ball;
    }
}
