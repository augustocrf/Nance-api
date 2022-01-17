package br.com.acrf.nance.adapter.annotation;

import br.com.acrf.nance.type.ValidationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( ElementType.METHOD )
@Retention( RetentionPolicy.RUNTIME)
public @interface AllowAnnonymous {

    ValidationType validationType() default ValidationType.ANNONYMOUS;

}