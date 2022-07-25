package sptech;

public enum MapStatesEnum {
    EMPTY_A1("---"),
    EMPTY_A2("---"),
    OBSTACLE("***"),
    PLAYER("-P-"),
    OBJECTIVE("-O-");

    private final String text;

    private MapStatesEnum(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }


    
}
