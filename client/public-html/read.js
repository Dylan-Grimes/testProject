function readPets() {

    makeRequest("http://34.89.70.8:9000").then((data) => {
        console.log(data);

        let teamData = JSON.parse(data);

        console.log(teamData);

        let petInfo = [];
        let pets;

        for (let p of teamData) {
            pets = [];

            pets.push(p.id);
            pets.push(p.name);
            pets.push(p.type);
            pets.push(p.age);
            pets.push(p.colour);

            petInfo.push(pets);

            console.log(pets);
        }

        for (let pet of petInfo) {
            inTable(pet);
        }

    });
}


function inTable(data) {
    let tableBody = document.getElementById("tableBody");
    let contInner;

    let container = document.createElement("tr");
    tableBody.appendChild(container);

    for (let pet of data) {
        contInner = document.createElement("td");
        contInner.innerHTML = pet;
        container.appendChild(contInner);
    }

}