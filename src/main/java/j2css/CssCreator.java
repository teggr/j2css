package j2css;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class CssCreator {
    private final List<CssClass> classes = new ArrayList<>();

    public static Style style() {
        return new Style();
    }

    public static CssClass cssClass(String name, Style style) {
        return new CssClass(name, style);
    }

    public CssCreator withClass(CssClass cssClass) {
        classes.add(cssClass);
        return this;
    }

    public String render() {
        StringJoiner joiner = new StringJoiner("\n\n");
        for (CssClass cssClass : classes) {
            joiner.add(cssClass.render());
        }
        return joiner.toString();
    }

    public void toFile(String filename) {
        Path path = Path.of(filename);
        try {
            Path parent = path.getParent();
            if (parent != null) {
                Files.createDirectories(parent);
            }
            Files.writeString(path, render(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to write CSS file: " + filename, e);
        }
    }

    public static void main(String[] args) {
        CssClass btnPrimary = cssClass("btn-primary", style().backgroundColor("#007BFF").color("white"));
        CssClass btnPrimaryLarge = btnPrimary.extend("btn-primary-large", style().padding("12px 24px"));

        CssCreator css = new CssCreator().withClass(btnPrimary).withClass(btnPrimaryLarge);
        System.out.println(css.render());
        css.toFile("styles.css");
    }
}
