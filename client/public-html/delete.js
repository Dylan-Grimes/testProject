function deletePet() {

    var input = document.getElementById("idToDelete").value;

    console.log(input);

    makeRequest("http://35.246.32.85:8081/team", input , type = "DELETE")
        .then((data) => {
            console.log("Deleted" + data);
            window.location.href = window.location.href
        })
        .catch((data) => {
            console.log("It failed!" + data);
        })

        

}