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
	    linea = linea.trim();
	    
	    if (linea.isEmpty()) {
	        throw new IllegalArgumentException("La línea está vacía");
	    }
	    String[] partes = linea.split("-");
	    
	    if (partes.length != 2) {
	        throw new IllegalArgumentException("Formato de línea incorrecto: " + linea);
	    }

	    String User = partes[0].trim();
	    String Password = partes[1].trim();
	    return new Usuario(User, Password);
	}


}
