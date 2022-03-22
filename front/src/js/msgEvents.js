const randomId = () => {
    let random = Math.floor(Math.random() * 10000)*10
    if (random > 9999 || random!= undefined) {
        return random;
    }
}

let userId = randomId();

document.querySelector('body').innerHTML+='<h1>'+ userId +'</h1>'

let text = document.getElementById("itext");
let idUser = document.getElementById("idUser"); 
let messages = document.getElementById("messages");
let eventSource = new EventSource("http://localhost:6500/subscribe?userId=" + userId);
let contador = 0;
let button = document.getElementById("buttons");

console.log(eventSource);
const scrollBottom = (e)=>{
    e.scrollTop= e.scrollHeight;
}

let form = document.querySelector('#msgEvents');

form.addEventListener("submit", (e)=>{
    e.preventDefault();
})

// ! evento click para enviar mensage

button.addEventListener("click", e => {


    if (text.value != "") {
        fetch("http://localhost:6500/dispatch?userId=" + idUser.value + "&message=" + text.value, { method: "POST" })
        document.getElementById("messages").innerHTML += `
        <div class="sending-content">
        <div id="message" class="sending">
            ${text.value}
        </div>
    </div>
            `
    
        text.value = ""
        fetch("http://localhost:6500/dispatch/clean?userId=" + idUser.value,
            {
                method: "GET",
                headers: {
                    'Content-Type': 'application/json'
                    // 'Content-Type': 'application/x-www-form-urlencoded',
                },
            });
        contador = 0;
        scrollBottom(messages);
    }
})

// ! evento input para llamar a los eventos del servidor

text.addEventListener("input", async ev => {
    let content = text.value;
    

    if (content.length > 0 && contador < 1) {

        await fetch("http://localhost:6500/dispatch?userId=" + idUser.value,
            {
                method: "GET",
                headers: {
                    'Content-Type': 'application/json'
                    // 'Content-Type': 'application/x-www-form-urlencoded',
                },
            });
        contador++;
        console.log("contador wrt", contador)

    } else if (content == "") {


        await fetch("http://localhost:6500/dispatch/clean?userId=" + idUser.value,
            {
                method: "GET",
                headers: {
                    'Content-Type': 'application/json'
                    // 'Content-Type': 'application/x-www-form-urlencoded',
                },
            });


        console.log("contador dr", contador)
        contador = 0;


    }
})


const initEvents = (eventSource) => {

    // ! incomming message
    eventSource.addEventListener("message", ev => {
        let data = JSON.parse(ev.data);
        
        messages.innerHTML += `
                        <div class="incoming-content">
                        <div id="message" class="incoming">
                            ${data.message}
                        </div>
                    </div>
                            `;
         scrollBottom(messages);
                            
    });

    eventSource.addEventListener("writting", ev => {

        document.getElementById("content-writting").innerHTML = `<span id="trol" ></span>`;

    });

    eventSource.addEventListener("clean", ev => {
        document.getElementById("content-writting").innerHTML = '';
    });
}

initEvents(eventSource);

