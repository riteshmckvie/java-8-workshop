
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