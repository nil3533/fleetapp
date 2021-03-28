package com.nirmalya.fleetapp.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nirmalya.fleetapp.models.VehicleMovement;
import com.nirmalya.fleetapp.services.LocationService;
import com.nirmalya.fleetapp.services.VehicleMovementService;
import com.nirmalya.fleetapp.services.VehicleService;

@Controller
public class VehicleMovementController {

	@Autowired
	private VehicleMovementService vehicleMovementService;
	@Autowired
	private LocationService locationService;
	@Autowired
	private VehicleService vehicleService;

	@GetMapping("/vehicleMovement")
	public String getVehicleMovement() {
		return "vehicleMovement";
	}

	// Get All VehicleMovements
	@GetMapping("vehicleMovements")
	public String findAll(Model model) {
		model.addAttribute("vehicleMovements", vehicleMovementService.findAll());
		model.addAttribute("locations", locationService.findAll());
		model.addAttribute("vehicles", vehicleService.findAll());

		return "vehicleMovement";
	}

	@RequestMapping("vehicleMovements/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(Integer id) {
		return vehicleMovementService.findById(id);
	}

	// Add VehicleMovement
	@PostMapping(value = "vehicleMovements/addNew")
	public String addNew(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovements";
	}

	@RequestMapping(value = "vehicleMovements/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehicleMovements";
	}

	@RequestMapping(value = "vehicleMovements/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleMovementService.delete(id);
		return "redirect:/vehicleMovements";
	}

}
