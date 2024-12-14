(function(){
    //debugger;
    var listaEditar = document.querySelectorAll(".editarInsumo");
    listaEditar.forEach(item => {
        item.addEventListener("click", e=>{
            document.getElementById('id').value = item.dataset.id;
            document.getElementById('cboCategoria').value = item.dataset.categoria;
            document.getElementById('txtNombre').value = item.dataset.nombre;
            document.getElementById('txtColor').value = item.dataset.color;
            document.getElementById('txtTalla').value = item.dataset.talla;
            new bootstrap.Modal(document.getElementById('modalEditar')).show();
        })
    })
})();