package subastas;

import java.util.LinkedList;

public class Subasta {
	private String producto;
	private Usuario propietario;
	protected boolean isCerrada;
	protected LinkedList<Puja> listaPujas;
	private Puja pujaMayor;

	public Subasta(String producto, Usuario propietario) {
		this.producto = producto;
		this.propietario = propietario;
		this.isCerrada = false;
		this.listaPujas = new LinkedList<Puja>();
		this.pujaMayor = null;
		this.propietario.addSubasta(this);

	}

	public String getProducto() {
		return producto;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public boolean isCerrada() {
		return isCerrada;
	}

	public LinkedList<Puja> getListaPujas() {
		return listaPujas;
	}

	public Puja getPujaMayor() {
		return pujaMayor;
	}

	public boolean pujaValida(Usuario pujador, double cantidad) {
		return ((!isCerrada) && (pujador.getCredito() >= cantidad) && (pujador != propietario)
				&& (pujaMayor == null || cantidad > pujaMayor.getCantidadPuja()));
	}

	public boolean pujar(Usuario pujador, double cantidad) {
		if (pujaValida(pujador, cantidad)) {
			Puja puja = new Puja(pujador, cantidad);
			listaPujas.add(puja);
			pujaMayor = puja;
			return true;
		}
		return false;

	}

	public boolean pujar(Usuario pujador) {
		if ((!isCerrada) && (!pujador.equals(propietario))) {
			Puja puja = new Puja(pujador, pujaMayor.getCantidadPuja() + 1);
			listaPujas.add(puja);
			pujaMayor = puja;
			return true;
		}
		return false;
	}

	public boolean ejecutar() {
		if (listaPujas.size() > 0 && !isCerrada) {
			propietario.incrementarCredito(pujaMayor.getCantidadPuja());
			pujaMayor.getPujador().decrementarCredito(pujaMayor.getCantidadPuja());
			isCerrada = true;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Subasta [producto=" + producto + ", propietario=" + propietario + ", isCerrada=" + isCerrada + ", pujaMayor=" + pujaMayor + "]";
	}

}
