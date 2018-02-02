package by.tc.task02.entity;

import by.tc.task02.entity.criteria.Criteria;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Дима on 30.01.2018.
 */
public class Ball implements Serializable, SportEquipment {

    private String type;
    private String color;
    private String material;
    private short size;
    private double price;

    private Map<String, Object> fields = new HashMap<>();

    public Ball() {
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

        Ball ball = (Ball)obj;
        if(size != ball.size) {return false;}
        if(price != ball.price) {return false;}
        if (null == type) {
            return (type == ball.type);
        } else {
            if (!type.equals(ball.type)) {
                return false;
            }
        }
        if (null == color) {
            return (color == ball.color);
        } else {
            if (!color.equals(ball.color)) {
                return false;
            }
        }
        if (null == material) {
            return (material == ball.material);
        } else {
            if (!material.equals(ball.material)) {
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
                "Ball : " +
                        "TYPE=" + this.type + ", " +
                        "SIZE=" + this.size + ", " +
                        "COLOR=" + this.color + ", " +
                        "MATERIAL=" + this.material + ", " +
                        "PRICE=" + this.price + ";";
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
