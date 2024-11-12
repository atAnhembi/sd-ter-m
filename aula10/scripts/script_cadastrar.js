const btnCadastrar = document.getElementById("btn_cadastrar")
const txtId = document.getElementById("id")
const txtUsername = document.getElementById("username")
const txtName = document.getElementById("name")
const txtEmail = document.getElementById("email")

async function cadastrar(event) {
   event.preventDefault();
   let url = "https://jsonplaceholder.typicode.com/users"

   let resposta = await fetch( url,
    { 
        method: 'POST',
        headers:{
            'Content-Type':'application/json; charset=UTF-8'
        },
        body: JSON.stringify({
            "id": txtId.value,
            "username": txtUsername.value,
            "name": txtName.value,
            "email": txtEmail.value
        })
    }
   );

   console.log(resposta);
   
   if(resposta.status == 201) {
    alert('Cadastrado com sucesso');
   } else {
    alert("Erro ao cadastrar");
   }
}

btnCadastrar.addEventListener('click', cadastrar);