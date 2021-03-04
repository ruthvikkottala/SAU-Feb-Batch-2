package com.au.ordermgmt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.au.ordermgmt.dao.SampleDao;
import com.au.ordermgmt.model.Payment;

@RestController
public class SampleController {
	@Autowired
	SampleDao sampleDao;
	
	@GetMapping(value="/hello")
	public String hello() {
		return sampleDao.getProductName(1);
	}
	
	@GetMapping(value="/payment")
	public Payment getPayment() {
		Payment payment = new Payment();
		payment.setId(sampleDao.getId(1));
		payment.setName(sampleDao.getName(1));
		payment.setCredits(sampleDao.getCredits(1));
		return payment;
	}
	
	@GetMapping("/payment/set/{cost}")
	public void setCredits(@PathVariable int cost) {
		System.out.println(cost);
		sampleDao.setCredits(1, cost);
	}
}
