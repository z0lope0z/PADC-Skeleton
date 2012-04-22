package org.padc.skeleton.fb.models;

/**
 * 
 * @author Lope Chupijay Emano
 * 
 */
public class Friend {
    private String id;
    private String name;

    public Friend(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
