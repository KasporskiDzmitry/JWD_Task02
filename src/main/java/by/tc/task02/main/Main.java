package by.tc.task02.main;

import by.tc.task02.entity.RentUnit;
import by.tc.task02.entity.Shop;
import by.tc.task02.entity.SportEquipment;
import by.tc.task02.entity.criteria.Criteria;
import static by.tc.task02.entity.criteria.SearchCriteria.*;
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

        service.shopInitialization();

        //////////////////////////////////////////////////////////////////

        Criteria<Ball> criteriaBall = new Criteria<Ball>();

		criteriaBall.setSportEquipmentType("Ball");
		criteriaBall.add(Ball.PRICE, 50);

		sportEquipment = service.find(criteriaBall);

        service.writeRentUnits(RentUnit.getInstance().getUnits());

		PrintSportEquipmentInfo.print(sportEquipment);

        //////////////////////////////////////////////////////////////////

        Criteria<Jersey> criteriaJersey = new Criteria<Jersey>();

        criteriaJersey.setSportEquipmentType("Jersey");
        criteriaJersey.add(Jersey.TEAM, "kings");
        criteriaJersey.add(Jersey.PRICE, 100);

        sportEquipment = service.find(criteriaJersey);

        service.writeRentUnits(RentUnit.getInstance().getUnits());

        PrintSportEquipmentInfo.print(sportEquipment);
    }
}
