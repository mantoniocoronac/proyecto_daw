package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name =  "pista")
public class Pista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private int numeroPista;
	private double precio;
	private String tipo;
	private String imagen;
	
	@OneToMany(mappedBy="pista")
	private List<Reserva> reservas;

	public Pista() {
		
	}
	
	public Pista(int numeroPista, double precio, String tipo) {
		this.numeroPista = numeroPista;
		this.precio = precio;
		this.tipo = tipo;
	}

	public Pista(int numeroPista, double precio, String tipo, String imagen) {
		this.numeroPista = numeroPista;
		this.precio = precio;
		this.tipo = tipo;
		this.imagen = imagen;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumeroPista() {
		return numeroPista;
	}

	public void setNumeroPista(int numeroPista) {
		this.numeroPista = numeroPista;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Pista [id=" + id + ", numeroPista=" + numeroPista + ", precio=" + precio + ", tipo=" + tipo
				+ ", imagen=" + imagen + ", reservas=" + reservas + "]";
	}
	
	
	
}
