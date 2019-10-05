package kevinlee.testapp

trait CanClose[A] {
  def close(a: A): Unit
}

object CanClose {
  implicit def CanCloseAutoCloseable[A <: AutoCloseable]: CanClose[A] = new CanClose[A] {
    override def close(a: A): Unit = a.close()
  }
}