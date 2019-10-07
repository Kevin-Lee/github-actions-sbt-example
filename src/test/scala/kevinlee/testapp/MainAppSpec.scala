package kevinlee.testapp

import java.net.URL

import hedgehog._
import hedgehog.runner._

/**
 * @author Kevin Lee
 * @since 2019-10-05
 */
object MainAppSpec extends Properties {
  override def tests: List[Test] = List(
    example("test get", testGet)
  )

  def testGet: Result = {
    val isDocker = sys.env.get("IS_DOCKER").fold(false)(_.toBoolean)
    val hostname = if (isDocker) "web" else "localhost"
    val actual = MainApp.get(new URL(s"http://$hostname:8000/get").openConnection())
    actual match {
      case Right(response) =>
        response.status ==== 200
      case Left(error) =>
        Result.failure.log(error)
    }
  }
}
