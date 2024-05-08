package utils;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

public class ElementCollectionWrapper {
    private final ElementsCollection elements;

    public ElementCollectionWrapper(ElementsCollection elements) {
        this.elements = elements;
    }

    public SelenideElement searchElement(String text) {
        return elements.findBy(Condition.text(text));
    }
}
