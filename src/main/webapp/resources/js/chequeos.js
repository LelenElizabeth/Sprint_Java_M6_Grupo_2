document.addEventListener("DOMContentLoaded", function() {
    const agregarFilaBtn = document.getElementById("agregarFila");
    const nuevasFilasDiv = document.getElementById("nuevasFilas");
    const contenedorGuardar = document.getElementById("contenedorGuardar");

    let filaCount = 1;

    agregarFilaBtn.addEventListener("click", () => {
        const nuevaFila = document.createElement("div");
        nuevaFila.innerHTML = `
            <div class="mb-2">
                <label for="detalle${filaCount}">Detalle:</label>
                <input type="text" id="detalle${filaCount}" name="detalle" required>
            </div>
        `;
        nuevasFilasDiv.appendChild(nuevaFila);
        filaCount++;
        // Mostrar el botón de "Guardar" después de agregar una fila
        contenedorGuardar.style.display = "block";
    });
});
