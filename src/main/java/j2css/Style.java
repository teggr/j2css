package j2css;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Style {
    private final LinkedHashMap<String, String> properties = new LinkedHashMap<>();

    public Style() {
    }

    private Style(Style other) {
        properties.putAll(other.properties);
    }

    public Style property(String name, String value) {
        properties.put(name, value);
        return this;
    }

    public Style backgroundColor(String value) {
        return property("background-color", value);
    }

    public Style color(String value) {
        return property("color", value);
    }

    public Style padding(String value) {
        return property("padding", value);
    }

    public Style margin(String value) {
        return property("margin", value);
    }

    public Style border(String value) {
        return property("border", value);
    }

    public Style borderRadius(String value) {
        return property("border-radius", value);
    }

    public Style fontSize(String value) {
        return property("font-size", value);
    }

    public Style textAlign(String value) {
        return property("text-align", value);
    }

    public Style merge(Style other) {
        properties.putAll(other.properties);
        return this;
    }

    public Style copy() {
        return new Style(this);
    }

    public String render() {
        StringJoiner joiner = new StringJoiner(" ");
        for (Map.Entry<String, String> entry : properties.entrySet()) {
            joiner.add(entry.getKey() + ": " + entry.getValue() + ";");
        }
        return joiner.toString();
    }

    Map<String, String> properties() {
        return properties;
    }
}
