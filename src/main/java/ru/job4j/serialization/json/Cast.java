package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cast")
public class Cast {
    @XmlAttribute
    private String name;

    public Cast() { }

    public Cast(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cast{"
                + "name='" + name + '\''
                + '}';
    }
}
