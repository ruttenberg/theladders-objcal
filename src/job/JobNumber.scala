package job

import theLadders.{Printer, Printable}

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/17/13
 * Time: 11:10 AM
 * To change this template use File | Settings | File Templates.
 */
class JobNumber(theJobNumber: Int) extends Printable {
  def print(aPrinter: Printer) =
  {
    aPrinter.printItem(this)
  }

  override def toString() =
  {
    theJobNumber.toString()
  }
}
