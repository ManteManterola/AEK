package modelo;

public class Validator {
	    public static boolean validarDni(String dni) {
	        // El DNI debe tener exactamente 9 caracteres
	        if (dni.length() != 9) {
	            return false;
	        }

	        // Los primeros 8 caracteres deben ser dígitos
	        for (int i = 0; i < 8; i++) {
	            if (!Character.isDigit(dni.charAt(i))) {
	                return false;
	            }
	        }

	        // El último caracter debe ser una letra (mayúscula)
	        char lastChar = dni.charAt(8);
	        if (!Character.isLetter(lastChar) || !Character.isUpperCase(lastChar)) {
	            return false;
	        }

	        // Si pasa todas las validaciones anteriores, entonces el DNI es válido
	        return true;
	    }
	    
}
