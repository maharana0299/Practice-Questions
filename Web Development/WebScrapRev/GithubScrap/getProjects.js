const cheerio = require('cheerio');
const request = require('request');
const fs = require('fs');

var baseUrl = 'https://github.com';
var json = {};

function getProjects(topicName, topicUrl) {

    // console.log(topicName, topicUrl);
    request(topicUrl, processTopics);


    function processTopics(err, res, body) {

        if (!err) {

            let ch = cheerio.load(body);
            let repos = ch('.lh-condensed a.text-bold');

            // console.log('------------------------------------------------------------------');
            repos = repos.slice(0, 5); // need only 5 projects
            for (let i = 0; i < repos.length; i++) {
                let repoName = ch(repos[i]).text().trim();
                let repoLink = baseUrl + ch(repos[i]).attr('href');
                // console.log(repoName, repoLink);
                addToJson(topicName, repoName);
            }
            // console.log('------------------------------------------------------------------');
        }
    }
}

function addToJson(topicName, repoName) {

    createRepoIfNotExist(topicName);

    let project = {
        pname: repoName,
    }

    json[topicName].push(project);
    fs.writeFileSync('data.json', JSON.stringify(json));
    // console.log(json);
}

function createRepoIfNotExist(topicName) {
    if (json[topicName] == undefined) {
        let arr = [];
        json[topicName] = arr;
    }
}
module.exports = getProjects;



// {
//     topic: [{
//         pName: 'name'
//     }]
// }