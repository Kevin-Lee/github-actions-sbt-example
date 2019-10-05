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
    val actual = MainApp.get(new URL("http://web:8000/get").openConnection())
    actual match {
      case Right(response) =>
        response.status ==== 200
      case Left(error) =>
        Result.failure.log(error)
    }
  }
}
