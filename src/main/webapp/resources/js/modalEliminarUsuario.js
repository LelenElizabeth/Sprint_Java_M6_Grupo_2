// Obtener referencia al modal y al formulario
    const eliminarModal = document.getElementById('eliminarModal');
    const eliminarUsuarioForm = document.getElementById('eliminarUsuarioForm');

    // Función para mostrar el modal de confirmación de eliminación
    function mostrarModalEliminar(id) {
        // Configurar el valor del campo de ID en el formulario
        eliminarUsuarioForm.querySelector('input[name="idRescatado"]').value = id;

        // Mostrar el modal
        const bootstrapModal = new bootstrap.Modal(eliminarModal);
        bootstrapModal.show();
    }

    // Asignar evento clic a los botones de eliminar
    const botonesEliminar = document.querySelectorAll('.eliminar-usuario-btn');
    botonesEliminar.forEach(btn => {
        btn.addEventListener('click', () => {
            const id = btn.dataset.userId;
            mostrarModalEliminar(id);
        });
    });