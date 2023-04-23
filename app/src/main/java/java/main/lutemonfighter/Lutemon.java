package java.main.lutemonfighter;

import java.io.Serializable;

public class Lutemon implements Serializable {

    private String name;
    private String lutemonType;

    public Lutemon(String name, String lutemonType) {
        this.name = name;
        this.lutemonType = lutemonType;
    }

    public String getName() {
        return name;
    }

    public String getLutemonType() {
        return lutemonType;
    }

}
