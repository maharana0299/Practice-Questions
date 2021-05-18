const cheerio = require('cheerio');
const request = require('request');

var baseUrl = 'https://github.com';
let topicUrl = '/topics';

function explore(url) {
    request(url, getTopics);
}

function getTopics(err, res, html) {

    if (!err) {
        let ch = cheerio.load(html);
        let topics = ch('.topic-box a');
        // console.log(topics.length);

        for (let i = 0; i < topics.length; i++) {
            let topicName = ch(topics[i]).find('p.lh-condensed')
                .text()
                .trim();
            let topicLink = baseUrl + topicUrl + ch(topics[i]).attr('href');
            console.log(topicName, topicLink);
        }
    }
}

explore(`${baseUrl}${topicUrl}`);