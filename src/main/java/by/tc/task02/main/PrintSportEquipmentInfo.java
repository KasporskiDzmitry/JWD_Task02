package by.tc.task02.main;

import by.tc.task02.entity.RentUnit;
import by.tc.task02.entity.Shop;
import by.tc.task02.entity.SportEquipment;

/**
 * Created by Дима on 31.01.2018.
 */
public class PrintSportEquipmentInfo {

    public static void print(SportEquipment sportEquipment) {


        if (sportEquipment != null) {
            System.out.println(sportEquipment.toString());
            System.out.println("[Аренда ]" + RentUnit.getInstance().getUnits());
        } else {
            System.out.println("Ничего не нашлось");
        }
    }
}
