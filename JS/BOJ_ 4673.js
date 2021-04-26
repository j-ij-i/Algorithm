let num = [];
for (let i = 1; i <= 10000; i++) {
  num.push(i);
}

for (let i = 1; i < 10000; i++) {
  let sum = i;
  for (let j = 0; j < i.toString().length; j++) {
    sum += Number(i.toString()[j]);
  }

  let idx = num.indexOf(sum);
  if (idx !== -1) {
    num.splice(idx, 1);
  }
  //  num = num.filter((element) => element !== sum);
}

for (idx in num) {
  console.log(num[idx]);
}