package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Log {

	private static Logger log = null;

	public static void registrarInfo(Class clase, TipoLog tipo, String mensaje) {
		log = (Logger) LogManager.getLogger(clase);
		switch (tipo) {
		case DEBUG:
			log.debug(mensaje);
			break;
		case ERROR:
			log.error(mensaje);
			break;
		case FATAL:
			log.fatal(mensaje);
			break;
		case INFO:
			log.info(mensaje);
			break;
		case WARNING:
			log.warn(mensaje);
			break;
		default:
			log.debug("Tipo de Log desconocido :"+ tipo);
			break;
		}
	}

}
