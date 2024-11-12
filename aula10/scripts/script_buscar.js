const btnBuscar = document.getElementById("btn_buscar")
const finId = document.getElementById("find_id")
const txtUsername = document.getElementById("username")
const txtName = document.getElementById("name")
const txtEmail = document.getElementById("email")

async function buscar() {
    // let url = "http://localhost:8080/product/"
    let url = "https://jsonplaceholder.typicode.com/users/"
    let resposta =  await fetch(url + finId.value);

    // console.log(resposta);

    if(resposta.status == 200){
        let dados = await resposta.json();
    
        // console.log(dados);
        
        txtUsername.value = dados["username"]
        txtName.value = dados["name"]
        txtEmail.value = dados["email"]
    }else {
        txtUsername.value = "Não encontrado"
    }
    
}

btnBuscar.addEventListener('click', buscar);