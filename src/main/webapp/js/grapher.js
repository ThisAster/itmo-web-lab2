/** @type {HTMLCanvasElement} */
const canvas = document.getElementById("graph");
const width = canvas.width;
const height = canvas.height;
const ctx = canvas.getContext("2d");
let rValue = "";
const rCacheKey = 'R';

document.addEventListener("DOMContentLoaded", function () {
    loadDataFromLocalStorage();
    drawGraph();
});

function loadDataFromLocalStorage() {
    const r = localStorage.getItem(rCacheKey);
    if (r) {
        setR(r);
        const rCheckbox = document.getElementById(`r${r}`);
        if(rCheckbox){
            rCheckbox.checked = true;
        }
        return {rCheckbox};
    }
}

function clean() {
    if (localStorage.getItem(rCacheKey)) {
        localStorage.clear();
    }
}



const FIGURE_COLOR = "#567efb99";
const POINT_COLOR = "#4A76FE99";

function drawGraph() {
    ctx.font = "13px sans-serif";
    ctx.fillStyle = "#FFF";
    ctx.fillRect(0, 0, width, height);

    ctx.fillStyle = FIGURE_COLOR;
    // 1st quadrant rectangle
    ctx.fillRect(width / 2, height / 3, width / 3, height / 6);
    canvas.onmousemove = (e) => {
        drawGraph();
        let isMainScreen = !document.URL.includes('x_coord');
        if(isMainScreen){
            ctx.fillStyle = POINT_COLOR;
            ctx.beginPath();
            ctx.arc(e.offsetX, e.offsetY, 5, 0, Math.PI * 2);
            ctx.fill();
        }
    };

    // 2nd quadrant triangle
    ctx.beginPath();
    ctx.moveTo(width / 2, height / 3);
    ctx.lineTo((5 * width) / 10, height / 2);
    ctx.lineTo(width / 3, height / 2);
    ctx.fill();

    ctx.beginPath();
    ctx.moveTo(0, height / 2);
    ctx.lineTo(width, height / 2);
    ctx.lineTo(width - 10, height / 2 - 10);
    ctx.moveTo(width, height / 2);
    ctx.lineTo(width - 10, height / 2 + 10);
    ctx.stroke();

    ctx.beginPath();
    ctx.moveTo(width / 2, height);
    ctx.lineTo(width / 2, 0);
    ctx.lineTo(width / 2 - 10, 10);
    ctx.moveTo(width / 2, 0);
    ctx.lineTo(width / 2 + 10, 10);
    ctx.stroke();

    // 3nd quadrant sector
    ctx.beginPath();
    ctx.arc(width / 2, height / 2, width / 3, -3.14, Math.PI / 2, true);
    ctx.lineTo(width / 2, height / 2);
    ctx.fill();

    ctx.fillStyle = "#000";
    const labels = ["-R", "-R/2", "", "R/2", "R"];

    for (let i = 1; i < 6; i++) {
        ctx.beginPath();
        ctx.moveTo((i * width) / 6, height / 2 - 5);
        ctx.lineTo((i * width) / 6, height / 2 + 5);
        ctx.moveTo(width / 2 - 5, (i * height) / 6);
        ctx.lineTo(width / 2 + 5, (i * height) / 6);
        ctx.stroke();

        ctx.textAlign = "center";
        ctx.textBaseline = "bottom";
        ctx.fillText(labels[i - 1], (i * width) / 6, height / 2 - 7);

        ctx.textAlign = "left";
        ctx.textBaseline = "middle";
        ctx.fillText(labels[i - 1], width / 2 + 7, height - (i * height) / 6);
    }


    POINTS.forEach((point, index) => {
        const x = ((point.x / rValue) * width) / 3 + width / 2;
        const y = ((-point.y / rValue) * height) / 3 + height / 2;

        ctx.fillStyle = point.color;
        ctx.beginPath();
        ctx.arc(x, y, 5, 0, Math.PI * 2);
        ctx.fill();
        ctx.closePath();
    });
}

function setActiveButton(parentParameter, element) {
    const parameterElement = document.getElementById(parentParameter);
    const buttons = parameterElement.getElementsByTagName("button");
    for (const button of buttons) {
        button.className = "";
    }
    if (element) {
        element.className = "active";
    }
}

function setY(newValue, element) {
    const yButton = document.getElementById("y_value");
    yButton.value = newValue;
    setActiveButton("y", element);
}

function setX(newValue) {
    const xInput = document.getElementById("x");
    xInput.value = newValue;
}

function setR(newValue) {
    const rButton = document.getElementById("r_value");
    if(rButton){
        rButton.value = newValue;
    }
    rValue = parseFloat(newValue);
    localStorage.setItem(rCacheKey, newValue);
}


drawGraph();


canvas.addEventListener('click', (e) => {
    if (!rValue) {
        alert("Please select a value for R first");
        return;
    }

    const xClicked =
        Math.round(((2 * e.offsetX) / width - 1) * rValue * 1.5 * 100) / 100;
    const yClicked =
        Math.round(((-2 * e.offsetY) / height + 1) * rValue * 1.5 * 100) / 100;

    if(xClicked>5||xClicked<-3) {
        alert("x coordinate out of range(-3,5)");
        return;
    }
    if(yClicked>3||yClicked<-5) {
        alert("y coordinate out of range(-5,3)");
        return;
    }

    setX(`${xClicked}`);
    setY(`${yClicked}`);

    document.forms["input-form"].submit();
});
