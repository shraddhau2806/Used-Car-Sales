
package com.example.demo.controller;



import java.util.List;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;


 

@Controller
public class CarController {

 

    @Autowired
    private Car car;
    
    @Autowired
    private CarRepository repo;

 

    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    public String initForm(Model model) {

 

        model.addAttribute("command", car);

 

        return "addcar";


    }

 

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public String submitForm(@ModelAttribute("command") Car car,Model model) {

        
    int rowAdded =    repo.addCar(car);
 model.addAttribute("rowAdded", rowAdded);
        return "addcar";

 

    }

 

    @RequestMapping(value = "/cars/all",method=RequestMethod.GET)

    public String findAllCar(Model model) {

 
        List<Car> list =repo.getAllCars();
        model.addAttribute("list",list);
        
        return "showcar";

 

    }

    
    @RequestMapping(value = "/cars/findAll",method=RequestMethod.GET)

    public String findAvailableCar(Model model) {

 
        List<Car> list =repo.getAvailableCars();
        model.addAttribute("list",list);
        
        return "showCarbyStatus";

 

    }

    @RequestMapping(value="/cars/brand", method = RequestMethod.POST)
    public String findCarsByBrand(@ModelAttribute("command") @RequestParam("brand")String barnd, Model model) {
    	
    	List<Car> list=repo.getsCarsByBrand(barnd);
    	model.addAttribute("list", list);
    	  return "carsByBrand";
    }

        @ModelAttribute("brands")
        public String[] brand() {

     

            
            String[] brands=repo.getBrand();
            //return new String[] { "Maruti","TATA","Mahindra" };
    return brands;
        }

      
        @RequestMapping(value="/cars/showByBrand", method= RequestMethod.GET)
        public String initFromBrand(Model model) {
        	model.addAttribute("command", car);
        	return "selectBrand";
        }
 

    
}