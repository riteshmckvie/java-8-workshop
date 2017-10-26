## Lambda Expressions
Lambda expression is concise representation of any anonymous function that can be passed around.

Lambda technically don’t let you anything that you couldn’t do prior to Java 8. But you no longer have to write clumsy code using anonymous classes.
[Java 7 vs Java 8 example](src/test/java/com/lohika/java8workshop/lambda/LambdaFirstShotTest.java)

[Lambda structure](src/main/resources/lambda.png "Lambda Expression Structure")

* A list of parameters - in this case it mirrors the parameters of the compareTo method of Comparator.
* An arrow - the arrow -> separates the list of parameters from body of the lambda
* The body of the lambda - it this case it’s considered as the lambda’s return value

[Lambdas examples](src/main/java/com/lohika/java8workshop/lambda/LambdaExamples.java)
[Valid and invalid lambdas](src/main/java/com/lohika/java8workshop/lambda/ValidInValidLambdas.java)

### Lambda’s syntax rules
* Declaring the types of parameters is optional.
* Using parentheses around a parameters is optional if you have only one parameter.
* Using curly braces is optional (unless you need multiple statements).
* The return keyword is optional if you have simple expression that returns a value.

### Functional Interfaces
It’s an interface that specifies exactly one abstract method (multiple default method allowed).
[Example](src/main/java/com/lohika/java8workshop/lambda/FunctionalInterfaces.java)

The signature of abstract method of a functional interface, is called a **functional descriptor**. So in order to use
different lambda expressions, you need a set of functional interfaces that can describe common function descriptors.

java.util.function introduces several [new FI’s](src/test/java/com/lohika/java8workshop/lambda/FunctionalInterfacesTest.java)

There also primitive specializations: [IntPredicate](https://docs.oracle.com/javase/8/docs/api/java/util/function/IntPredicate.html),
[IntFunction](https://docs.oracle.com/javase/8/docs/api/java/util/function/IntFunction.html),
[IntConsumer](https://docs.oracle.com/javase/8/docs/api/java/util/function/IntConsumer.html), etc…

Lambda doesn’t contain the information about which functional interface it’s implementing.

### Method References
Method references let you reuse existing method definitions and pass them just like lambdas.

Method reference could point to:
* Static methods
* Instance methods
* Methods on particular instance
* Constructors

[Examples](src/test/java/com/lohika/java8workshop/lambda/MethodReferencesTest.java)

### Composing Lambda Expressions
It’s possible to combine several simple lambda expressions to build more complicated ones. Moreover, you can also
compose functions such that the result of one becomes the input of another function.
[Examples](src/test/java/com/lohika/java8workshop/lambda/ComposingLambdasTest.java)

## Default Methods
Default methods allow to provide a default implementation for methods in an interface. This allows to evolve interfaces non intrusively.

With default methods there is a possibility to inherit more that one method with the default implementation with the same signature.

### Resolution Rules
1. Classes always win. A method declaration in the class or a superclass takes priority over any default method declaration.
[Example](src/test/java/com/lohika/java8workshop/defaultmethod/ClassResolutionTest.java)
2. Sub-interfaces win: the method in the most specific default-providing interface is selected.
[Example](src/test/java/com/lohika/java8workshop/defaultmethod/MoreConcreteInterfaceResolutionTest.java)
3. If the choice is still ambiguous, the class has to explicitly select which default method to use.
[Example](src/test/java/com/lohika/java8workshop/defaultmethod/ManualResolutionTest.java)
