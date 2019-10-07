package kevinlee.testapp

import java.io.ByteArrayOutputStream
import java.net.{HttpURLConnection, URL, URLConnection}

import SideEffects._
import javax.net.ssl.HttpsURLConnection

import scala.util.{Failure, Success, Try}

object MainApp {

  final case class Response(status: Int, body: String)

  def get(connection: URLConnection): Either[String, Response] = Try {
    val status = connection match {
      case h: HttpsURLConnection =>
        h.getResponseCode
      case h: HttpURLConnection =>
        h.getResponseCode
    }
    val result = tryWith(connection.getInputStream) { input =>
      tryWith(new ByteArrayOutputStream()) { output =>
        transfer(1024, input, output)
        new String(output.toByteArray)
      }
    }
    Response(status, result)
  } match {
    case Failure(exception) =>
      Left(exception.getMessage)
    case Success(response) =>
      Right(response)
  }

  def main(args: Array[String]): Unit = {
    val isDocker = sys.env.get("IS_DOCKER").fold(false)(_.toBoolean)
    val hostname = if (isDocker) "web" else "localhost"
    println(get(new URL(s"http://$hostname:8000/get").openConnection()))
  }
}
