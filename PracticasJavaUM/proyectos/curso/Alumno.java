package curso;

import java.util.HashSet;

public class Alumno implements Comparable<Alumno>{
	
	private final String nombre;
	private final String DNI;
	private double credito;
	private HashSet<Curso> cursosMatriculados;
	
	/* CONSTRUCTORES */
	public Alumno(String DNI, String nombre, double credito) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.credito = credito;
		this.cursosMatriculados = new HashSet<>();
	}
	
	public Alumno(String DNI, String nombre) {
		this(DNI, nombre, 100);
	}

	/* METODOS DE ESTABLECIMIENTO Y OBTENCION */
	public double getCredito() {
		return credito;
	}

	public void setCredito(double credito) {
		this.credito = credito;
	}

	public HashSet<Curso> getCursosMatriculados() {
		return cursosMatriculados;
	}

	public void setCursosMatriculados(HashSet<Curso> cursosMatriculados) {
		this.cursosMatriculados = cursosMatriculados;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDNI() {
		return DNI;
	}
	
	/* FUNCIONALIDAD DE LA CLASE */
	public void incrementarCredito(double cantidad) {
		this.credito += cantidad;
	}
	
	public void decrementarCredito(double cantidad) {
		this.credito -= cantidad;
	}
	
	public void addCursos(Curso curso) {
		this.cursosMatriculados.add(curso);
	}
	
	@Override
	public String toString() {
		return "Nombre : " + nombre + ", DNI : " + DNI +
				", credito : " + credito + ", Numero cursos matriculados : " + cursosMatriculados.size();
	}

	@Override
	public int compareTo(Alumno alumnoOtro) {
		return this.DNI.compareTo(alumnoOtro.getDNI());
	}

}
