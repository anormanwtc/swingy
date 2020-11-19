package org.wethinkcode.swingy.Validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
 
public class DirectionValidImpl implements ConstraintValidator<DirectionValid, String> {
 
    @Override
    public boolean isValid(String input, ConstraintValidatorContext context) {
        if (input.isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Strange, input is blank: ")
                .addPropertyNode("empty")
                .addConstraintViolation();
            return false;
        } else if (input.matches("\\d+")) {
            int i = Integer.parseInt(input);
            if (i < 1 || i > 5) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        "Input should be a direction, exit or their numbers not: " + input)
                    .addPropertyNode("invalid")
                    .addConstraintViolation();
                return false;
            }
            return true;
        } else {
            input = input.toLowerCase();
            if (input.equals("north") || input.equals("south") ||
                input.equals("east") || input.equals("west") || input.equals("exit")) {
                return true;
            }
            else {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        "Input should be a direction, exit or their numbers not: " + input)
                    .addPropertyNode("invalid")
                    .addConstraintViolation();
                return false;
            }
        }
    }
}