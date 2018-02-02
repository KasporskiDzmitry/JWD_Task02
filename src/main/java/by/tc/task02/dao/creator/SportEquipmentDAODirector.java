package by.tc.task02.dao.creator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Дима on 30.01.2018.
 */
public class SportEquipmentDAODirector {

    private Map<String, CommandDAO> commands = new HashMap<>();

    public SportEquipmentDAODirector(){
        commands.put("Ball", BallCreator.getInstance());
        commands.put("Shoes", ShoesCreator.getInstance());
        commands.put("Jersey", JerseyCreator.getInstance());
    }


    public CommandDAO getCommand(String sportEquipmentType) {
        CommandDAO commandDAO;
        commandDAO = commands.get(sportEquipmentType);
        return commandDAO;
    }
}
