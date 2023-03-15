const color1 = document.getElementById('color1');
const color2 = document.getElementById('color2');
const body = document.querySelector('body');
const randomButton = document.getElementById('randomButton');
const resetButton = document.getElementById('resetButton');
const gradientText = document.getElementById('gradientText');

function setGradient() {
	const gradient = `linear-gradient(to right, ${color1.value}, ${color2.value})`;
	body.style.background = gradient;
	gradientText.value = gradient;
}

function randomColor() {
	const randomHexColor = '#' + Math.floor(Math.random() * 16777215).toString(16);
	return randomHexColor;
}

randomButton.addEventListener('click', () => {
	const randomColor1 = randomColor();
	const randomColor2 = randomColor();
	color1.value = randomColor1;
	color2.value = randomColor2;
	setGradient();
});

resetButton.addEventListener('click', () => {
	const gradient = `linear-gradient(to right, #ffff00, #ff0000)`;
	document.body.style.background = gradient;
    document.getElementById("color1").value = "#ffff00";
    document.getElementById("color2").value = "#ff0000";
    gradientText.value = gradient;
});

color1.addEventListener('change', setGradient);
color2.addEventListener('change', setGradient);

// Set initial background gradient
setGradient();
