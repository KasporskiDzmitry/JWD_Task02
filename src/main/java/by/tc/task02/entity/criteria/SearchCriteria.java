package by.tc.task02.entity.criteria;

/**
 * Created by Дима on 30.01.2018.
 */
public final class SearchCriteria {

    public static enum Ball {
        TYPE, SIZE, COLOR, MATERIAL, PRICE
    }

    public static enum Shoes {
        TYPE, SIZE, COLOR, MATERIAL, PRICE
    }

    public static enum Jersey {
        LEAGUE, SIZE, TEAM, MATERIAL, PRICE
    }

    private SearchCriteria(){}
}
