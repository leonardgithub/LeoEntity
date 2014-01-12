package leo.util

import java.util.Date
import java.util.logging.Logger
import java.util.UUID
import java.util.Calendar
import java.util.GregorianCalendar

object LeoLogger {

  val logger: Logger = Logger.getLogger("leo.util");

  def log(str: Any) { //used in only dev env as logDebug method
    logger.info("[log4j] " + str);
  }

  def logInfo(str: Any) { //used in both dev and production env
    logger.info("[log4j] " + str);
  }

  def logError(str: Any) { //used in both dev and production env
    logger.info("[log4j] " + str);
  }

  def logDebug(str: Any) { //used in only dev env
    logger.info("[log4j] " + str);
  }

  def main(args: Array[String]) {
    //    val formater = new java.text.SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
    //    var d = new Date()
    //    val s = formater.parse("2013-11-12 12:12:12")
    //    println(s)

    log("test");
    log("test2");
  }

  //  def log(str: Array[String]): Unit = {
  //    if(str != null){
  //      str.foreach(println(_))
  //    }
  //  }
}

object LeoUtil {
  //   file path and name, begin
  def getFileExtension(fileName: String): String = {
    val idx = fileName.lastIndexOf(".")
    if (idx == -1) {
      ""
    } else {
      fileName.substring(idx)
    }
  }
  //   file path and name, end

  // string, begin
  def isStringNotEmpty(s: String): Boolean = {
    s != null && !"".equals(s)
  }

  def isStringNotEmpty(a: Array[String]): Boolean = {
    a.forall(s => s != null && !"".equals(s))
  }

  def convertToString(o: Any) = {
    o match {
      case e: String if (e != null) => e
      case _ => ""
    }
  }
  // string, end

  def genUUID(): java.lang.String = {
    UUID.randomUUID().toString();
  }

  // datetime, begin
  val formater = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss") //yyyy-MM-dd HH:mm:ss is 12 system

  def getCurTimeStr() = {
    getTimeStr(new Date())
  }

  def getCurTime() = {
    new Date
  }

  def getTime(s: String): Date = {
    formater.parse(s)
  }

  def getTimeStr(d: Date): String = {
    d match {
      case null => ""
      case _ =>
        formater.format(d)
    }
  }

  def getCurCalendar() = {
    new GregorianCalendar()
  }

  def getYearMonthDay(): String = {
    val c = getCurCalendar()
    c.get(Calendar.YEAR) + "/" +
      c.get(Calendar.MONTH) + "/" +
      c.get(Calendar.DAY_OF_MONTH) + "/"
  }

  // datetime, end
  def main(args: Array[String]) {
    //    val c = getCurCalendar()
    //    println(c.getTime())
    //    println(c.get(Calendar.YEAR))
    //    println(c.get(Calendar.MONTH))
    //    println(c.get(Calendar.DAY_OF_MONTH))
    //    println(c.get(Calendar.DAY_OF_WEEK))
    //    println(c.get(Calendar.DAY_OF_WEEK_IN_MONTH))
    //    println(c.get(Calendar.DAY_OF_YEAR))
    var ret = getFileExtension("addf.bfdfds.432ds.jpgsfds");
    println(ret)
    ret = getFileExtension("bbbbss");
    println("a" + ret + "b")
  }
}