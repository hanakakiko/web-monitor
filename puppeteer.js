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

    console.log("srart goto")

    await page.goto(process.argv[2],{waitUntil:"networkidle2"});


    // await autoScroll(page);

    // console.log("har stop start")
    await har.stop();
    // console.log("har stop end")

    const time = new Date().getTime();

    await page.screenshot({
        path: process.argv[3]+ '/' + 'screenshot.png',
        fullPage: true
    });
    console.log("puppeteer success")
    await browser.close();
})();


function autoScroll(page) {
    return page.evaluate(() => {
        return new Promise((resolve, reject) => {
            var totalHeight = 0;
            var distance = 100;
            var timer = setInterval(() => {
                var scrollHeight = document.body.scrollHeight;
                console.log(scrollHeight)
                window.scrollBy(0, distance);
                totalHeight += distance;
                if (totalHeight >= scrollHeight) {
                    console.log("clear")
                    clearInterval(timer);
                    resolve();
                }
            }, 100);
        })
    });
}