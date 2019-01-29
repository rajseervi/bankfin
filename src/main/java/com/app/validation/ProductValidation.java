package com.app.validation;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.app.model.Product;

@Component
public class ProductValidation implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product p = (Product) target;
		// name accept only 4-6 chars
		if (!Pattern.compile("[A-Z0-9]{4,20}").matcher(p.getProductName()).matches()) {
			errors.rejectValue("productName", null, "Enter Product name in 4-20 chars Uppercase");
		}
		
//		if (!Pattern.compile("[0-9]{3,5}").matcher(p.getProductCost()).matches()) {
//			errors.rejectValue("productCost", null, "Enter Product Cost in 3-5 digit");
//		}
		
		if (!Pattern.compile("[A-Za-z]{2,100}").matcher(p.getProductDesc()).matches()) {
			errors.rejectValue("productDesc", null, "Enter Product Describtion in 2-100 Char");
		}
		 
		// please choose one gender
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productCost", null, "Please Provide Cost");
		
//		// langs
//		if (e.getEmpLang() == null || e.getEmpLang().isEmpty()) {
//			errors.rejectValue("empLang", null, "Please choose at least one Language!!");
//		}
		 
		
	}

}
