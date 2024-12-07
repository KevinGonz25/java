package Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

public class ListaCategorias implements Serializable {
	
	public ArrayList<Categoria> categorias;
	private static final long serialVersionUID = 1L;

	public ListaCategorias() {
		this.categorias = new ArrayList<>();
	}

	public void agregarCategoria(Categoria categoria) {
		if (buscarCategoriaPorId(categoria.getCodigo()) == null) {
			categorias.add(categoria);
		}
	}

	public void eliminarCategoriaPorId(String id) {
		Categoria categoria = buscarCategoriaPorId(id);
		if (categoria != null) {
			categorias.remove(categoria);
		}
	}

	public String toLinea() {
		String resultado = "";
		for (Categoria categoria : categorias) {
			resultado += categoria.toString() + "\n";
		}
		return resultado;
	}

	public Categoria buscarCategoriaPorId(String id) {
		for (Categoria categoria : categorias) {
			if (categoria.getCodigo().equals(id)) {
				return categoria;
			}
		}
		return null;
	}

	public String buscarCategoria(String id) {
		Categoria categoria = buscarCategoriaPorId(id);
		if (categoria != null) {
			return categoria.getNombre();
		}
		return null;
	}

	public JComboBox agregrarCategoriasAComboBox(JComboBox comboBox) {
        comboBox.removeAllItems();
        for (Categoria categoria : categorias) {
            comboBox.addItem(categoria.getNombre());
        }
        return comboBox;
    }

	public String[] CategoriasArreglo() {
		
        String[] nombres = new String[categorias.size()];
        for (int i = 0; i < categorias.size(); i++)
        {
            nombres[i] = categorias.get(i).getNombre();
        }
        return nombres;
    }

	public void cargarCategorias(ArrayList<String[]> categoriasString) {
	    for (String[] categoriaString : categoriasString) {
	        try {
	            String idCategoria = categoriaString[0]; 
	            String nombreCategoria = categoriaString[1];
	            String descripcionCategoria = categoriaString[2];
	            Categoria categoria = new Categoria(idCategoria, nombreCategoria, descripcionCategoria);
	            this.agregarCategoria(categoria);
	        } catch (ArrayIndexOutOfBoundsException e) {
	            System.err.println("Array incompleto, saltando...");
	        }
	    }
	}

	public DefaultListModel<Categoria> generarModeloCategorias() {
		DefaultListModel<Categoria> modelo = new DefaultListModel<>();
		for (Categoria categoria : categorias)
		{
			modelo.addElement(categoria);
		}
		return modelo;
	}
	
	
	
	
	
	
	
	
	
	
}
