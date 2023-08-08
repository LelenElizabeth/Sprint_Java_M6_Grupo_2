document.addEventListener("DOMContentLoaded", function() {
  const agregarFilaBtn = document.getElementById("agregarFila");
  const nuevasFilasDiv = document.getElementById("nuevasFilas");
  const contenedorGuardar = document.getElementById("contenedorGuardar");

  let filaCount = 1;

  agregarFilaBtn.addEventListener("click", () => {
    const nuevaFila = document.createElement("div");
    nuevaFila.className = "mb-2 fila";
    nuevaFila.innerHTML = `
      <div class="input-group">
          <input type="text" id="detalle${filaCount}" name="detalle" class="form-control col-3" required>
          <button type="button" class="btn btn-danger eliminar-btn " onclick="eliminarFila(this)">
          	<i class="bi bi-x-circle"></i>
          </button>
      </div>
    `;
    nuevasFilasDiv.appendChild(nuevaFila);
    filaCount++;
    // Mostrar el botón de "Guardar" después de agregar una fila
    contenedorGuardar.style.display = "block";
  });

  // Verificar si hay detalles agregados al cargar la página
  verificarDetalles();

  function verificarDetalles() {
    const filas = nuevasFilasDiv.getElementsByClassName("fila");
    if (filas.length === 0) {
      contenedorGuardar.style.display = "none";
    }
  }
});

function eliminarFila(btn) {
  const fila = btn.closest(".fila");
  fila.remove();
  verificarDetalles();
}

function verificarDetalles() {
  const filas = document.getElementsByClassName("fila");
  if (filas.length === 0) {
    contenedorGuardar.style.display = "none";
  }
}
