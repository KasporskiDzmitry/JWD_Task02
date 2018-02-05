package by.tc.task02.dao.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Дима on 30.01.2018.
 */
public class LineParser {

    public Map<String, Object> parseLine(String line) {

        String editedLine;
        String[] editedLineArrayView;
        String splitter = "=|\\,\\ ";
        ArrayList<String> parameters = new ArrayList<>();
        ArrayList<Object> valuesOfParameters = new ArrayList<>();
        Map<String, Object> mapFromDB = new HashMap<>();


        editedLine = line.substring(typeIdentification(line).length() + 3, line.length() - 1);
        editedLineArrayView = editedLine.split(splitter);
        for (int i = 0; i < editedLineArrayView.length; i++) {
            if (i % 2 == 0) {
                parameters.add(editedLineArrayView[i]);
            } else {
                valuesOfParameters.add(editedLineArrayView[i]);
            }
        }
        for (int j = 0; j < parameters.size(); j++) {
            mapFromDB.put(parameters.get(j), valuesOfParameters.get(j));
        }
        parameters.clear();
        valuesOfParameters.clear();
        return mapFromDB;
    }

    public String typeIdentification(String line) {

        String objectType = "";

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                break;
            } else {
                objectType += line.charAt(i);
            }
        }
        return objectType;
    }
}
