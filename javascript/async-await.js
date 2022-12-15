async function func() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(1);
        }, 1000);
    })
}

async function awaitFunc() {
    const value1 = await func();
    const value2 = await increment(value1);
    console.log(value2);
    console.log('haii');
    const value3 = await increment(value2);
    const value4 = await increment(value3);
    console.log(value4)
}

async function increment(res) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(res + 1);
        }, 1000);
    })
}

awaitFunc();