const puppeteer = require('puppeteer');
const puppeteerHar = require('puppeteer-har');

(async () => {
    const browser = await puppeteer.launch({
        headless: true
    });
    const page = await browser.newPage();
    await page.setViewport({
            width: 1200,
            height: 800
        });
    const har = new puppeteerHar(page);
    await har.start({
        path: process.argv[3]+ '/' + 'network.har',
    });

    await page.setCacheEnabled(false);

    await page.goto(process.argv[2],{waitUntil:"networkidle2"});

    await autoScroll(page);

    await har.stop();

    const time = new Date().getTime();

    await page.screenshot({
        path: process.argv[3]+ '/' + 'screenshot.png',
        fullPage: true
    });

    await browser.close();
})();


function autoScroll(page) {
    return page.evaluate(() => {
        return new Promise((resolve, reject) => {
            var totalHeight = 0;
            var distance = 100;
            var timer = setInterval(() => {
                var scrollHeight = document.body.scrollHeight;
                window.scrollBy(0, distance);
                totalHeight += distance;
                if (totalHeight >= scrollHeight) {
                    clearInterval(timer);
                    resolve();
                }
            }, 100);
        })
    });
}