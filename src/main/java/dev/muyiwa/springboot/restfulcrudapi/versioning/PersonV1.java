package dev.muyiwa.springboot.restfulcrudapi.versioning;

public class PersonV1 {
    private String name;

    public PersonV1(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
