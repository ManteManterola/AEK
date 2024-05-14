package modelo;

public class Validator {
	    public static boolean validarDni(String dni) {
	        // El DNI debe tener exactamente 9 caracteres
	        if (dni.length() != 9) {
	            return false;
	        }

	        // Los primeros 8 caracteres deben ser d�gitos
	        for (int i = 0; i < 8; i++) {
	            if (!Character.isDigit(dni.charAt(i))) {
	                return false;
	            }
	        }

	        // El �ltimo caracter debe ser una letra (may�scula)
	        char lastChar = dni.charAt(8);
	        if (!Character.isLetter(lastChar) || !Character.isUpperCase(lastChar)) {
	            return false;
	        }

	        // Si pasa todas las validaciones anteriores, entonces el DNI es v�lido
	        return true;
	    }
	    
}
