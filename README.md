# Java worker fixture

A small Maven project (Java 21, JUnit 5) for exercising the Autoscan **Java worker**.

```sh
mvn verify
```

`Inventory.java` has two intentional issues, so a successful automatic analysis should report them:

- strings compared with `==`
- an empty `catch` block
