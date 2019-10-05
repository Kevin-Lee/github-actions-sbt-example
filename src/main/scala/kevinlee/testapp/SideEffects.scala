package kevinlee.testapp

import java.io.{InputStream, OutputStream}

/**
 * @author Kevin Lee
 * @since 2019-10-05
 */
object SideEffects {

  def transfer(
                bufferSize: Int
                , inputStream: InputStream
                , outputStream: OutputStream
              ): Unit = {
    var read = 0L
    val buff = new Array[Byte](bufferSize)
    var n = inputStream.read(buff)
    while (n > 0) {
      outputStream.write(buff, 0, n)
      read += n
      n = inputStream.read(buff)
    }
    ()
  }

  def tryWith[A : CanClose, B](a: => A)(f: A => B): B = {
    lazy val resource = a
    var firstEx: Throwable = null
    try {
      f(resource)
    } catch {
      case ex: Throwable =>
        firstEx = ex
        throw ex
    } finally {
      if (firstEx == null) {
        implicitly[CanClose[A]].close(resource)
      } else {
        try {
          implicitly[CanClose[A]].close(resource)
        } catch {
          case ex2: Throwable =>
            firstEx.addSuppressed(ex2)
            throw firstEx
        }
      }
    }
  }

}
