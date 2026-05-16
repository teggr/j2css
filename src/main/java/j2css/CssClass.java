package j2css;

import java.util.Map;

public class CssClass {
    private final String name;
    private final Style style;

    public CssClass(String name, Style style) {
        this.name = name;
        this.style = style.copy();
    }

    public String getName() {
        return name;
    }

    public CssClass extend(String newName, Style extension) {
        Style merged = style.copy().merge(extension);
        return new CssClass(newName, merged);
    }

    public String render() {
        StringBuilder builder = new StringBuilder();
        builder.append('.').append(name).append(" {\n");
        for (Map.Entry<String, String> entry : style.properties().entrySet()) {
            builder.append("    ")
                .append(entry.getKey())
                .append(": ")
                .append(entry.getValue())
                .append(";\n");
        }
        builder.append('}');
        return builder.toString();
    }
}
