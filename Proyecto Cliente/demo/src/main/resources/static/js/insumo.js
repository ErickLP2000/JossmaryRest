(function(){
    //debugger;
    var listaEditar = document.querySelectorAll(".editarInsumo");
    listaEditar.forEach(item => {
        item.addEventListener("click", e=>{
            document.getElementById('id').value = item.dataset.id;
            document.getElementById('cboCategoria').value = item.dataset.categoria;
            document.getElementById('cboProveedor').value = item.dataset.proveedor;
            document.getElementById('cboMarca').value = item.dataset.marca;
            document.getElementById('txtNombre').value = item.dataset.nombre;
            document.getElementById('txtColor').value = item.dataset.color;
            document.getElementById('txtDescripcion').value = item.dataset.descripcion;
            new bootstrap.Modal(document.getElementById('modalEditar')).show();
        })
    })
})();