const formDataObj = {};

function addTeam(data) {

    for (let element of data) {
        if (element.name) {
            formDataObj[element.name] = element.value;
        }
    }

    makeRequest("http://http://34.89.70.8:8081/team", formDataObj, type = "POST")
        .then((data) => {
            console.log("it Worked!" + data);

            $('#exampleModalCenter').modal('hide');
            $('.modal').on('hidden.bs.modal', function () {
                $(this).find('form')[0].reset();
            });

            window.location.href = window.location.href;
        })
        .catch((data) => {
            console.log("It failed!" + data);
        })

    console.log(formDataObj);



    return false;
}