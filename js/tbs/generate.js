var fs = require('fs');
var str = '';
var N = Math.pow(10, 5);
var C = 0.2;
var D = 0.99;
str += N + ' ' + C + ' ' + D + '\n';
for (var i = 0; i < N; i++) {
  var x = Math.floor((Math.random() * 2001) - 1000);
  var y = Math.floor((Math.random() * 2001) - 1000);
  var price = Math.floor((Math.random() * Math.pow(10, 5)));
  str += x + ' ' + y + ' ' + price;
  if (i !== N - 1) {
    str += '\n';
  }
}
fs.writeFile('input.txt', str, function(err) {
  if (err) {
    console.log(err);
  }
});
