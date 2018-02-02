package by.tc.task02.entity;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Дима on 31.01.2018.
 */
public final class Shop {
    private static final Shop instance = new Shop();

    private Map<String, List<SportEquipment>> goodsMap = new HashMap<>();

    private Shop(){}

    public static Shop getInstance() {
        return instance;
    }

    public Map<String, List<SportEquipment>> getGoodsMap() {
        return goodsMap;
    }

    public void setGoodsMap(Map<String, List<SportEquipment>> goodsMap) {
        this.goodsMap = goodsMap;
    }
}
