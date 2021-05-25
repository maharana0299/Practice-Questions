let fs = require('fs');

// promise is an object 
let p = new Promise(function executor(resolve, reject) {
    // if task is sucessful then call resolve
    fs.readFile('f.txt', function(err, data) {
            if (err) reject(err);
            else resolve(data);
        })
        // if faliure then call reject
})

// if task is completed and rsolved
p.then(function(data) {
    console.log("Data is recieved");
    console.log(data + "");
}).catch(function(err) {
    // if any error occured
    // passing the value of reject
    console.log(err);
})