package by.tc.task02.service;

import by.tc.task02.service.impl.SportEquipmentServiceImpl;

/**
 * Created by Дима on 30.01.2018.
 */
public class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final SportEquipmentService sportEquipmentService = new SportEquipmentServiceImpl();

    private ServiceFactory() {}

    public SportEquipmentService getSportEquipmentService() {
        return sportEquipmentService;
    }

    public static ServiceFactory getInstance() {
        return instance;
    }
}
