package kevinlee.testapp

import java.io.{ByteArrayOutputStream, InputStream, OutputStream}
import java.net.URL

object MainApp extends App {

  def transfer(bufferSize: Int, inputStream: InputStream, outputStream: OutputStream): Unit = {
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

  val connection = new URL("http://web:8000/get").openConnection()
  val input = connection.getInputStream
  val output = new ByteArrayOutputStream()
  try {
    transfer(1024, input, output)
  } finally {
    output.close()
    input.close()
  }

  println(
    new String(output.toByteArray)
  )
}
