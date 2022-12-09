const FLOAT_REGEX = /^-?\d+(?:\.\d+)?$/;

function enterOff() {
    let b = event.keyCode;
    document.forms[0].onsubmit = function() {
        let a = 13 !== b;
        b = "";
        return a
    }
}

function funcClick() {
    const x = document.getElementById("x").value;
    const y = document.getElementById("y_value").value;
    if (!rValue) {
        alert("Please select a value for R first");
        return;
    }

    if(!validationFloat(x)) {
        alert("X not Number");
        document.getElementById("x").value = "";
        return;
    }



    if (!domainFloat(parseFloat(x), -3.01, 5.001 )) {
        alert("X value out of bounds");
        document.getElementById("x").value = "";
        return;
    }

    if(!validationFloat(y)) {
        alert("Y not Number");
        document.getElementById("x").value = "";
        return;
    }

    document.forms["input-form"].submit();

}
function domainFloat(floatNum, leftBorder, rightBorder) {
    if(floatNum >= rightBorder || floatNum <= leftBorder) {
        return false;
    }
    return true;
}

function validationFloat(strFloat) {
    return FLOAT_REGEX.test(strFloat);
}


document.getElementById('input-form').addEventListener('change', () => drawGraph());