package employer

import theLadders.{Printer, Printable}

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/17/13
 * Time: 10:11 AM
 * To change this template use File | Settings | File Templates.
 */
class EmployerInfo (val theEmployerName: EmployerName) extends Printable
{
  override def print(aPrinter: Printer) =
  {
    theEmployerName.print(aPrinter)
  }

  override def equals(other: Any) =
  {
    val that = other.asInstanceOf[EmployerInfo]
    if (that == null) false
    else
      that.theEmployerName == theEmployerName
  }
}
