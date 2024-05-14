package modelo;

public class Validator {

	// Metodo que verifica que el dni tenga el formato correcto
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

	
	//Metodo que verifica que la cadena que se le pasa es un numero entero
	public static boolean esNumeroEntero(String cadena) {
		try {
			// Intenta convertir la cadena a un número entero
			Integer.parseInt(cadena);
			// Si la conversión tiene éxito, la cadena es un número entero válido
			return true;
		} catch (NumberFormatException e) {
			// Si ocurre una excepción al intentar convertir la cadena a un número entero,
			// significa que la cadena no es un número entero válido
			return false;
		}
	}
}
