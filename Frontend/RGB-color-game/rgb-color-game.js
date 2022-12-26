const correctMsg = document.getElementById('verify-msg');
const randomRgbColor = document.getElementById('rgb-color');
const newColor = document.getElementById('new-color');
const squareColors = document.querySelectorAll('.square');
let colors = []; 

init();

newColor.addEventListener('click', function() {
    correctMsg.innerHTML = ``;
    colors.fill(null);
    setCorrectColor();
    setColorForSquares();
})

function init() {
    setCorrectColor();
    setColorForSquares();
    checkColor();
}

function setCorrectColor() {
    correctColor = randomColor();
    randomRgbColor.innerHTML = `${correctColor}`;
    randomIdx = randomIndex();
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

function checkColor() {

    squareColors.forEach((color, index) => {
        color.addEventListener('click', function () {
        const clickedColor = color.style.backgroundColor;
        if(correctColor == clickedColor){
            correctMsg.innerHTML = `CORRECT`;
            correctMsg.style = `color: rgb(70, 207, 70)`;
            squareColors.forEach((anotherColor, anotherIndex) => {
                if(index != anotherIndex) {
                    anotherColor.style = `background-color: ${clickedColor}`;
                }
            })
        }
        else {
            correctMsg.innerHTML = `Try Again`;
            correctMsg.style = `color:Red`;
            color.style = 'background-color: black';
        }
        })
    })
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
