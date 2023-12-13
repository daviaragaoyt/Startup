const signInBtn = document.getElementById("signIn");
const signUpBtn = document.getElementById("signUp");
const fistForm = document.getElementById("form1");
const secondForm = document.getElementById("form2");
const container = document.querySelector(".container");
const users =[];

//VALIDAÇÃO DO CADASTRE-SE JÁ:

function submitForm() {
    var form = document.getElementById("form1");
    var nome = form["name"].value;
    var senha = form["senha"].value;
    var email = form["email"].value;
    var idade = form["idade"].value;

    if (nome === "") {
        alert("Por favor, preecha seu nome");
        return;
    }

    if (senha === "") {
        alert("Por favor, preecha seu senha");
        return;
    }

    if (email === "") {
        alert("Por favor, preecha seu email");
        return;
    }

    if (idade) {
        if (parseInt(idade) < 18) {
            alert("Precisa ser maior que 18");
            return;
        }
    } else {
        alert("Por favor, preecha seu idade");
        return
    }

    window.location.replace("./cadastro/cad.html");

    function submitForm() {
        var form = document.getElementById("form1");
        var nome = form["name"].value;
        var senha = form["senha"].value;
        var email = form["email"].value;
        var idade = form["idade"].value;
    
        // Verifica se o usuário já está registrado
        const userExists = users.some(user => user.nome === nome);
        if (userExists) {
            alert("Usuário já registrado. Por favor, faça login.");
            return;
        }
    
        // Adiciona o usuário à lista de usuários registrados (simulação)
        users.push({ nome, senha, email, idade });
    
        // Redireciona para a página de cadastro bem-sucedido ou outra ação
        window.location.replace("./cadastro/cad.html");
    }
}

function submitForm2() {
    var form = document.getElementById("form2");
    var nome2 = form["name2"].value;
    var senha2 = form["senha2"].value;


    if (nome2 === "") {
        alert("Por favor, preecha seu nome");
        return;
    }

    if (senha2 === "") {
        alert("Por favor, preecha seu senha");
        return;
    }

    window.location.replace("./home/init.html");

    function submitForm2() {
        var form = document.getElementById("form2");
        var nome2 = form["name2"].value;
        var senha2 = form["senha2"].value;
    
        // Verifica se o usuário está registrado
        const user = users.find(user => user.nome === nome2 && user.senha === senha2);
        if (!user) {
            alert("Credenciais inválidas. Por favor, tente novamente.");
            return;
        }
    
        // Redireciona para a página de login bem-sucedido ou outra ação
        window.location.replace("./home/init.html");
    }
}

signInBtn.addEventListener("click", () => {
    container.classList.remove("right-panel-active");
});

signUpBtn.addEventListener("click", () => {
    container.classList.add("right-panel-active");
});

fistForm.addEventListener("submit", (e) => e.preventDefault());
secondForm.addEventListener("submit", (e) => e.preventDefault());