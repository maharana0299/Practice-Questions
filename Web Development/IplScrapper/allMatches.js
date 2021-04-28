const request = require("request");
const cheerio = require("cheerio");
const baseUrl = "https://www.espncricinfo.com";

function getAllMatches(link) {
    request(link, function(error, response, data) {
        processData(data);
    })
}


function processData(html) {
    // get liks of all the matchess !!!
    let ch = cheerio.load(html);
    let allATags = ch('a[data-hover="Scorecard"]');

    // {},{},{} .....
    for (let i = 0; i < allATags.length; i++) {
        let matchLink = baseUrl + ch(allATags[i]).attr("href");
        console.log(matchLink); // got all scorecard links
    }
}



module.exports = getAllMatches;