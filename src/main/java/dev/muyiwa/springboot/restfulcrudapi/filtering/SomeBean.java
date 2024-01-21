package dev.muyiwa.springboot.restfulcrudapi.filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SomeBean {
    @JsonProperty("field_1")
    private String firstField;
    @JsonIgnore
    private String secondField;
    @JsonProperty("field_3")
    private String thirdField;


    public SomeBean(String field1, String field2, String field3) {
        this.firstField = field1;
        this.secondField = field2;
        this.thirdField = field3;
    }

    public String getFirstField() {
        return firstField;
    }

    public String getSecondField() {
        return secondField;
    }

    public String getThirdField() {
        return thirdField;
    }

    @Override
    public String toString() {
        return "SomeBean{" +
                "firstField='" + firstField + '\'' +
                ", secondField='" + secondField + '\'' +
                ", thirdField='" + thirdField + '\'' +
                '}';
    }
}
