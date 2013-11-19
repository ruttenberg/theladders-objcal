package theLadders

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/17/13
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */
trait Printer {
  def printList(listOfPrintables: List[Printable], separator: String)
  def printItem(printableItem: Printable) =
  {
    print(printableItem.toString)
  }

  def printInt(anInt: Int) =
  {
    print(anInt)
  }
}
