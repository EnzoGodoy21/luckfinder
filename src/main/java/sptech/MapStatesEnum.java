package sptech;

public enum MapStatesEnum {
    EMPTY_A1("---","\u001B[32m"),
    EMPTY_A2("---","\u001B[36m"),
    OBSTACLE("%%%","\u001B[31m"),
    PLAYER("-P-","\u001B[34m"),
    OBJECTIVE("-O-","\u001B[33m");

    private final String text;
    private final String color;

    private MapStatesEnum(String text, String color) {
        this.text = text;
        this.color = color;
    }

    public String getText() {
        return this.text;
    }

    public String getColor() {
        return color;
    }
   
}
