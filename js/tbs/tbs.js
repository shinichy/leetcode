/*global process */

var N, C, D, cities;
var MIN_NODE_SIZE = 2;
var NUM_NODES = 200;
var MUTATION_PROBABILITY = 0.05;
var NUM_GENERATION = 500;
var TOURNAMENT_SIZE_RATIO = 0.1;
var ELITES_RATIO = 0.1;

process.stdin.resume();
process.stdin.setEncoding('ascii');
var str = '';
process.stdin.on('data', function (input) {
  str += input;
});

function City(x, y, price) {
  this.x = x;
  this.y = y;
  this.price = price;
};

City.prototype.distanceFrom = function(city) {
  return Math.sqrt(Math.pow(this.x - city.x, 2) + Math.pow(this.y - city.y, 2));
};

City.prototype.toString = function() {
  return this.x + ' ' + this.y;
};

function Node() {
  var arr = [ ];
  arr.push.apply(arr, arguments);
  arr.__proto__ = Node.prototype;

  arr.profit = Number.NEGATIVE_INFINITY;
  arr.numBlimpsBringing;
  arr.maxCityIndex;
  return arr;
};
Node.prototype = new Array;

Node.prototype.calcMaxCity = function() {
  this.maxCityIndex = new Array(this.length);
  var max = cities.length-1;
  for (i = 0; i < this.length; i++) {
    this.maxCityIndex[i] = max;
    if (this[i] !== 0) {max--; }
  }
};

Node.prototype.isValid = function() {
  function isValidCityIndex(cityIndex, index) {
    return cityIndex <= this.maxCityIndex[index];
  }
  if (!this.every(isValidCityIndex, this)) return false;
  return true;
};

Node.prototype.evaluate = function() {
  this.numBlimpsBringing = new Array(this.length);
  var blimps = 1;
  var i;
  for (i = this.length-1; i >= 0; i--) {
    if (this[i] === 0) {
      this.numBlimpsBringing[i] = 0;
      blimps = 1;
    } else {
      this.numBlimpsBringing[i] = blimps;
      blimps++;
    }
  }

  var remainingCities = cities.slice(0);
  var prevCity = cities[0];
  var cost = 0;
  var sales = 0;
  var declineFactor = D;
  try {
    for (i = 0; i < this.length; i++) {
      var mile = remainingCities[this[i]].distanceFrom(prevCity);
      prevCity = remainingCities[this[i]];
      // Salesman's cost and Blimp's travel cost
      cost += (C * this.numBlimpsBringing[i] + 1) * mile;
      sales += remainingCities[this[i]].price * declineFactor;
      if (this[i] !== 0) {
        remainingCities.splice(this[i], 1);
        declineFactor *= declineFactor;
      }
    }
  } catch(e) {
    console.log(e);
  }

  this.profit = sales - cost;
};

Node.prototype.print = function() {
  var cityCount = 0;
  var remainingCities = cities.slice(0);
  this.forEach(function (cityIndex, i) {
    var city = remainingCities[cityIndex];
    var str = city.toString();
    if (i === 0 || this[i - 1] === 0) {
      str += ' ' + this.numBlimpsBringing[i];
    }
    process.stdout.write(str + '\n');
    if (this[i] !== 0) {
      remainingCities.splice(this[i], 1);
    }
  }, this);
};

Node.prototype.adjustIndices = function() {
  for (var i = 0; i < this.length; i++) {
    if (this[i] > this.maxCityIndex[i]) {
      this[i] = this.maxCityIndex[i];
    }
  }
};

function createNode() {
  var size = Math.floor((Math.random() * (N - MIN_NODE_SIZE + 1)) +
    MIN_NODE_SIZE);
  var node = new Node();
  var maxCity = cities.length;
  while (node.length < size) {
    var cityIndex = Math.floor(Math.random() * maxCity);
    node.push(cityIndex);
    if (cityIndex !== 0) {
      maxCity--;
    }
  }

  return node;
}

