package application

import employer.EmployerID

package object predicate
{
  def applicationByEmployerIDPredicate(anEmployerID: EmployerID) =
    (anApplication: Application) => anApplication.isForThisEmployer(anEmployerID)
}
