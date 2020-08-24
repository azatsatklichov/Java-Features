var BigDecimal = Java.type('java.math.BigDecimal');
var String = Java.type('java.lang.String');

function calculate(amount, percentage) {

	var result = new BigDecimal(amount).multiply(new BigDecimal(percentage))
			.divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_EVEN);

	var x = new String("Hello from Javascript by JAVA");

	return result.toPlainString() + " " + x.toUpperCase();
}
var result = calculate(568000000000000000023, 13.9);
// alert('test');
print(result);

var intArr = Java.type("int[]");

var array = new intArr(5);
array[0] = 5;
array[1] = 4;
array[2] = 3;
array[3] = 2;
array[4] = 1;

try {
	array[5] = 23;
} catch (e) {
	print(e.message); // Array index out of range: 5
}

array[0] = "17";
print(array[0]); // 17

array[0] = "wrong type";
print(array[0]); // 0

array[0] = "17.3";
print(array[0]); // 

// see more https://winterbe.com/posts/2014/04/05/java8-nashorn-tutorial/
