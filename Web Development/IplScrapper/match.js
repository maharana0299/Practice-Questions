const cheerio = require('cheerio');
const request = require('request');
// const link = 'https://www.espncricinfo.com/series/ipl-2020-21-1210595/sunrisers-hyderabad-vs-royal-challengers-bangalore-3rd-match-1216534/full-scorecard';


function getMatchLinks(link) {
    request(link, getMessage);
}

function getMessage(e, r, data) {
    process(data);
}

function process(data) {
    let ch = cheerio.load(data);
    let bothInnings = ch('.Collapsible');
    // console.log(bothInnings.length);
    for (let i = 0; i < bothInnings.length; i++) {
        let tName = ch(bothInnings[i]).find('h5').text();

        tName = tName.split('INNINGS')[0].trim();

        let allTrs = ch(bothInnings[i]).find('.table.batsman tbody tr');
        console.log(tName);

        getStats(allTrs, ch);
    }
}

function getStats(allTrs, ch) {
    console.log('################################');
    // length - 1 coz it contains one extra empty player
    for (let j = 0; j < allTrs.length - 1; j++) {
        let allTds = ch(allTrs[j]).find('td');
        if (allTds.length > 1) {

            // getting all details
            let batsmanName = ch(allTds[0]).find('a').text().trim();
            let runs = ch(allTds[2]).text().trim();
            let balls = ch(allTds[3]).text().trim();
            let fours = ch(allTds[5]).text().trim();
            let sixes = ch(allTds[6]).text().trim();

            console.log(`Batsman - ${batsmanName}, Runs - ${runs}, Balls - ${balls}, Fours - ${fours}, Sixes - ${sixes}`);
        }
    }
    console.log('################################');
}

module.exports = getMatchLinks;