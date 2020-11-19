package org.wethinkcode.swingy.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
 
public class ChoiceValidImpl implements ConstraintValidator<ChoiceValid, String> {
 
    @Override
    public boolean isValid(String input, ConstraintValidatorContext context) {
        if (input.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Strange, input is blank: ")
                .addPropertyNode("empty")
                .addConstraintViolation();
            return false;
        } else if (input.matches("\\d+")) {
            return true;
        } else {
            if (input.equals("new") || input.equals("exit") || input.equals("list") || input.equals("swap")) {
                return true;
            }
            else {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        "Input should be new/exit/swap/list, their numbers or a save number not: " + input)
                    .addPropertyNode("empty")
                    .addConstraintViolation();
                return false;
            }
        }
    }
}