# j2css

A Java library for writing CSS with a typed fluent API.

## Setup

- Java 21
- Maven 3.9+

Build and test:

```bash
mvn test
```

## Usage

```java
import j2css.CssClass;
import j2css.CssCreator;

CssClass btnPrimary = CssCreator.cssClass(
    "btn-primary",
    CssCreator.style().backgroundColor("#007BFF").color("white")
);
CssClass btnPrimaryLarge = btnPrimary.extend(
    "btn-primary-large",
    CssCreator.style().padding("12px 24px")
);

CssCreator css = new CssCreator().withClass(btnPrimary).withClass(btnPrimaryLarge);
System.out.println(css.render());
css.toFile("styles.css");
```
