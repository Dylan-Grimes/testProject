function readPets() {

    makeRequest("http://35.246.32.85:9000/pets").then((data) => {
        console.log(data);

        let petData = JSON.parse(data);

        console.log(petData);

        let petInfo = [];
        let pets;

        for (let p of petData) {
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