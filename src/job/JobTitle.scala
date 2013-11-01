package job

import theLadders.{Printer, Printable}

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/17/13
 * Time: 11:08 AM
 * To change this template use File | Settings | File Templates.
 */
class JobTitle(aTitle: String) extends Printable
{
  def print(aPrinter: Printer) =
  {
    aPrinter.printItem(this)
  }

  override def toString() =
  {
    aTitle.toString()
  }
}
