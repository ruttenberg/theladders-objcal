package theLadders

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/29/13
 * Time: 8:06 AM
 * To change this template use File | Settings | File Templates.
 */
trait Identity extends Printable
{
  override def print(thePrinter: Printer) =
  {
    thePrinter.printItem(this)
  }
}
