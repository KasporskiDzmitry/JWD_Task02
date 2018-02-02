package by.tc.task02.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Дима on 02.02.2018.
 */
public final class RentUnit {

    private static final RentUnit instance = new RentUnit();

    private RentUnit(){}

    private List<SportEquipment> units = new ArrayList<>();

    public static RentUnit getInstance() {
        return instance;
    }

    public List<SportEquipment> getUnits() {
        return units;
    }

    public void setUnits(List<SportEquipment> units) {
        this.units = units;
    }
}
