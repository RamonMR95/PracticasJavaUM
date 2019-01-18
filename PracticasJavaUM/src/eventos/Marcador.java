package eventos;

public class Marcador {
	private final int tanteoLocal;
	private final int tanteoVisitante;

	public Marcador(int tanteoLocal, int tanteoVisitante) {
		this.tanteoLocal = tanteoLocal;
		this.tanteoVisitante = tanteoVisitante;
	}

	public int getTanteoLocal() {
		return tanteoLocal;
	}

	public int getTanteoVisitante() {
		return tanteoVisitante;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tanteoLocal;
		result = prime * result + tanteoVisitante;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marcador other = (Marcador) obj;
		if (tanteoLocal != other.tanteoLocal)
			return false;
		if (tanteoVisitante != other.tanteoVisitante)
			return false;
		if (tanteoLocal == other.tanteoLocal && tanteoVisitante == other.tanteoVisitante)
			return true;
		return true;
	}

	@Override
	public String toString() {
		return "Marcador [(tanteoLocal=" + tanteoLocal + ", tanteoVisitante=" + tanteoVisitante + ")]";
	}

}
