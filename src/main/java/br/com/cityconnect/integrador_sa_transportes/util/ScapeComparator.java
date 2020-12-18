package br.com.cityconnect.integrador_sa_transportes.util;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ScapeComparator {
  String colummn() default "";
}
