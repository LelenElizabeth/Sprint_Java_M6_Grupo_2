// Función para validar el formulario
function validarCampos() {
	// Obtener los valores de los campos del formulario
	var lugar = document.querySelector('input[name="lugar"]').value;
	var comentarios = document.querySelector('textarea[name="comentarios"]').value;

	// Variable para controlar si hay errores
	var errores = false;


	// Validar lugar (obligatorio, mínimo 10 caracteres, máximo 50)
	if (lugar.trim() === '') {
		mostrarError('lugar','input', 'El lugar es obligatorio');
		errores = true;
	} else if (lugar.length < 10 || lugar.length > 50) {
		mostrarError('lugar','input', 'El lugar debe tener entre 10 y 50 caracteres');
		errores = true;
	}else{
		document.querySelector('input[name="lugar"]').style.borderColor = '';
	}

	
	// Validar Detalle (obligatorio, mínimo 5 caracteres, máximo 100)
	if (comentarios.trim() === '') {
		mostrarError('detalle','textarea', 'El detalle es obligatorio');
		errores = true;
	} else if (comentarios.length < 5 || comentarios.length > 200) {
		mostrarError('comentarios','textarea', 'El comentario debe tener entre 5 y 100 caracteres');
		errores = true;
	}else{
		document.querySelector('textarea[name="comentarios"]').style.borderColor = '';
	}
	// Devolver true si no hay errores, o false si hay errores
	return !errores;
}

/// Función para mostrar una alerta de error
function mostrarError(campo, param, mensaje) {
	var elementoCampo = document.querySelector(param+'[name="' + campo + '"]');
	var alertaError = document.createElement('div');
	alertaError.className = 'alert alert-danger alerta';
	alertaError.textContent = mensaje;
	elementoCampo.parentNode.insertBefore(alertaError, elementoCampo);

	elementoCampo.style.borderColor = 'red';

	elementoCampo.addEventListener('mouseover', function() {
		alertaError.style.display = 'block';
	});

	elementoCampo.addEventListener('mouseout', function() {
		alertaError.style.display = 'none';
	});
}


// Agregar evento al formulario para ejecutar la validación al enviar
var formulario = document.querySelector('form');
formulario.addEventListener('submit', function(event) {
	event.preventDefault(); // Evitar que el formulario se envíe automáticamente

	if (validarCampos()) {
		formulario.submit(); // Enviar el formulario si pasa la validación
	}
});