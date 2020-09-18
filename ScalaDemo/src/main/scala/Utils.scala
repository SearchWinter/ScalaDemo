import java.text.SimpleDateFormat
import java.util.Calendar

/**
 * @Description TODO
 * @Date 2020/9/18  19:14
 **/
object Utils {
  def main(args: Array[String]): Unit = {

  }

  /**
   *
   * @param ts
   * @return
   */
  def parseTimestamp(ts: String): Long = {
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    format.parse(ts).getTime
  }

  /**
   *
   * @param dateStr
   * @param beforeDay
   * @return
   */
  def getBeforeDay(dateStr: String, beforeDay: Int): String = {
    val dateFormat = new SimpleDateFormat("yyyyMMdd")
    val calendar = Calendar.getInstance;
    val date = dateFormat.parse(dateStr)
    calendar.setTime(date)
    calendar.add(Calendar.DAY_OF_YEAR, -beforeDay)
    val tmpDateStr = dateFormat.format(calendar.getTime)
    tmpDateStr
  }

  /**
   *
   * @param dateStr
   * @param beforeDay
   * @return
   */
  def getBeforeTimeStamp(dateStr: String, beforeDay: Int): Long = {
    val dateFormat = new SimpleDateFormat("yyyyMMdd")
    val calendar = Calendar.getInstance;
    val date = dateFormat.parse(dateStr)
    calendar.setTime(date)
    calendar.add(Calendar.DAY_OF_YEAR, -beforeDay)
    calendar.getTime.getTime

  }
  def getNextDay(dateStr: String, nextDay: Int): String = {
    val dateFormat = new SimpleDateFormat("yyyyMMdd")
    val calendar = Calendar.getInstance;
    val date = dateFormat.parse(dateStr)
    calendar.setTime(date)
    calendar.add(Calendar.DAY_OF_YEAR, nextDay)
    val tmpDateStr = dateFormat.format(calendar.getTime)
    tmpDateStr
  }
  def getBeforeMuttDays(dateStr: String, beforeDay: Int): Array[String] = {
    val dateFormat = new SimpleDateFormat("yyyyMMdd")
    val calendar = Calendar.getInstance;
    val date = dateFormat.parse(dateStr)
    calendar.setTime(date)
    val result = new Array[String](beforeDay)

    1.to(beforeDay).foreach { x =>
      calendar.add(Calendar.DAY_OF_YEAR, -1)
      val tmpDateStr = dateFormat.format(calendar.getTime)
      result(x - 1) = tmpDateStr
    }
    result
  }

  def getNextMuttDays(dateStr: String, nextDay: Int): Array[String] = {
    val dateFormat = new SimpleDateFormat("yyyyMMdd")
    val calendar = Calendar.getInstance;
    val date = dateFormat.parse(dateStr)
    calendar.setTime(date)
    val result = new Array[String](nextDay)
    1.to(nextDay).foreach { x =>
      calendar.add(Calendar.DAY_OF_YEAR, 1)
      val tmpDateStr = dateFormat.format(calendar.getTime)
      result(x - 1) = tmpDateStr
    }
    result
  }
}
