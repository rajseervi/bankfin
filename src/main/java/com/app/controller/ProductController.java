package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.Product;
import com.app.service.IProductService;
import com.app.validation.ProductValidation;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService service;
	@Autowired
	private ProductValidation validate;

	@RequestMapping("/")
	public String showRegPage(ModelMap map) {
		map.addAttribute("product", new Product());
		return "ProductRegister";
	} 
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveEmp(@ModelAttribute("product") Product prod, Errors errors, ModelMap map) {

		validate.validate(prod, errors);
		if (!errors.hasErrors()) {
			int n = service.saveProduct(prod);

			if (n > 0) {
				System.out.println("product added :" + n);
				map.addAttribute("product", new Product());
				map.addAttribute("msg", "Product Added Successfully with serial:" + n);
			}
		} else {
			map.addAttribute("msg", "Please check all Errors!!");
		}

		return "ProductRegister";
	}
	
	
	@RequestMapping("/products")
	public String getAllProduct(ModelMap map) {  
		List<Product> product = service.getAllProducts();
		map.addAttribute("prod",product); 
		return "AllProduct";
	}
	
	@RequestMapping(value="read",method=RequestMethod.POST)
	public ModelAndView deleteOneProd(@RequestParam("id") int prodId, ModelMap map) {
		service.deleteProduct(prodId);
		map.addAttribute("msg", "Employe Deleted successfully"); 
		return new ModelAndView("redirect:/read"); 
	}
	
	
}
