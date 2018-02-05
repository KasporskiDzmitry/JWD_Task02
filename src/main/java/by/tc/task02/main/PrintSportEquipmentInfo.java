package by.tc.task02.main;

import by.tc.task02.entity.Shop;
import by.tc.task02.entity.SportEquipment;

import java.util.List;

/**
 * Created by Дима on 31.01.2018.
 */
public class PrintSportEquipmentInfo {

    public static void printRentEquipmentInfo(List<SportEquipment> sportEquipmentList) {
        if (sportEquipmentList != null) {
            System.out.println("Объекты в аренде:");
            for (SportEquipment good : sportEquipmentList) {
                System.out.println(good);
            }
        } else {
            System.out.println("Ничего не нашлось");
        }
    }

    public static void printAvailableGoods() {
        System.out.println("Доступные товары:");
        System.out.print(Shop.getInstance().goodsMapFileView());
    }

    public static void printInfoAboutSoughtForGood (SportEquipment sportEquipment) {
        if (sportEquipment == null) {
            System.out.println("Объект не найден");
        } else {
            System.out.print("Объект найден : ");
            System.out.println(sportEquipment.toString());
        }
    }
}
