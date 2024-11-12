const btnBuscar = document.getElementById("btn_buscar")
const finId = document.getElementById("find_id")
const username = document.getElementById("username")
const name = document.getElementById("name")
const email = document.getElementById("email")

async function buscar() {
    let url = "https://jsonplaceholder.typicode.com/users/"
    let resposta =  await fetch(url + finId.value);

    console.log(resposta);
    
}

btnBuscar.addEventListener('click', buscar);