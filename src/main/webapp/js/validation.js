const FLOAT_REGEX = /^-?\d+(?:\.\d+)?$/;



function funcClick() {
    const x = document.getElementById("x").value;
    const y = document.getElementById("y_value").value;
    const r = rValue;
    const click = document.getElementById("isClick_value").value;

    if (!r) {
        alert("Please select a value for R first");
        return;
    }

    if(!validationFloat(x)) {
        alert("X not Number");
        document.getElementById("x").value = "";
        return;
    }

    if(!validationFloat(y)) {
        alert("Y not Number");
        document.getElementById("x").value = "";
        return;
    }

    if (!domainFloat(parseFloat(x), -3., 5. )) {
        alert("X value out of bounds");
        document.getElementById("x").value = "";
        return;
    }

    if (!domainFloat(parseFloat(y), -2., 2.)) {
        alert("Y value out of bounds");
        document.getElementById("y_value").value = "";
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