package by.tc.task02.main;

import by.tc.task02.entity.SportEquipment;
import by.tc.task02.entity.criteria.Criteria;
import by.tc.task02.entity.criteria.SearchCriteria.*;
import by.tc.task02.service.ServiceFactory;
import by.tc.task02.service.SportEquipmentService;

/**
 * Created by Дима on 30.01.2018.
 */
public class Main {

    public static void main(String[] args) {
        SportEquipment sportEquipment;
        ServiceFactory factory = ServiceFactory.getInstance();
        SportEquipmentService service = factory.getSportEquipmentService();

        //инициализация магазина
        service.shopInitialization();

        //возврат из аренды
        service.returnRentUnits();
        service.shopInitialization();



       //////////////////////////////////////////////////////////////////
//        Criteria<Ball> criteriaBall = new Criteria<Ball>();
//
//		criteriaBall.setSportEquipmentType("Ball");
//		criteriaBall.add(Ball.PRICE, 20);
//
//		sportEquipment = service.find(criteriaBall);
//		PrintSportEquipmentInfo.printInfoAboutSoughtForGood(sportEquipment);
//
//        //////////////////////////////////////////////////////////////////
//
//        Criteria<Jersey> criteriaJersey = new Criteria<Jersey>();
//
//        criteriaJersey.setSportEquipmentType("Jersey");
//        criteriaJersey.add(Jersey.TEAM, "kings");
//        criteriaJersey.add(Jersey.PRICE, 100);
//
//        sportEquipment = service.find(criteriaJersey);
//        PrintSportEquipmentInfo.printInfoAboutSoughtForGood(sportEquipment);
//
//        //////////////////////////////////////////////////////////////////
//
//        Criteria<Shoes> criteriaShoes = new Criteria<Shoes>();
//
//        criteriaShoes.setSportEquipmentType("Shoes");
//        criteriaShoes.add(Shoes.COLOR, "red");
//        criteriaShoes.add(Shoes.PRICE, 100);
//
//        sportEquipment = service.find(criteriaShoes);
//        PrintSportEquipmentInfo.printInfoAboutSoughtForGood(sportEquipment);

        //////////////////////////////////////////////////////////////////


        //оформление заказа
//        service.doOrder();
        PrintSportEquipmentInfo.printAvailableGoods();

    }
}
