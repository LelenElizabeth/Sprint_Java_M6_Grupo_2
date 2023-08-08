// crearUsuario.js

document.addEventListener("DOMContentLoaded", function() {
  // Elementos del DOM
  const rolSelect = document.getElementById("rol");
  const formularioCliente = document.getElementById("formularioCliente");
  const formularioAdministrativo = document.getElementById("formularioAdministrativo");
  const formularioProfesional = document.getElementById("formularioProfesional");
  const formulario = document.getElementById("formulario");

  // Mostrar formulario Cliente al inicio
  formularioCliente.style.display = "block";

  // Cambiar formulario y mostrar campos según el rol seleccionado
  rolSelect.addEventListener("change", function() {
    const rolSeleccionado = rolSelect.value;

    // Mostrar el formulario correspondiente y ocultar los otros
    if (rolSeleccionado === "Cliente") {
      mostrarFormulario(formularioCliente);
      adminRequired(formularioAdministrativo, formularioProfesional, formularioCliente);
      formulario.action = "crear-cliente"; // Cambiar acción del formulario
    } else if (rolSeleccionado === "Administrativo") {
      mostrarFormulario(formularioAdministrativo);
      adminRequired(formularioCliente, formularioProfesional, formularioAdministrativo);
      formulario.action = "crear-administrativo"; // Cambiar acción del formulario
    } else if (rolSeleccionado === "Profesional") {
      mostrarFormulario(formularioProfesional);
      adminRequired(formularioCliente, formularioAdministrativo, formularioProfesional);
      formulario.action = "crear-profesional"; // Cambiar acción del formulario
    }
  });
});

// Mostrar un formulario y ocultar los otros
function mostrarFormulario(formulario) {
  const formularios = [formularioCliente, formularioAdministrativo, formularioProfesional];
  formularios.forEach(form => {
    form.style.display = form === formulario ? "block" : "none";
  });
}

// Desactivar el atributo required en campos no necesarios
function adminRequired(desactivarForm, desactivarForm2, activarForm) {
  disableRequired(desactivarForm);
  disableRequired(desactivarForm2);
  activateRequired(activarForm);
}

// Desactivar atributo required en campos del formulario
function disableRequired(form) {
  const requiredInputs = form.querySelectorAll("[required]");
  requiredInputs.forEach(input => {
    input.removeAttribute("required");
  });
}

// Activar atributo required en campos del formulario
function activateRequired(form) {
  const requiredInputs = form.querySelectorAll("input");
  requiredInputs.forEach(input => {
    input.setAttribute("required", "");
  });
}
