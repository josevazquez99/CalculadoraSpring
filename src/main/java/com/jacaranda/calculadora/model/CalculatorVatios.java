package com.jacaranda.calculadora.model;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;

public class CalculatorVatios {
	@NotNull(message="No puede ser nulo")
	private double voltio;
	@NotNull(message="No puede ser nulo")
	private double amperio;

	public double getVoltio() {
		return voltio;
	}


	public void setVoltio(double voltio) throws Exception {
		try {
			this.voltio = voltio;
		} catch (Exception e) {
			throw new Exception("Los voltios deben ser numeros y mayores que 0");
		}
	}

	public double getAmperio() {
		return amperio;
	}

	public void setAmperio(double amperio) throws Exception {
		try {
			this.amperio = amperio;
		} catch (Exception e) {
			throw new Exception("Los amperios deben ser numeros y mayores que 0");
		}
	}
	public String getResult() {
		return "La potencia electrica es de " + this.voltio*this.amperio;

	}
	@Override
	public int hashCode() {
		return Objects.hash(amperio, voltio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalculatorVatios other = (CalculatorVatios) obj;
		return Double.doubleToLongBits(amperio) == Double.doubleToLongBits(other.amperio)
				&& Double.doubleToLongBits(voltio) == Double.doubleToLongBits(other.voltio);
	}

}