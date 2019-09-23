function submitUpdateForm(formData) {
    let keyValues = {};
    let id = 0;

    for (let element of formData.elements) {
        if (element.name) {
            if (element.name === "id") {
                id = element.value;
            } else {
                keyValues[element.name] = element.value;
            }
        }
    }

    console.log("http://35.246.32.85:9000/pets/" + id);
    console.log(keyValues);

    makeRequest("http://35.246.32.85:9000/pets/" + id, keyValues, "PUT")
        .then((data) => {
            console.log("it Worked!" + data);

            $('#updateFunctionality').modal('hide');
            $('.modal').on('hidden.bs.modal', function () {
                $(this).find('form')[0].reset();
            });

            window.location.href = window.location.href
        })
        .catch((data) => {
            console.log("It failed!" + data);
        });

    return false;
}