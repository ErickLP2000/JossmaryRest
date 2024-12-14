(function(){
    //debugger;
    var listaEditar = document.querySelectorAll(".editarProveedores");
    listaEditar.forEach(item => {
        item.addEventListener("click", e=>{
            document.getElementById('id').value = item.dataset.id;
            document.getElementById('txtRuc').value = item.dataset.ruc;
            document.getElementById('txtNombre').value = item.dataset.nombre;
            document.getElementById('txtDireccion').value = item.dataset.direccion;
            document.getElementById('txtCelular').value = item.dataset.celular;
            document.getElementById('cboEstado').value = item.dataset.estado;
            new bootstrap.Modal(document.getElementById('modalEditar')).show();
        })
    })
})();