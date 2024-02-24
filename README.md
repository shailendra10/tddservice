# tddservice
tddservice

* Created ArithmeticOpSevice Class and corresponding test class ArithmeticOpServiceTest

* Implemented code and test cases as per below cases.

  1. Allow the add method to handle an any amount of numbers.

  2. Allow the add method to handle new lines between numbers (instead of commas).

  3. The following input is valid: "1\n2,3" (will return 6)
     The following input is invalid: "1,\n"

  4. Support different delimiters To change delimiter, the beginning of the string will contain a separate line that looks like this: "//[delimiter]\n[numbers…]", for example "//;\n1;2" here the delimiter is ";" and this should return 3.

  5. Calling add with a negative number will throw an exception "negative numbers not allowed <negative_number>".

  6. If there are multiple negative numbers, show all of them in the exception message, separated by commas
