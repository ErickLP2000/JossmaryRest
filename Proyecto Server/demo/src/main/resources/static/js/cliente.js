(function(){
    //debugger;
    var listaEditar = document.querySelectorAll(".editarCliente");
    listaEditar.forEach(item => {
        item.addEventListener("click", e=>{
            document.getElementById('id').value = item.dataset.id;
            document.getElementById('cboDocumento').value = item.dataset.documento;
            document.getElementById('txtNumdoc').value = item.dataset.numdoc;
            document.getElementById('txtNombre').value = item.dataset.nombre;
            document.getElementById('txtPaterno').value = item.dataset.paterno;
            document.getElementById('txtMaterno').value = item.dataset.materno;
            document.getElementById('cboDistrito').value = item.dataset.distrito;
            document.getElementById('txtDireccion').value = item.dataset.direccion;
            document.getElementById('cboTipocliente').value = item.dataset.tipocliente;
            document.getElementById('txtCelular').value = item.dataset.celular;
            new bootstrap.Modal(document.getElementById('modalEditar')).show();
        })
    })
})();