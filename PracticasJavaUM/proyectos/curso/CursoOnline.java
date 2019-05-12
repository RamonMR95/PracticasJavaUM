package curso;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class CursoOnline extends Curso {

	private final int nivel;
	private HashMap<Alumno, Integer> seguimiento;
	private final HashSet<Curso> cursosPrevios;
	
	public CursoOnline(String titulo, LocalDate fechaInicio, LocalDate fechaFinalizacion, int numeroDias,
			double precioMatricula, int nivel,  Curso...cursos) {
		super(titulo, fechaInicio, fechaFinalizacion, numeroDias, precioMatricula);
		this.cursosPrevios = new HashSet<>();
		this.nivel = nivel;
		this.seguimiento = new HashMap<>();
		this.numeroDias = numeroDias;
		Collections.addAll(this.cursosPrevios, cursos);
	}
	
	
	public int getNivel() {
		return nivel;
	}


	public HashMap<Alumno, Integer> getSeguimiento() {
		return seguimiento;
	}


	public HashSet<Curso> getCursosPrevios() {
		return cursosPrevios;
	}


	public int consultarNivel(Alumno alumno) {
		if (getAlumnosMatriculados().contains(alumno)) {
			return this.nivel;
		}
		return -1;
	}

	
	public boolean superarNivel(Alumno alumno) {
		if (getAlumnosMatriculados().contains(alumno)) {
			int level = seguimiento.get(alumno);
			this.seguimiento.replace(alumno, level + 1);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean matricular(Alumno alumno) {
		if (getPrecioMatricula() - alumno.getCredito() <= 0) {
			for (Curso curso : cursosPrevios) {
				if (!curso.getAlumnosAptos().contains(alumno)) {
					return false;
				}
			}
			this.seguimiento.put(alumno, 0);
			super.matricular(alumno);
		}
		return false;
	}
	
	@Override
	protected boolean isApto(Alumno alumno) {
		return seguimiento.get(alumno) >= nivel / 2;
	}

}
