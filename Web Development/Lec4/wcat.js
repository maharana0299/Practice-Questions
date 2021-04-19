let fs = require("fs");
let input = process.argv.slice(2);
console.log("input", input);

let options = [];
let filePath = [];

for (let i = 0; i < input.length; i++) {
    // let firstChar = input[i].charAt(0);
    if (input[i] == "-s" || input[i] == "-b" || input[i] == "-n") {
        options.push(input[i]);
    } else {
        filePath.push(input[i]);
    }
}

console.log('input', options);
console.log('file path', filePath);

// check if file exists or not
let content = loadContent(filePath);

function loadContent(filePath) {
    let content = "";
    for (let i = 0; i < filePath.length; i++) {
        let isFileExist = fs.existsSync(filePath[i]);
        if (!isFileExist) {
            console.log('filepath', filePath[i], 'does not match');
            return;
        } else {
            let contentOfCurrent = fs.readFileSync(filePath[i], "utf-8"); // or can pass utf-8
            content += contentOfCurrent + "\r\n"; // buffer is directly converted to string
            // console.log(data.toString());
        }
    }
    return content;
}

// console.log(content);

// now remove extra lines and implement - s
let isS = options.includes("-s");
if (isS) {
    let temp = [];
    let aS = content.split("\r\n");
    // console.log(aS);
    // console.log(aS);
    for (let i = 0; i < aS.length; i++) {
        let isElementValid = aS[i] !== "";
        if (isElementValid) {
            temp.push(aS[i]);
        }
    }
    // console.log(temp);
    content = temp.join("\r\n");
}



// perform -n
let isNOption = options.includes("-n");
if (isNOption) {
    let count = 1;
    let array = content.split("\r\n");
    for (let i = 0; i < array.length; i++) {
        array[i] = `${count} ` + array[i];
        count++;
    }

    content = array.join("\r\n")
}

console.log(content);
// let isOneExist = false;
// for (let i = 0; i < options.length; i++) {
//     if (options[i] == "-b" || options[i] == "-n")
//         if (isOneExist) {
//             options.splice(i, 1);
//         } else {
//             isOneExist = true;
//         }
// }

// console.log("options", options);