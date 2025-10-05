package Clinic_Appointment_Booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Clinic_Appointment_Booking.Entity.Appointment;
import Clinic_Appointment_Booking.Repository.AppointmentRepo;


@SuppressWarnings("unused")
@Controller
@RequestMapping("/yourclinic_controller")
public class DoctorController {
	
	
	@Autowired
	AppointmentRepo repo;
	
	@GetMapping("/HomePage")
	public String home(Model model) {
	    model.addAttribute("clinicName", "Your Health Clinic");
	    model.addAttribute("clinicLocation", "Latur, Maharashtra");
	    model.addAttribute("clinicContact", "+91 0123456789");
	    model.addAttribute("clinicDean", "Dr. Priya Sharma");
	    return "HP";
	}
	
	
	@GetMapping("/doctor")
	public String showDoctorProfile() {
	    return "Doc.html"; 
	}
	
	 @GetMapping("/appointment")
	public String showAppointmentForm(Model model) {
		 model.addAttribute("appoint", new Appointment());
	        return "appointment.html"; 
	      
	    }
	 @PostMapping("/done")
	 String Fetchobj(@ModelAttribute("appoint") Appointment appoint) {
		 repo.save(appoint);
		return "Done.html";
	 
	 }


	@GetMapping("/allAppointments")
	String getAll(Model model) {
		 model.addAttribute("appointments",repo.findAll());
		return "allAppointments.html";
	}

}
//@GetMapping("/allAppointments")
//public String listAppointments(Model model) {
//    List<Appointment> appointments = repo.findAll();
//    model.addAttribute("appointments", appointments);
//    return "allAppointments.html"; 
//}
