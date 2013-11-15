package employer

import theLadders.{Printer, Printable}

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/17/13
 * Time: 10:13 AM
 * To change this template use File | Settings | File Templates.
 */
class EmployerName(val theName: String) extends Printable
{
  override def print(aPrinter: Printer) =
  {
    aPrinter.printItem(this)
  }

  override def toString() =
  {
    theName
  }

  override def equals(other: Any) =
  {
    val that = other.asInstanceOf[EmployerName]
    if (that == null) false
    else
      that.theName == theName
  }
}
