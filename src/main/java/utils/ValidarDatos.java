package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * La clase ValidarDatos proporciona métodos para validar diferentes tipos de
 * datos.
 */
public class ValidarDatos {
	/**
	 * Constructor de la clase ValidarDatos.
	 */
	public ValidarDatos() {
	}

	/**
	 * Valida si una cadena de caracteres tiene un rango válido.
	 *
	 * @param entrada la cadena de caracteres a validar.
	 * @param min     el valor mínimo del rango.
	 * @param max     el valor máximo del rango.
	 * @return true si la cadena de caracteres tiene un rango válido, false de lo
	 *         contrario.
	 */
	public static boolean RangoCaracteres(String entrada, int min, int max) {
		boolean retorno;
		try {
			if (entrada.length() < min || entrada.length() > max) {
				retorno = false;
			} else {
				retorno = true;
			}
		} catch (Exception e) {
			retorno = false;
		}
		return retorno;
	}

	/**
	 * Verifica si una cadena de caracteres es obligatoria (no nula o vacía).
	 *
	 * @param entrada la cadena de caracteres a verificar.
	 * @return true si la cadena de caracteres es obligatoria, false de lo
	 *         contrario.
	 */

	public static boolean esObligatorio(String entrada) {
		boolean retorno = true;
		if (entrada == null || entrada == "") {
			retorno = false;
		}
		return retorno;
	}

	/**
	 * Valida si una cadena de caracteres representa una fecha válida en formato
	 * "dd/MM/yyyy".
	 *
	 * @param fecha la cadena de caracteres que representa la fecha.
	 * @return true si la cadena de caracteres representa una fecha válida , false de
	 *         lo contrario.
	 */

	public static boolean Fecha(String fecha) {
		boolean retorno;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			LocalDate.parse(fecha, formatter);
			retorno = true;
		} catch (Exception e) {
			System.out.println("utils.ValidarDatos.validarFecha() :" + e);
			retorno = false;
		}
		return retorno;
	}

	/**
	 * Valida si un número de rut o run es válido.
	 *
	 * @param rutRunString el número de rut o run a validar.
	 * @param rol          el rol asociado al número de rut o run.
	 * @return true si el número de rut o run es válido, false de lo contrario.
	 */

	public static boolean RutRun(String rutRunString) {
		boolean retorno = true;
		int rutRun;
		try {
			rutRun=Integer.valueOf(rutRunString);
			if (rutRun >= 99999999) {
				retorno = false;
			}
		} catch (Exception e) {
			System.out.println("utils.ValidarDatos.validarRutRun() :" + e);
			retorno = false;
		}
		return retorno;
	}

	/**
	 * Valida si una edad está dentro de un rango válido.
	 *
	 * @param edad la edad a validar.
	 * @param min  la edad mínima permitida.
	 * @param max  la edad máxima permitida.
	 * @return true si la edad está dentro del rango válido, false de lo contrario.
	 */

	public static boolean Edad(String edad, int min, int max) {
		boolean retorno = false;
		int edadInt;
		try {
			edadInt= Integer.valueOf(edad);
			if (edadInt >= min && edadInt < max) {
				retorno = true;
			}
		} catch (Exception e) {
			System.out.println("utils.ValidarDatos.validarEdad() :" + e);
			retorno = false;
		}
		return retorno;
	}

    public static boolean esDiaValido(String dia) {
        String[] diasValidos = {"lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo"};
        boolean retorno = false;
        for (String diaValido : diasValidos) {
            if (diaValido.equalsIgnoreCase(dia)) {
               retorno = true;
            }
        }
        return retorno;
    }
    
    public static boolean esHoraValida(String hora) {
        try {
            String[] partes = hora.split(":");
            int horas = Integer.parseInt(partes[0]);
            int minutos = Integer.parseInt(partes[1]);
            return horas >= 0 && horas <= 23 && minutos >= 0 && minutos <= 59;
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
        	System.out.println("utils.ValidarDatos.esHoraValida() :"+e);
            return false;
        }
    }


	public static boolean Numero(String num, int min, int max) {
		boolean retorno = false;
		int entero;
		try {
			entero= Integer.valueOf(num);
			if (entero >= min && entero < max) {
				retorno = true;
			}
		} catch (Exception e) {
			System.out.println("utils.ValidarDatos.validarNumero() :" +e);
			retorno = false;
		}
		return retorno;
	}
}
