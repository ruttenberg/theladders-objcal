package theLadders

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/17/13
 * Time: 11:44 AM
 * To change this template use File | Settings | File Templates.
 */
class PrintableString ( val theString: String  ) extends Printable {
  override def print(thePrinter: Printer) =
  {
    thePrinter.printItem(this)
  }

  override def toString = theString

}
