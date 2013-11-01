package theLadders

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/23/13
 * Time: 2:39 PM
 * To change this template use File | Settings | File Templates.
 */
class ConsolePrinter extends Printer
{
  def printList(listOfPrintables: List[Printable], separator: String) =
  {
    listOfPrintables match
    {
      case Nil =>
      case head :: tail => head.print(this); printRestOfListWithSeparator(tail, separator)
    }
  }

  def printRestOfListWithSeparator(listOfPrintables: List[Printable], separator: String)
  {
    listOfPrintables match
    {
      case Nil =>
      case head :: tail => print(separator);  head.print(this); printRestOfListWithSeparator(tail, separator)
    }
  }
}
