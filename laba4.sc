import scala.collection.mutable.ListBuffer

val x: Int = 2
val y = x match {
  case first if (first > 0 && first < 1) => 2
  case second if (second > 1 && second < 2) => {
    1
  }
  case thirst if (thirst >= 2 && thirst <= 3) => 1
  case _ => 0
}

print(y)

var myList = List(1, 2, 3, 4, 5, 4, 6, 7, 8, 5)

def checkHave[T](list: List[T], element: T): Boolean = {
  if (list.head == element) return true
  else checkHave(list.tail, element)
  false
}

def DeleteAllRepeatElements[T](list: List[T]): List[T] = {
  var listEmpty: List[T] = List()
  for (elem <- list) {
    var tempHave: Boolean = false
    for (emptyListElement <- listEmpty)
      if (elem == emptyListElement) tempHave = true

    if (!tempHave) listEmpty = listEmpty :+ elem
  }
  listEmpty
}

DeleteAllRepeatElements(myList)