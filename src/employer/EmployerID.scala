package employer

import theLadders.{Printer, Identity, Printable}

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/17/13
 * Time: 10:14 AM
 * To change this template use File | Settings | File Templates.
 */
class EmployerID(val theIdentity: Identity) extends Printable {
  def print(aPrinter: Printer) =
  {
    aPrinter.printItem(theIdentity)
  }

  override def equals(other: Any) =
  {
    val that = other.asInstanceOf[EmployerID]
    if (that == null) false
    else that.theIdentity  == theIdentity
  }

  override def toString() =
  {
    theIdentity.toString
  }

}
