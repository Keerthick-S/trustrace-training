const correctMsg = document.getElementById('verify-msg');
const randomRgbColor = document.getElementById('rgb-color');
const newColor = document.getElementById('new-color');
const squareColors = document.getElementsByClassName('square');
let colors = []; 

init();

// newColor.addEventListener('click', function() {
//     colors.fill(null);
//     setCorrectColor();
//     setColorForSquares();
// })

function init() {
    setCorrectColor();
    setColorForSquares();
}

function setCorrectColor() {
    correctColor = randomColor();
    randomRgbColor.innerHTML = `${correctColor}`;
    randomIdx = randomIndex();
    console.log(randomIdx,correctColor);
    squareColors[randomIdx].style = `background-color: ${correctColor}`;
}

function setColorForSquares() {
    for(let i = 0; i < squareColors.length; i++) {
        color = randomColor();
        if(randomIdx !== i && !colors.includes(color)) {
            squareColors[i].style = `background-color: ${color}`;
            colors.push(color); 
        } 
    }
}

function randomIndex() {
    const index = Math.floor((Math.random() * 6));
    return index;
}

function randomColor() {
    const r = Math.floor((Math.random() * 256));
    const g = Math.floor((Math.random() * 256));
    const b = Math.floor((Math.random() * 256));
    return `rgb(${r}, ${g}, ${b})`;
}
