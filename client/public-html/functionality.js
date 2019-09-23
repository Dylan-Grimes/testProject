function getData() {
    teamRequest("GET");
}

function postTeam(event) {
    event.preventDefault();
    let data = event.target.teamValue.value;
    if(data){
        teamRequest("POST", {"text": data});
    } 
    event.target.teamValue.value = "";
    return false;
}


function updateTeam(event){
    event.preventDefault();
    let body ={
        id: event.target.parentElement.parentElement.id,
        text: event.target.teamText.value
    }   

    teamRequest("PUT", body);
}

function deleteTeam(event){
    let id = event.target.parentElement.id;
    teamRequest("DELETE", "", id);
}

function showData(request) {
    let list = document.getElementById("teams");
    list.innerHTML = "";

    let teams = JSON.parse(request.response);

    let makeTeam = (team) => {
        let listItem = document.createElement("li");
        
        let para = document.createElement("p");
        para.innerText = team.text;
        para.setAttribute("onclick", "addInput(event)")
        listItem.setAttribute("id", team.id);
        
        let button = document.createElement("button");
        button.innerText = "Delete";
        button.setAttribute("onclick", "deleteTeam(event)")
        listItem.appendChild(para);
        listItem.appendChild(button);
        list.appendChild(listItem)
    }

    teams.forEach(team => makeTeam(team))
}

function addInput(event){
    let team = event.target;
    team.removeAttribute("onclick");
    let text = team.innerText;
    team.innerText = "";
    
    let form = document.createElement("form");
    let inputBox = document.createElement("input");
    form.setAttribute("onsubmit", "updateTeam(event)");
    inputBox.type = "text";
    inputBox.name = "teamText";
    inputBox.value = text;
    let submit = document.createElement("submit");
    submit.className = "hidden";
    form.appendChild(inputBox);
    form.appendChild(submit);
    team.appendChild(form);
}

function teamRequest(method, body, extension) {
    if (!extension){
        extension = "";
    } 
    let endpoint = "team/" + extension;
    let callback;
    method == "GET" ? callback = showData : callback = getData; 
    let headers = {
        "Content-Type": "application/json"
    }

    body ? body = JSON.stringify(body) : body = undefined;

    httpRequest(method, endpoint, callback, headers, body);
}


function httpRequest(method, endpoint, callback, headers, body){
    let URL = "http://" + location.host + ":8081/";
    let request = new XMLHttpRequest();
    console.log(URL + endpoint)
    request.open(method, URL + endpoint);
    request.onload = () => {
        callback(request);
    }
    
    for(let key in headers){
        request.setRequestHeader(key, headers[key]);
    }

    body ? request.send(body) : request.send();
}

getData();
