package model;

public class Falta {
	
	private String fecha;
	private int id_alumno;
	
	/* CONSTRUCTOR */
	public Falta(String fecha, int id_alumno) {
		super();
		this.fecha = fecha;
		this.id_alumno = id_alumno;
	}
	
	/* GETTERS & SETTERS */
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getId_alumno() {
		return id_alumno;
	}
	public void setId_alumno(int id_alumno) {
		this.id_alumno = id_alumno;
	}

}
