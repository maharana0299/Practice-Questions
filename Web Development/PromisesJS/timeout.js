function delayIt() {
    return new Promise(function executor(resolve, reject) {
        setTimeout(() => {
            resolve(2);
        }, 2000);
    })
}

let p = delayIt();

p.then(function(a) {
    console.log(a);
});


// runs parallel
setTimeout(() => {
    p.then(function(a) {
        console.log('after delay');
    })
}, 3000);