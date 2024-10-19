package co.Luky;


public class Usuario {
	private String username;
	private String password;

	public Usuario(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String toString() {
		return username + "-" + password;
	}
	public static Usuario fromString(String linea) {
	    // Elimina espacios al inicio y al final de la línea
	    linea = linea.trim();
	    
	    // Si la línea está vacía, lanzamos una excepción o simplemente ignoramos
	    if (linea.isEmpty()) {
	        throw new IllegalArgumentException("La línea está vacía");
	    }

	    // Dividimos la línea en dos partes usando el guion como separador
	    String[] partes = linea.split("-");
	    
	    // Comprobamos si hay exactamente dos partes
	    if (partes.length != 2) {
	        throw new IllegalArgumentException("Formato de línea incorrecto: " + linea);
	    }

	    // Eliminamos los espacios extra de cada parte
	    String User = partes[0].trim();
	    String Password = partes[1].trim();
	    
	    // Devolvemos el objeto Usuario
	    return new Usuario(User, Password);
	}


}
