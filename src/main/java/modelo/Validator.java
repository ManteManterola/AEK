package modelo;

public class Validator {

	// Metodo que verifica que el dni tenga el formato correcto
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

	
	//Metodo que verifica que la cadena que se le pasa es un numero entero
	public static boolean esNumeroEntero(String cadena) {
		try {
			// Intenta convertir la cadena a un n�mero entero
			Integer.parseInt(cadena);
			// Si la conversi�n tiene �xito, la cadena es un n�mero entero v�lido
			return true;
		} catch (NumberFormatException e) {
			// Si ocurre una excepci�n al intentar convertir la cadena a un n�mero entero,
			// significa que la cadena no es un n�mero entero v�lido
			return false;
		}
	}
}
