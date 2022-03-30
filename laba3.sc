//import scala.collection.mutable.ListBuffer
//
//trait MethodsListCustom {
//  def add(value: Int): Boolean
//  def addIndex(value: Int, index: Int): Boolean
//  def delete(index: Int): Boolean
//  def show(): Unit
//}
//
//class ListCustom extends MethodsListCustom {
//  var mainList: ListBuffer[Int] = new ListBuffer[Int]()
//   override def add(value: Int): Boolean = {
//    mainList.append(value)
//    true
//  }
//
//  override def addIndex(value: Int, index: Int) = {
//    mainList.insert(value, index)
//    true
//  }
//
//  override def delete(index: Int) = {
//    mainList.drop(index)
//    true
//  }
//
//  override def show(): Unit = {
//    print(mainList)
//  }
//}
//
//var testList = new ListCustom()
//
//testList.add(5)
//testList.show()
//
//
//trait sortMethods {
//  def bubbleSort(): Unit
//  def insertSort(): Unit
//}
//
//
//class Sorting (var arr: Array[Int]) extends sortMethods {
//
//  override def bubbleSort(): Unit = {
//    for (i <- 0 until arr.length - 1) {
//      for (j <- 0 until (arr.length - 1)) {
//        if (arr(j) > arr(j+1)) {
//          val temp = arr(j + 1)
//          arr(j + 1) = arr(j)
//          arr(j) = temp
//        }
//      }
//    }
//  }
//
//  override def insertSort(): Unit = {
//      for (i <- 0 until arr.length) {
//      var j = i - 1
//      val tmp = arr(i)
//      while (j >= 0 && tmp < arr(j)) {
//        arr(j+1) = arr(j)
//        j -= 1
//      }
//      arr(j+1) = tmp
//    }
//  }
//
//  def printArray(): Unit = {
//    print("[")
//    for (i <- 0 until arr.length) {
//      print(arr(i) + ",")
//    }
//    print("]")
//  }
//}
//
//val arr: Array[Int] = Array(5, 6, 7, 1, 3, 3)
//
//var a = new Sorting(arr)
//
//a.insertSort()
//
//a.printArray()
//
//trait SqrtNumberTrait {
//  def sqrt2(): Double
//  def sqrt3(): Double
//  def sqrt4(): Double
//  def sqrt5(): Double
//}
//
//class SqrtMathMachine (var num: Int) extends SqrtNumberTrait {
//  override def sqrt2(): Double = {
//    Math.sqrt(num)
//  }
//
//  override def sqrt3(): Double = {
//    Math.pow(num, 1 / 3)
//  }
//
//  override def sqrt4(): Double = {
//    Math.pow(num, 1 / 4)
//  }
//
//  override def sqrt5(): Double = {
//    Math.pow(num, 1 / 5)
//  }
//}
//
//var numb: SqrtMathMachine = new SqrtMathMachine(51)
//print(numb.sqrt3())

class GetSqrtEvenMachine (var nums: Array[Int]) {
  private def square(a:Int):Int = {
    if (a % 2 == 0) a*a
    else a
  }
  def getSqrtArrayEven: Array[Int] = {
    val newMapArray = nums.map(square)
    newMapArray
  }
}


val arraytest: Array[Int] = Array(1, 2, 3, 4, 5, 6)
var newobj = new GetSqrtEvenMachine(arraytest)
print(newobj.getSqrtArrayEven.mkString("Array(", ", ", ")"))