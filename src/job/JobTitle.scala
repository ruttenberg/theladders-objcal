package job

import theLadders.{Printer, Printable}

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/17/13
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
class JobTitle(val theTitle: String) extends Printable
{
  override def print(aPrinter: Printer) =
  {
    aPrinter.printItem(this)
  }

  override def equals(other: Any) =
  {
    val that = other.asInstanceOf[JobTitle]
    if (that == null) false
    else that.theTitle  == theTitle
  }

  override def toString() =
  {
    theTitle.toString()
  }
}
