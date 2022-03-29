process.stdin.resume();
process.stdin.setEncoding("ascii");
var str = "";
process.stdin.on("data", function (input) {
  str += input;
});

process.stdin.on('end', function () {
  var lines = str.split('\n');
  var ar = lines[0].split(' ');
  var n = parseInt(ar[0]), k = parseInt(ar[1]);
  var o = {};
  lines[1].split(' ').forEach(function(num) {
    o[num] = true;
  });
  var c = 0;
  var from = 0;
  var to = lines[1].indexOf(' ');
  while(to != -1) {
    var num = parseInt(lines[1].substring(from, to));
    if (o[num+k]) c++;
    if (to == lines[1].length) {break;}
    from = to+1;
    to = lines[1].indexOf(' ', from);
    if (to == -1) {to = lines[1].length}
  }
  process.stdout.write(c.toString() + '\n');

})
