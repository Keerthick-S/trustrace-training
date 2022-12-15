// const a = new Promise((resolve, reject) => {
//     setTimeout(() => {
//         resolve('success');
//     }, 2000);
// })

// const a = new Promise((resolve, reject) => {
//     setTimeout(() => {
//         reject('fail');
//     }, 2000);
// })

// a.then(value => {
//     console.log(value);
// })


// call Back ..
// const a = (val, callback) => {
//     return callback(val + 10)
// }

// const callback = (val) => {
//     return val + 20;
// }

// console.log(a(2, callback));


const a = val => new Promise((resolve, reject) => {
    setTimeout(() => {
        console.log('ok');
    }, 5000);
    resolve(val + 10);
})

a(2).then((x) => {

   return x + 20;

}).then(x => {
    console.log(x);
    return x + 10;
}).then(x => {
    console.log(x);
})