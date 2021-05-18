const readline = require("readline");

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
});

rl.on("line", (line) => {
    main(Number(line));
    rl.close();
}).on("close", () => process.exit());

const memo = [0, 1, 1];

const fibo = (num) => {
    if (memo[num]) {
        return memo[num];
    }

    memo[num] = fibo(num - 1) + fibo(num - 2);
    return memo[num];
};

/**
 *
 * @param {number} line
 */
const main = (line) => {
    const answer = fibo(line);
    console.log(answer);
};