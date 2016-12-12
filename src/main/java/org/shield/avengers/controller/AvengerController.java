package org.shield.avengers.controller;

import java.io.IOException;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.shield.avengers.model.Avenger;
import org.shield.avengers.service.AvengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/avenger")
public class AvengerController {

	@Autowired
	private AvengerService avengerService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {

		ModelAndView mv = new ModelAndView("avenger/index");

		// Get list avengers
		List<Avenger> avengers = avengerService.getAllAvenger();

		mv.addObject("maVariable", avengers);
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addFormulaire() {
		return "avenger/add-formulaire";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addAvenger(@RequestParam(value = "lastName") String lastName, String firstName, String alias,
			Integer power, String photo) {
		Avenger avenger = new Avenger();
		avenger.setLastName(lastName);
		avenger.setFirstName(firstName);
		avenger.setAlias(alias);
		avenger.setPower(power);
		byte[] bytes = Base64.decodeBase64(photo);
		avenger.setPhoto(bytes);
		avengerService.save(avenger);
		return "redirect:/app/avenger/";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	public String delete(@PathVariable("id") Integer id) {
		Avenger avenger = avengerService.getAvenger(id);
		avengerService.delete(avenger);
		return "redirect:/app/avenger/";
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public ModelAndView update(@PathVariable("id") Integer id) {

		ModelAndView mv = new ModelAndView("avenger/add-formulaire");
		// Get avenger
		Avenger avenger = avengerService.getAvenger(id);
		System.out.println(avenger.getPhoto());
		mv.addObject("av", avenger);
		return mv;

	}

	@RequestMapping(value = "/{id}/updateAv", method = RequestMethod.POST)
	public String updateAv(@PathVariable("id") Integer id, @RequestParam String lastName, String firstName,
			String alias, Integer power, String photo) {
		Avenger avenger = avengerService.getAvenger(id);
		avenger.setLastName(lastName);
		avenger.setFirstName(firstName);
		avenger.setAlias(alias);
		avenger.setPower(power);
		byte[] bytes = Base64.decodeBase64(photo);
		avenger.setPhoto(bytes);
		avengerService.save(avenger);
		return "redirect:/app/avenger/";
	}

	@RequestMapping(value = "/{id}/add-pix", method = RequestMethod.GET)
	public ModelAndView addPhoto(@PathVariable("id") Integer id) {

//		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//		attr.getRequest().getSession(true).setAttribute("id", id);
		
		ModelAndView mv = new ModelAndView("avenger/edit-av");
		mv.addObject("id", id);

		return mv;

	}
	
	@RequestMapping(value = "/{id}/add-pix", method = RequestMethod.POST)
	public String uploadPhoto(MultipartFile file, @PathVariable Integer id ){
		
		Avenger avenger = avengerService.getAvenger(id); 
		try {
			if (file != null) {
				byte[] bytes = file.getBytes();
				avenger.setPhoto(bytes);
			} else {
				byte[] bytes = null;
				avenger.setPhoto(bytes);
			}
			
			
			avengerService.save(avenger);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MultipartException e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/app/avenger/";

	}
	
	@RequestMapping(value = "/uploadPhoto", method = RequestMethod.POST)
	public @ResponseBody String uploadPhoto1(MultipartFile file) {
		
		try {
			
			byte[] bytes = file.getBytes();
			return Base64.encodeBase64String(bytes);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return "";
	}
	

}
