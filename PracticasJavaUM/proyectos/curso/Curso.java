package curso;

import java.time.LocalDate;
import java.util.HashSet;

public abstract class Curso {
	
	private String titulo;
	private LocalDate fechaInicio;
	private LocalDate fechaFinalizacion;
	protected int numeroDias;
	protected double precioMatricula;
	private HashSet<Alumno> alumnosMatriculados;
	private HashSet<Alumno> alumnosAptos;
	protected int numeroAlumnosMatriculados;
	
	/* CONSTRUCTOR */
	public Curso(String titulo, LocalDate fechaInicio, 
			LocalDate fechaFinalizacion, int numeroDias, double precioMatricula) {
		this.titulo = titulo;
		this.fechaInicio = fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
		this.numeroDias = numeroDias;
		this.precioMatricula = precioMatricula;
		this.alumnosMatriculados = new HashSet<>();
		this.alumnosAptos = new HashSet<>();
	}

	public Curso(Curso curso) {
		this.titulo = curso.titulo;
		this.fechaInicio = curso.fechaInicio;
		this.fechaFinalizacion = curso.fechaFinalizacion;
		this.numeroDias = curso.numeroDias;
		this.precioMatricula = curso.precioMatricula;
		this.alumnosMatriculados = new HashSet<>(curso.alumnosMatriculados);
		this.alumnosAptos = new HashSet<>(curso.alumnosAptos);
		this.numeroAlumnosMatriculados = curso.numeroAlumnosMatriculados;
	}
	
	/* METODOS SET & GET */
	public String getTitulo() {
		return titulo;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public int getNumeroDias() {
		return numeroDias;
	}

	public double getPrecioMatricula() {
		return precioMatricula;
	}

	public HashSet<Alumno> getAlumnosMatriculados() {
		return alumnosMatriculados;
	}

	public HashSet<Alumno> getAlumnosAptos() {
		return alumnosAptos;
	}

	public int getNumeroAlumnosMatriculados() {
		return numeroAlumnosMatriculados;
	}
	
	/* FUNCIONALIDAD DE LA CLASE */
	public boolean isTerminado() {
		return LocalDate.now().isAfter(fechaFinalizacion);
	}
	
	protected abstract boolean isApto(Alumno alumno);
	
	public boolean matricular(Alumno alumno) {
		if (this.precioMatricula - alumno.getCredito() <= 0) {
			this.alumnosMatriculados.add(alumno);
			alumno.getCursosMatriculados().add(this);
			this.numeroAlumnosMatriculados++;
			alumno.decrementarCredito(this.precioMatricula);
			return true;
		}
		return false;
	}
	
	public boolean calificar() {
		for (Alumno alumno : alumnosMatriculados) {
			if (isApto(alumno)) {
				this.alumnosAptos.add(alumno);
			}
		}
		return true;
	}
	
	
}
