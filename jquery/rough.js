var numbers = [1,2,3,4,5]; //define array
console.log(numbers);
var newNumbers = numbers.map(function(number) {
     return number * 2; //using map function
});
console.log(newNumbers);

 

// arrow function syntax
var newNumbers1 = numbers.map(e => e * 2);
console.log(newNumbers1);

 

// Filter
var numbers = [1,2,3,4,5]; //define array
var oddNumbers = numbers.filter(e => e % 2);
console.log(oddNumbers);

 

// Reduce
const arr = [3, 9, 2, 7, 4];
const sum = arr.reduce((accumulator, currentValue) =>
  (accumulator + currentValue),10);
console.log(sum);