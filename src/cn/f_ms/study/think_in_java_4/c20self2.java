package cn.f_ms.study.think_in_java_4;

import java.io.IOException;
import java.io.Writer;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.Set;

import javax.annotation.processing.Completion;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementFilter;

class c20self2 {

    /**
     * ExtractInterface
     *
     * @author imf_m
     * @date 2018/10/10
     */
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExtractInterface {}

    public class ExtractInterfaceProcessor implements Processor {

        private ProcessingEnvironment env;

        @Override
        public Set<String> getSupportedOptions() {
            return Collections.emptySet();
        }

        @Override
        public Set<String> getSupportedAnnotationTypes() {
            return Collections.singleton(ExtractInterface.class.getCanonicalName());
        }

        @Override
        public SourceVersion getSupportedSourceVersion() {
            return SourceVersion.RELEASE_8;
        }

        @Override
        public void init(ProcessingEnvironment processingEnv) {
            this.env = processingEnv;
        }

        @Override
        public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

            for (Element element : roundEnv.getElementsAnnotatedWith(ExtractInterface.class)) {

                Writer writer = null;
                try {

                    TypeElement element1 = (TypeElement) element;

                    writer = env.getFiler().createSourceFile(element1.getQualifiedName() + "Interface").openWriter();

                    writer.append(String.format(
                            "package %s;", env.getElementUtils().getPackageOf(element1).getQualifiedName()
                    ));

                    writer.append(String.format(
                            "public interface %s {",
                            element1.getSimpleName() + "Interface"
                    ));

                    for (Element nestElement : ElementFilter.methodsIn(element1.getEnclosedElements())) {

                        ExecutableElement nestElement1 = (ExecutableElement) nestElement;

                        if (!nestElement1.getModifiers().contains(Modifier.STATIC)
                                && nestElement1.getModifiers().contains(Modifier.PUBLIC)) {

                            writer.append(String.format(
                                    "%s %s(%s);",
                                    nestElement1.getReturnType(),
                                    nestElement1.getSimpleName(),
                                    getParameters(nestElement1)
                            ));

                        }

                    }

                    writer.append(("}"));
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (writer != null) {
                        try {
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }

            return false;
        }

        private String getParameters(ExecutableElement nestElement1) {
            StringBuffer sb = new StringBuffer();

            for (VariableElement parameter : nestElement1.getParameters()) {
                sb.append(parameter.asType() + " " + parameter.getSimpleName() + ",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }

            return sb.toString();
        }

        @Override
        public Iterable<? extends Completion> getCompletions(Element element, AnnotationMirror annotation, ExecutableElement member, String userText) {
            return null;
        }
    }

}
