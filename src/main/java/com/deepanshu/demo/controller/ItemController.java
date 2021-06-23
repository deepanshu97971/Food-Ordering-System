package com.deepanshu.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.deepanshu.demo.SendEmailService;
import com.deepanshu.demo.repo.ItemRepo;

@Controller
public class ItemController {
	
	int total, b1, p1, s1, k1;
	
	@Autowired
	ItemRepo repo;
	
	@RequestMapping("/")
	public String home()
	{
		
		return "home.jsp";
	}
	
	@RequestMapping("/calculate")
	public ModelAndView calculate(@RequestParam(value="burger") String burger,@RequestParam(value="pizza") String pizza,@RequestParam(value="samosa") String samosa,@RequestParam(value="kachori") String kachori )
	{
		ModelAndView mv = new ModelAndView("show.jsp");
		//int total;
		
		b1 = Integer.parseInt(burger);
		p1 = Integer.parseInt(pizza);
		s1 = Integer.parseInt(samosa);
		k1 = Integer.parseInt(kachori);
//		Object o = burger;
//		System.out.println(o.getClass().getName());
		
		total = b1*repo.findPrice(1) + p1*repo.findPrice(2) + s1*repo.findPrice(3) + k1*repo.findPrice(4);
		
		System.out.println(total);
		
		Integer o = total;
		
		mv.addObject("o",o);
		
		return mv;
	}
	
	@Autowired
	private SendEmailService sendEmailService;
	
	@RequestMapping("/confirm")
	public ModelAndView confirm(@RequestParam(value="email_address") String email_address,@RequestParam(value="d_address") String d_address)
	{
		ModelAndView mv = new ModelAndView("confirm.jsp");
		String body = "Thank You for ordering !!\n\n\nBelow are your order details : \n\n";
		body = body + "Items       :   " + "Quantity";
		body = body + "\n\n";
		body = body + "Burger      :      " + b1;
		body = body + "\n";
		body = body + "Pizza       :      " + p1;
		body = body + "\n";
		body = body + "Samosa      :      " + s1;
		body = body + "\n";
		body = body + "Kachori     :      " + k1;
		body = body + "\n\n";
		
		body = body + "Total amount to be paid on delivery  :  Rs. " + total;
		body = body + "\n\n";
//		System.out.println(email_address);
//		System.out.println(d_address);
		
//		System.out.println(total);
		
		body = body + "Delivery Address  :  " + d_address;
		body = body + "\n\n\n\n Stay Home, Stay Safe";
		System.out.println(body);
		
		sendEmailService.sendEmail(email_address,body,"Order Confirmation");
		
		return mv;
	}

}
