---
layout: docs
title: The First Page
---

# The First Page
## Blah blah 

```scala mdoc
import cats.effect._

def foo(n: Int): IO[Int] = IO(n * 2)
def bar(a: Int, b: Int): IO[Int] = IO(a + b)

def putStrLn[A](a: A): IO[Unit] = IO(println(a))

val x = 123

def main(args: Array[String]): Unit = 
  (for {
    y <- foo(x)
    z <- bar(x, y)
    _ <- putStrLn(s"result: $z")
  } yield ()).unsafeRunSync()

main(Array.empty)
```
[**Visit the Second Page**](second)
