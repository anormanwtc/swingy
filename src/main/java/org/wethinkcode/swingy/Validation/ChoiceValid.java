package org.wethinkcode.swingy.Validation;
 
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
import javax.validation.Constraint;
import javax.validation.Payload;
 
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ChoiceValidImpl.class)
public @interface ChoiceValid {
    String message() default "Invalid choice!";
     
    Class<?>[] groups() default {};
     
    Class<? extends Payload>[] payload() default {};
}