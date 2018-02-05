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

    public String goodsMapFileView() {
        String fullText = "";
        int count = 0;
        for (Map.Entry<String, List<SportEquipment>> entry : goodsMap.entrySet()) {
            count++;
            for (int i = 0; i < entry.getValue().size(); i++) {
                if (count == goodsMap.size() & i == entry.getValue().size()-1) {
                    fullText += entry.getValue().get(i);
                } else {
                    fullText += entry.getValue().get(i) + "\n";
                }
            }
            if (count != goodsMap.size()) {
                fullText = fullText + "\n";
            }
        }
        return fullText;
    }
}
