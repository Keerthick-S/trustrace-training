function sayHai(message) {
    console.log(`haii ${this.name} ${message}`);
}

const valueObj = {
    name : 'keerthick',
};

sayHai.call(valueObj, 'how are you','!!!');
sayHai.apply(valueObj, ['how are you', '!!!']);

const value2 = sayHai.bind(valueObj, 'how are u', '!!!');
value2();
