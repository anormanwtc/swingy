package org.wethinkcode.swingy.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
 
public class ClassValidImpl implements ConstraintValidator<ClassValid, String> {
 
    @Override
    public boolean isValid(String input, ConstraintValidatorContext context) {
        if (input.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Strange, input is blank: ")
                .addPropertyNode("empty")
                .addConstraintViolation();
            return false;
        } else {
            input = input.toLowerCase();
            if (input.equals("mage") || input.equals("rogue") || input.equals("warrior")) {
                return true;
            }
            else {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        "Valid classes are Mage, Warrior, Rogue not: " + input)
                    .addPropertyNode("invalid")
                    .addConstraintViolation();
                return false;
            }
        }
    }
}