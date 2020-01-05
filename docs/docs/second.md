---
layout: docs
title: The Second Page
---

# Heading 1


# Heading 2
## Heading 2.1

```scala mdoc
import cats._
import cats.effect._

trait Something[F[_]] {
  def foo(n: Int): F[Int]
  def bar(a: Int, b: Int): F[Int]
  def putStrLn[A](a: A): F[Unit]
}

object Something {
  def apply[F[_] : Something]: Something[F] = implicitly[Something[F]]

  implicit def somethingF[F[_]](implicit FM: Monad[F]): Something[F] = new SomethingF[F] {
    override implicit val M: Monad[F] = FM
  } 

}

trait SomethingF[F[_]] extends Something[F] {
  implicit def M: Monad[F]

  def foo(n: Int): F[Int] = M.pure(n * 2)
  def bar(a: Int, b: Int): F[Int] = M.pure(a + b)
  def putStrLn[A](a: A): F[Unit] = M.pure(println(a))
}

val x = 123

def main(args: Array[String]): Unit = 
  (for {
    y <- Something[IO].foo(x)
    z <- Something[IO].bar(x, y)
    _ <- Something[IO].putStrLn(s"result: $z")
  } yield ()).unsafeRunSync()

main(Array.empty)
```

## Heading 2.2
```scala mdoc
val SIO = Something[IO]

(for {
  a <- SIO.foo(1)
  b <- SIO.bar(a, 999)
  _ <- SIO.putStrLn(s"result: $b")
} yield ()).unsafeRunSync()
```