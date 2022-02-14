import org.scalatest.flatspec.AnyFlatSpec

import java.nio.file.FileSystems
import scala.language.postfixOps
import Solution.ListDirectory

class FutureTest extends AnyFlatSpec {

  " ListDirectory(\"./sr\")" should "give List(./sr) because path doesn't exists " in {
    val obj: ListDirectory = ListDirectory("./sr") // this path doesn't exists
    assert(obj.result == List("404 Not Found"))
  }

  "ListDirectory(\"./src\")" should "give List(())" in {
    val obj = ListDirectory("./src")
    assert(obj.result == List("()"))
  }

  "Path Valid or not " should "give" in {
    val path = FileSystems.getDefault.getPath("./src")
    assert(path.toFile.isDirectory && path.toFile.exists())
  }
}
