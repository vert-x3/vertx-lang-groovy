package io.vertx.lang.groovy;

import io.vertx.codegen.type.ClassKind;
import io.vertx.codegen.type.ApiTypeInfo;
import io.vertx.codegen.type.EnumTypeInfo;
import io.vertx.codegen.type.TypeInfo;
import io.vertx.codegen.type.TypeMirrorFactory;
import io.vertx.codetrans.CodeTranslator;
import io.vertx.codetrans.lang.groovy.GroovyLang;
import io.vertx.docgen.Coordinate;
import io.vertx.docgen.DocGenerator;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.type.ExecutableType;
import javax.lang.model.type.TypeMirror;
import java.util.List;

/**
 * @author <a href="mailto:julien@julienviet.com">Julien Viet</a>
 */
public class GroovyDocGenerator implements DocGenerator {

  private TypeMirrorFactory factory;
  private CodeTranslator translator;
  private ProcessingEnvironment env;

  @Override
  public void init(ProcessingEnvironment processingEnv) {
    factory = new TypeMirrorFactory(processingEnv.getElementUtils(), processingEnv.getTypeUtils());
    translator = new CodeTranslator(processingEnv);
    env = processingEnv;
  }

  @Override
  public String getName() {
    return "groovy";
  }

  @Override
  public String renderSource(ExecutableElement elt, String source) {
    GroovyLang lang = new GroovyLang();
    try {
      return translator.translate(elt, lang);
    } catch (Exception e) {
      System.out.println("Cannot generate " + elt.getEnclosingElement().getSimpleName() + "#" + elt.getSimpleName() + " : " + e.getMessage());
      return "Code not translatable";
    }
  }

  @Override
  public String resolveTypeLink(TypeElement elt, Coordinate coordinate) {
    TypeInfo type = null;
    try {
      type = factory.create(elt.asType());
    } catch (Exception e) {
      System.out.println("Could not resolve doc link for type " + elt.getQualifiedName());
      return null;
    }
    if (type.getKind() == ClassKind.ENUM && ((EnumTypeInfo) type).isGen()) {
      String baselink;
      if (coordinate == null) {
        baselink = "../";
      } else {
        baselink = "../../" + coordinate.getArtifactId() + "/";
      }
      return baselink + "enums.html#" + elt.getSimpleName().toString();
    }
    if (type.getKind() == ClassKind.DATA_OBJECT) {
      String baselink;
      if (coordinate == null) {
        baselink = "../";
      } else {
        baselink = "../../" + coordinate.getArtifactId() + "/";
      }
      return baselink + "dataobjects.html#" + elt.getSimpleName().toString();
    }
    if (type.getKind() == ClassKind.API) {
      String baselink = "";
      if (coordinate != null) {
        baselink = "../../" + coordinate.getArtifactId() + "/groovy/";
      }
      ApiTypeInfo api = (ApiTypeInfo) type.getRaw();
      return baselink + "groovydoc/" + api.translateName("groovy").replace('.', '/') + ".html";
    }
    return null;
  }

  @Override
  public String resolveMethodLink(ExecutableElement elt, Coordinate coordinate) {
    TypeElement typeElt = (TypeElement) elt.getEnclosingElement();
    String link = resolveTypeLink(typeElt, coordinate);
    if (link != null) {
      if (link.contains("cheatsheet")) {
        link = link + '#' + java.beans.Introspector.decapitalize(elt.getSimpleName().toString().substring(3));
      } else {
        String anchor = '#' + elt.getSimpleName().toString() + "(";
        TypeMirror type = elt.asType();
        ExecutableType methodType  = (ExecutableType) env.getTypeUtils().erasure(type);
        List<? extends TypeMirror> parameterTypes = methodType.getParameterTypes();
        for (int i = 0;i < parameterTypes.size();i++) {
          if (i > 0) {
            anchor += ",%20";
          }
          anchor += parameterTypes.get(i).toString();
        }
        anchor += ')';
        link = link + anchor;
      }
    }
    return link;
  }

  @Override
  public String resolveLabel(Element elt, String defaultLabel) {
    if (elt.getKind() == ElementKind.METHOD) {
      TypeInfo type = factory.create(elt.getEnclosingElement().asType());
      if (type.getKind() == ClassKind.DATA_OBJECT) {
        String name = elt.getSimpleName().toString();
        if (name.startsWith("set") && name.length() > 3 && Character.isUpperCase(name.charAt(3))) {
          name = java.beans.Introspector.decapitalize(name.substring(3));
        }
        return name;
      }
    }
    return defaultLabel;
  }

  @Override
  public String resolveConstructorLink(ExecutableElement elt, Coordinate coordinate) {
    return "todo";
  }

  @Override
  public String resolveFieldLink(VariableElement elt, Coordinate coordinate) {
    return "todo";
  }
}
