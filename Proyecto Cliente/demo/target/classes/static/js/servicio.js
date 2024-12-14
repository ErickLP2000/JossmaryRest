(function(){
    //debugger;
    var listaEditar = document.querySelectorAll(".editarServicio");
    listaEditar.forEach(item => {
        item.addEventListener("click", e=>{
            document.getElementById('id').value = item.dataset.id;
            document.getElementById('cboCliente').value = item.dataset.cliente;
            document.getElementById('cboServicio').value = item.dataset.espservicio;
            document.getElementById('txtDescripcion').value = item.dataset.descripcion;
            new bootstrap.Modal(document.getElementById('modalEditar')).show();
        })
    })
})();