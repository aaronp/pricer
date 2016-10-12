# Checkout

## To Run

This project is built using sbt.

Within an sbt shell, you can run using the 'run' task, followed by
an argument list of 'apple' and/or 'orange', either space or comma separated:

```scala
sbt coverageOff "run apple apple, orange"
```

which will produce the value in GBP:
145


## To test/view coverage

  sbt test coverageReport