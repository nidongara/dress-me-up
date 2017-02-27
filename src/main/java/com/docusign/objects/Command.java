package com.docusign.objects;

import com.docusign.enums.Temperature;

import java.util.Map;

/**
 * Created by nihardongara on 2/23/17.
 */
public class Command {

    private Integer number;
    private String desc;
    private Map<Temperature, String> responses;

    public Command(Integer number, String description, Map<Temperature, String> responses)
    {
        this.number = number;
        this.desc = description;
        this.responses = responses;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Map<Temperature, String> getResponses() {
        return responses;
    }

    public void setResponses(Map<Temperature, String> responses) {
        this.responses = responses;
    }
}
