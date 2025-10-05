package Clinic_Appointment_Booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Clinic_Appointment_Booking.Entity.Appointment;

public interface AppointmentRepo extends JpaRepository<Appointment,Integer>{}
