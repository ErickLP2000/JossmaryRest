(function(){
    //debugger;
    var listaEditar = document.querySelectorAll(".editarMarcainsu");
    listaEditar.forEach(item => {
        item.addEventListener("click", e=>{
            document.getElementById('id').value = item.dataset.id;
            document.getElementById('txtNombre').value = item.dataset.nombre;
            new bootstrap.Modal(document.getElementById('modalEditar')).show();
        })
    })
})();