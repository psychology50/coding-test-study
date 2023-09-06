"usestrict";
const fs = require("fs");
const input = fs.readFileSync("./1316.txt").toString().split("\n"); //1316.txt를 개행 단위로 문자열로 입력받음
const number = parseInt(input[0]); //총 단어의 갯수(정수형으로 변환함)
const words = []; //주어진 단어들의 배열

//input[1]부터 단어의 갯수 만큼 배열에 push함
for (let i = 1; i <= number; i++) {
  words.push(input[i]);
}

//그룹단어(정답)의 갯수를 세는 변수 n
let n = 0;

//a, b: 주어진 단어에서 index
let a = 0;
let b = 1;

//단어들을 체크함
for (let v = 0; v < words.length; v++) {
  //주어진 단어 = w
  let w = words[v];
  // console.log(w)

  //만약 주어진 단어의 길이가 2 이하라면 무조건 그룹 단어, 다음 반복(단어)으로 넘어감
  if (w.length <= 2) {
    n++;
    continue;
  }

  a = 0;
  b = 1;

  //검증배열
  let arr = [];

  for (b; b <= w.length - 1; b++) {
    if (w[a] !== w[b]) {
      if (!arr.includes(w[b])) {
        arr.push(w[b]);
      } else break;
      if (!arr.includes(w[a])) {
        arr.push(w[a]);
      }
    }
    a = b;
    
    if(b==w.length-1) n++;
  }
}

console.log(n);