function crossover(node1, node2) {
  var len = Math.max(node1.length, node2.length);
  var child1 = new Node();
  var child2 = new Node();
  var p1 = Math.floor((Math.random() * (len - 1)) + 1);
  var p2 = Math.floor((Math.random() * (len - 1)) + 1);
  if (p2 < p1) {
    var tmp = p2;
    p2 = p1;
    p1 = tmp;
  }
  var src = node1;
  for (var i = 0; i < len; i++) {
    if (i < p1 || p2 <= i) {src = node1;}
    else {src = node2;}
    if (src[i] >= 0) {
      child1.push(src[i]);
    }
  }
  for (i = 0; i < len; i++) {
    if (i < p1 || p2 <= i) {src = node2;}
    else {src = node1;}
    if (src[i] >= 0) {
      child2.push(src[i]);
    }
  }

  child1.calcMaxCity();
  child2.calcMaxCity();
  if (child1.isValid() && child2.isValid()) {
    return [child1, child2];
  } else {
    return null;
  }
}

function mutate(nodeList, best, prob) {
  nodeList.forEach(function (node) {
    if (node == best) {return;}
    for (var i = 0; i < node.length; i++) {
      if (Math.random() < prob) {
        var prev = node[i];
        node[i] = Math.floor(Math.random() * (node.maxCityIndex[i] + 1));
        if (prev === 0 && node[i] > 0) {
          node.calcMaxCity();
          node.adjustIndices();
        }
      }
    }
  });
}

function selectByTournament(nodeList, size) {
  var best = new Node();
  best.profit = Number.NEGATIVE_INFINITY;
  for (var i = 0; i < size; i++) {
    var node = nodeList[Math.floor(Math.random() * nodeList.length)];
    if (best.profit < node.profit) {
      best = node;
    }
  }
  return best;
}

function selectElites(nodeList, size) {
  var elites = [];
  nodeList.forEach(function (node) {
    var added = false;
    for (i = 0; i < elites.length; i++) {
      if (elites[i].profit < node.profit) {
        elites.splice(i, 0, node);
        added = true;
        break;
      }
    }
    if (!added && elites.length < size) {
      elites.push(node);
    }
    if (elites.length > size) {
      elites.pop();
    }
  })

  return elites;
}

process.stdin.on('end', function () {
  var lines = str.split('\n');
  var ar = lines[0].split(' ');
  N = parseInt(ar[0], 10);
  C = parseFloat(ar[1]);
  D = parseFloat(ar[2]);
  var NUM_ELITES = NUM_NODES * ELITES_RATIO;
  var TOURNAMENT_SIZE = NUM_NODES * TOURNAMENT_SIZE_RATIO;

  // initialize cities
  console.log('initialize cities');
  cities = new Array();
  cities[0] = new City(0, 0, 0);
  for (var i = 1; i < lines.length; i++) {
    ar = lines[i].split(' ');
    cities[i] = new City(parseInt(ar[0], 10), parseInt(ar[1], 10),
      parseInt(ar[2], 10));
  }

  // create initial nodes
  console.log('create initial nodes');
  var nodeList = [];
  var best = new Node();
  best.profit = Number.NEGATIVE_INFINITY;
  for (i = 0; i < NUM_NODES; i++) {
    nodeList.push(createNode());
  }

  var generation = 0;
  var bestStayingCount = 0;
  while (generation < NUM_GENERATION) {
    console.log('generation: ' + generation);
    console.log('best: ' + best.profit);
    var prevBestProfit = best.profit;
    // evaluate nodes
    nodeList.forEach(function (node) {
      console.log('evaluate');
      node.evaluate();
      if (best.profit < node.profit) {
        best = node;
      }
    });
    if (prevBestProfit == best.profit) {
      bestStayingCount++;
    }

    if (bestStayingCount == Math.floor(NUM_GENERATION / 5) || generation == NUM_GENERATION) break;

    var children = selectElites(nodeList, NUM_ELITES);
    children.forEach(function (node) {
      node.calcMaxCity();
    })

    // crossover
    // console.log('crossover');
    while (children.length < nodeList.length) {
      var parent1 = selectByTournament(nodeList, TOURNAMENT_SIZE);
      var parent2 = selectByTournament(nodeList, TOURNAMENT_SIZE);
      var result = crossover(parent1, parent2);
      if (result) {
        children.push(result[0], result[1]);
      }
    }
    nodeList = children;

    mutate(nodeList, best, MUTATION_PROBABILITY);
    generation++;
  }

  // best.print();
  console.log(best.profit);
});
