package me.jagar.mindmappingandroidlibrary.Views;

public class CustomConnection {
    public Item item1, item2;
    public ConnectionTextMessage connectionTextMessage;
    public int width, circRadius1, circRadius2, color;
    public int position1, position2;

    public CustomConnection(Item item1, Item item2, ConnectionTextMessage connectionTextMessage, int width,
                            int circRadius1, int circRadius2, int color, int position1, int position2) {
        this.item1 = item1;
        this.item2 = item2;
        this.connectionTextMessage = connectionTextMessage;
        this.width = width;
        this.circRadius1 = circRadius1;
        this.circRadius2 = circRadius2;
        this.color = color;
        this.position1 = position1;
        this.position2 = position2;
    }

    public Item getItem1() {
        return item1;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
    }

    public Item getItem2() {
        return item2;
    }

    public void setItem2(Item item2) {
        this.item2 = item2;
    }

    public ConnectionTextMessage getConnectionTextMessage() {
        return connectionTextMessage;
    }

    public void setConnectionTextMessage(ConnectionTextMessage connectionTextMessage) {
        this.connectionTextMessage = connectionTextMessage;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getCircRadius1() {
        return circRadius1;
    }

    public void setCircRadius1(int circRadius1) {
        this.circRadius1 = circRadius1;
    }

    public int getCircRadius2() {
        return circRadius2;
    }

    public void setCircRadius2(int circRadius2) {
        this.circRadius2 = circRadius2;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getPosition1() {
        return position1;
    }

    public void setPosition1(int position1) {
        this.position1 = position1;
    }

    public int getPosition2() {
        return position2;
    }

    public void setPosition2(int position2) {
        this.position2 = position2;
    }

}
