package xyz.xechoz.base.anotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;


@SupportedAnnotationTypes({"xyz.xechoz.app.util.gson.GsonAdapter"})
public class Processor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment env) {
        for (Element item: env.getElementsAnnotatedWith(GsonAdapter.class)) {

        }

        List<Class<?>> adapterClass = new ArrayList<>();

        return false;
    }
}
