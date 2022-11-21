const FLOAT_REGEX = /^-?\d+(?:\.\d+)?$/;



function funcClick() {
    const x = document.getElementById("x").value;

    if(!validationFloat(x)) {
        alert("X not Number");
        document.getElementById("x").value = "";
        return;
    }
    if(!domainFloat(parseFloat(x), -3., 5. )) {
        alert("X value out of bounds");
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


document.getElementById('input-form').addEventListener('change', () => runGrapher().drawGraph());