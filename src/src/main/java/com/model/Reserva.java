package com.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.model.Pista;

@Entity
@Table(name =  "reserva")
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime fechaReserva;

	@ManyToOne
	@JoinColumn(name="reservaPista",nullable=false)
	private Pista pista;
	
	@ManyToOne
	@JoinColumn(name="reservaUser", nullable=false)
	private User user;
	
	public Reserva() {
		
	}
	
	public Reserva(User user, LocalDateTime fechaReserva) {
		
		this.user = user;
		this.fechaReserva = fechaReserva;
		
	}

	public Reserva(long id, User user, LocalDateTime fechaReserva) {
		this.user = user;
		this.fechaReserva = fechaReserva;
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva(LocalDateTime fechaReserva) {
		this.fechaReserva = fechaReserva;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Pista getPista() {
		return pista;
	}

	public void setPista(Pista pista) {
		this.pista = pista;
	}
		
	
}
