function search_Student(){
    let id = $("#option_students").val();
    var url = 'http://localhost:8080/'+id;

    fetch(url,{
        method: "GET"        
    }).then((response) => {
        return response.json();
    }).then((data) => {
        let students = data;
        $('#id_s').val(students["id"]);
        $('#nombre2').val(students["nombre"]);
        $('#apellido2').val(students["apellido"]);
        document.getElementById("sdocument").value = students["tipo_documento"];
        $('#documento2').val(students["documento"]);
        $('#email2').val(students["email"]);
        $('#fecha2').val(students["fecha_nacimiento"]);
        $('#estatura2').val(students["estatura"]);
        $('#peso2').val(students["peso"]);
        document.getElementById("sgenero").value = students["genero"];
        $('#pass2').val(students["password"]);
        $('#passc2').val(students["password"]);
    });
}