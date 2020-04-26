package com.uca.capas.tarea3.controller;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mainController {
	
	
	@RequestMapping("/index")
	public String index() {
		return "form/index";
	}
	
	@RequestMapping("/validar")
	public ModelAndView validar(HttpServletRequest request) throws ParseException {
		ModelAndView mav = new ModelAndView();
		String nombre = request.getParameter("name");
		String apellido = request.getParameter("lastname");
		String fechaNac = request.getParameter("date");
		String lugarNac = request.getParameter("place");
		String lugarEs = request.getParameter("institute");
		String tel = request.getParameter("tel");
		String cel = request.getParameter("cel");
		
		List<String> lista = new ArrayList<>();
		lista = validacion(nombre, apellido, fechaNac, lugarNac, lugarEs, tel, cel);
		
		if(lista.get(7) == "good") {
			mav.setViewName("form/succes");
		}else if(lista.get(7) == "fail") {
			mav.addObject("e1", lista.get(0).toString());
			mav.addObject("e2", lista.get(1).toString());
			mav.addObject("e3", lista.get(2).toString());
			mav.addObject("e4", lista.get(3).toString());
			mav.addObject("e5", lista.get(4).toString());
			mav.addObject("e6", lista.get(5).toString());
			mav.addObject("e7", lista.get(6).toString());
			mav.setViewName("form/validate");
		}
		return mav;
	}
	
	 public List<String> validacion(String nombre, String apellido, String fecha, String lugar, String lugarEs, String tel, String cel) throws ParseException{
		 List<String> lista = new ArrayList<>();
		 Integer flag = 0;
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		 Date date = format.parse(fecha);
		 Date date2 = format.parse("2003-01-01");
		 if(nombre.length() < 1 || nombre.length() > 25) {
			 lista.add("La cantidad de caracteres no es correcta");	
			 flag +=1;
		 }else {
			 lista.add("ok!");
			 flag += 0;
		 }
		 
		 if(apellido.length() < 1 || apellido.length() > 25) {
			 lista.add("La cantidad de caracteres no es correcta");	
			 flag +=1;
		 }else {
			 lista.add("ok!");
			 flag += 0;
		 }
		 
		 if(date.before(date2) == true) {
			 lista.add("La cantidad de caracteres no es correcta");	
			 flag +=1;
		 }else {
			 lista.add("ok!");
			 flag += 0;
		 }
		 if(lugar.length() < 1 || lugar.length() > 25) {
			 lista.add("La cantidad de caracteres no es correcta");	
			 flag +=1;
		 }else {
			 lista.add("ok!");
			 flag += 0;
		 }
		 if(lugarEs.length() < 1 || lugarEs.length() > 100) {
			 lista.add("La cantidad de caracteres no es correcta");	
			 flag +=1;
		 }else {
			 lista.add("ok!");
			 flag += 0;
		 }
		 if(tel.length() < 1 || tel.length() > 8) {
			 lista.add("La cantidad de caracteres no es correcta");	
			 flag +=1;
		 }else {
			 lista.add("ok!");
			 flag += 0;
		 }
		 if(cel.length() < 1 || cel.length() > 8) {
			 lista.add("La cantidad de caracteres no es correcta");	
			 flag +=1;
		 }else {
			 lista.add("ok!");
			 flag += 0;
		 }
		 
		 if(flag == 0) {
			 lista.add("good");
		 }else {
			 lista.add("fail");
		 }
		 		 
		 return lista;
	 }

}
