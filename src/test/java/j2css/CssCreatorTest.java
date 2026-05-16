package j2css;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CssCreatorTest {

    @Test
    void renderShouldCombineClasses() {
        CssClass btnPrimary = CssCreator.cssClass("btn-primary", CssCreator.style()
            .backgroundColor("#007BFF")
            .color("white"));

        CssCreator creator = new CssCreator().withClass(btnPrimary);

        String rendered = creator.render();

        assertTrue(rendered.contains(".btn-primary"));
        assertTrue(rendered.contains("background-color: #007BFF;"));
        assertTrue(rendered.contains("color: white;"));
    }

    @Test
    void toFileShouldWriteRenderedCss(@TempDir Path tempDir) throws IOException {
        CssClass card = CssCreator.cssClass("card", CssCreator.style().padding("20px").margin("10px"));
        CssCreator creator = new CssCreator().withClass(card);

        Path outputFile = tempDir.resolve("styles.css");
        creator.toFile(outputFile.toString());

        assertTrue(Files.exists(outputFile));
        assertEquals(creator.render(), Files.readString(outputFile));
    }
}
