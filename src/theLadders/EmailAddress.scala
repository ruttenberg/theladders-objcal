package theLadders

/**
 * Created with IntelliJ IDEA.
 * User: jpr
 * Date: 10/29/13
 * Time: 8:10 AM
 * To change this template use File | Settings | File Templates.
 */
class EmailAddress(val theAddress: String) extends Identity
{
  override def toString() =
  {
    theAddress
  }

  override def equals(other: Any) =
  {
    val that = other.asInstanceOf[EmailAddress]
    if (that == null) false
    else that.theAddress  == theAddress
  }
}
