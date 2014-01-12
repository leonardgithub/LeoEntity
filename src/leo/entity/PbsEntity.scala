package leo.entity

import java.util.Date
import scala.beans.BeanProperty
import leo.util.LeoLogger

trait PbsEntity {
  def getInfo() = {
    val clz = this.getClass()
    val fields = clz.getDeclaredFields()
    var str = ""
    fields.foreach(f => {
      val m = clz.getMethod(f.getName())
      if (m != null) {
        str += f.getName() + ": " + m.invoke(this) + ". "
      }
    })
    str
  }
}

class PbsImg extends PbsEntity {
  @BeanProperty var id: Long = EntityDefaulVal.intDefaultVal
  @BeanProperty var imgPath: String = EntityDefaulVal.stringDefaulVal // e.g. 2013/11/12/xxxx.jpg
  @BeanProperty var userNum: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var tag1: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var tag2: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var tag3: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var tag4: String = EntityDefaulVal.stringDefaulVal
  @BeanProperty var likeCount: Long = EntityDefaulVal.intDefaultVal
  @BeanProperty var imgGroup: Long = EntityDefaulVal.intDefaultVal
  @BeanProperty var isDeleted: Boolean = EntityDefaulVal.booleanDefaultVal
  @BeanProperty var creationTime: Date = EntityDefaulVal.dateDefaultVal

}



