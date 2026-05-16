package j2css;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CssClassTest {

    @Test
    void extendShouldIncludeBaseAndOverrideProperties() {
        CssClass base = CssCreator.cssClass("btn", CssCreator.style()
            .backgroundColor("#007BFF")
            .color("white")
            .padding("8px 16px"));

        CssClass extended = base.extend("btn-large", CssCreator.style()
            .padding("12px 24px")
            .fontSize("16px"));

        String rendered = extended.render();

        assertTrue(rendered.contains(".btn-large"));
        assertTrue(rendered.contains("background-color: #007BFF;"));
        assertTrue(rendered.contains("color: white;"));
        assertTrue(rendered.contains("padding: 12px 24px;"));
        assertTrue(rendered.contains("font-size: 16px;"));
    }

    @Test
    void shouldExposeClassName() {
        CssClass cssClass = CssCreator.cssClass("card", CssCreator.style().padding("12px"));
        assertEquals("card", cssClass.getName());
    }
}
