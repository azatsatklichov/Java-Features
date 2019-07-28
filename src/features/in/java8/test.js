var BigDecimal = Java.type('java.math.BigDecimal');
var  String =  Java.type('java.lang.String');

function calculate(amount, percentage) {

   var result = new BigDecimal(amount).multiply(new BigDecimal(percentage)).divide(
      new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_EVEN);
     
   var x = new String("Hello from Javascript by JAVA");
   
   return result.toPlainString() + " "+ x.toUpperCase();
}
var result = calculate(568000000000000000023,13.9);
//alert('tobe');
print(result);

//see more https://winterbe.com/posts/2014/04/05/java8-nashorn-tutorial/