package com.sda.party.validator;

import com.sda.party.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


public class UserPasswordValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "valid.password");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "valid.passwordConfirm");

        User user = (User) o;
        if (!user.getPassword().equals(user.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "valid.passwordConfirmDiff");
        }

        String firstName = user.getLogin();
        if (firstName.length() < 3 || firstName.length() > 25) {
            errors.rejectValue("firstName", "valid.firstNameLength");
        }
    }
}