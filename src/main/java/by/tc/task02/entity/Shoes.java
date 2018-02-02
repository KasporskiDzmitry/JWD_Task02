package by.tc.task02.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Дима on 30.01.2018.
 */
public class Shoes implements Serializable, SportEquipment {

    private String type;
    private String color;
    private String material;
    private short size;
    private double price;

    private Map<String, Object> fields = new HashMap<>();

    public Shoes() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public short getSize() {
        return size;
    }

    public void setSize(short size) {
        this.size = size;
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

        Shoes shoes = (Shoes) obj;
        if(size != shoes.size) {return false;}
        if(price != shoes.price) {return false;}
        if (null == type) {
            return (type == shoes.type);
        } else {
            if (!type.equals(shoes.type)) {
                return false;
            }
        }
        if (null == color) {
            return (color == shoes.color);
        } else {
            if (!color.equals(shoes.color)) {
                return false;
            }
        }
        if (null == material) {
            return (material == shoes.material);
        } else {
            if (!material.equals(shoes.material)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return (int)(31*size + 31*price +
                ((null == type) ? 0 : type.hashCode()) +
                ((null == color) ? 0 : color.hashCode()) +
                ((null == material) ? 0 : material.hashCode()));
    }

    public String toString() {
        return
                "Shoes : "  +
                        "TYPE = " + this.type + ", " +
                        "SIZE = " + this.size + ", " +
                        "COLOR = " + this.color + ", " +
                        "MATERIAL = " + this.material + ", " +
                        "PRICE = " + this.price + ";";
    }

    public Map<String, Object> entityFields() {
        fields.put("type", this.type);
        fields.put("size", this.size);
        fields.put("color", this.color);
        fields.put("material", this.material);
        fields.put("price", this.price);

        return fields;
    }
}
