package leo.entity

import scala.beans.BeanProperty
import java.util.Date
import scala.collection.immutable.HashMap

//trait LeoEntity {
//
//}

//class TestClz[U >: Nothing <: Any] {
//  def main(args: Array[String]) {
//
//        var c1: TestClz[Any] = null
//        var c2: TestClz[Nothing] = null
//        var c3: TestClz[Null] = null
//    //    c2 = c1
//  }
//}

class LeoDTO[T >: Nothing <: Any] {
  @BeanProperty var entity: T = _
  @BeanProperty var errCode: String = ""
  @BeanProperty var errMsg: String = ""
  @BeanProperty var isSuccess: Boolean = false
  def toInfo() = {
    if (isSuccess)
      "isSuccess: " + isSuccess + ", entity: " + entity
    else
      "isSuccess: " + isSuccess + ", errCode: " + errCode + ", errMsg: " + errMsg + ", entity: " + entity
  }
}

object LeoDTO {
  val errorCodes = new AnyRef {
    val E0000 = "E0000"
    val E0001 = "E0001"
  }
  val errorMsgs = new AnyRef {
    val E0000 = "operation failed, please try again."
    val E0001 = "username or password is not correct."
  }
}

object DtoHelper {
  @deprecated //@deprecated due to Unit is returned, not so pure functional programming
  def doByDto[T](dto: LeoDTO[T], success: () => Unit, fail: () => Unit) {
    dto match {
      case null => if (fail != null) { fail() }
      case _ =>
        dto.getIsSuccess match {
          case false => if (fail != null) { fail() }
          case true => if (success != null) { success() }
        }
    }
  }
  def doForDto[T >: Nothing <: Any, V >: Null <: Any](dto: LeoDTO[T], success: () => V, fail: () => V): V = {
    dto match {
      case e if e != null =>
        dto.getIsSuccess match {
          case false => if (fail != null) fail() else null
          case true => if (success != null) success() else null
        }
      case _ => if (fail != null) fail() else null
    }
  }
  @deprecated //@deprecated due to co-variation is not done
  def doInDto[V >: Null](dto: LeoDTO[AnyRef], success: () => V, fail: () => V): V = {
    dto match {
      case e if e != null =>
        dto.getIsSuccess match {
          case true => if (success != null) success() else null
          case false => if (fail != null) fail() else null
        }
      case _ => if (fail != null) fail() else null
    }
  }
}

object EntityDefaulVal {
  val stringDefaulVal = ""
  val intDefaultVal: Int = -1
  val booleanDefaultVal = false
  val dateDefaultVal: Date = null
}
