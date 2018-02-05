package by.tc.task02.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Дима on 30.01.2018.
 */
public class Jersey implements Serializable, SportEquipment {

    private String league;
    private String size;
    private String team;
    private String material;
    private double price;

    private Map<String, Object> fields = new HashMap<>();

    public Jersey() {
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean equals(Object obj) {
        if(this == obj) {return true;}
        if(null == obj) {return false;}
        if(getClass() != obj.getClass()) {return false;}

        Jersey jersey = (Jersey) obj;
        if(price != jersey.price) {return false;}
        if (null == league) {
            return (league == jersey.league);
        } else {
            if (!league.equals(jersey.league)) {
                return false;
            }
        }
        if (null == size) {
            return (size == jersey.size);
        } else {
            if (!size.equals(jersey.size)) {
                return false;
            }
        }
        if (null == material) {
            return (material == jersey.material);
        } else {
            if (!material.equals(jersey.material)) {
                return false;
            }
        }
        if (null == team) {
            return (team == jersey.team);
        } else {
            if (!team.equals(jersey.team)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return (int)(31*price +
                ((null == league) ? 0 : league.hashCode()) +
                ((null == size) ? 0 : size.hashCode()) +
                ((null == team) ? 0 : team.hashCode()) +
                ((null == material) ? 0 : material.hashCode()));
    }

    public String toString() {
        return
                "Jersey : " +
                        "LEAGUE=" + this.league + ", " +
                        "SIZE=" + this.size + ", " +
                        "TEAM=" + this.team + ", " +
                        "MATERIAL=" + this.material + ", " +
                        "PRICE=" + this.price + ";";
    }

    public Map<String, Object> entityParameters() {
        fields.put("league", this.league);
        fields.put("size", this.size);
        fields.put("team", this.team);
        fields.put("material", this.material);
        fields.put("price", this.price);

        return fields;
    }
}
