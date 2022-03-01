val myList = List(1, 2, 3, 4, 5)

//task1
def Last(list: List[Int]): Int = {
  val a:Int=list.head
  if(list.tail.nonEmpty) Last(list.tail)
  else  a
}

def ListCycle (list: List[Int]): Int = {
  var pop: Int = 0
  var currentList = myList
  while (currentList.nonEmpty) {
    pop = currentList.head
    currentList = currentList.tail
  }
  pop
}

Last(myList)
ListCycle(myList)

//task2
def length(list: List[Int]): Int = {
  if(list.isEmpty) {
    return 0
  } else return 1 + length(list.tail)
}

def lengthCycle(list: List[Int]): Int = {
  var counter: Int = 0
  var tempList = list
  while(tempList.nonEmpty) {
    counter = counter + 1
    tempList = tempList.tail
  }
  counter
}

print (length(myList))
print(lengthCycle(myList))

//task3

def isPalindrom(list: List[Int]): Boolean = {
  var tempList = list
    if(tempList.length <= 1) true
    else {
      if (tempList.head == Last(tempList)) {
        tempList = tempList.tail
        tempList = tempList.init
        isPalindrom(tempList)
      }
      else false
    }
}


def isPalindromCycle(list: List[Int]) = {
  var leftTempList = list
  var rightTempList = list
  var statusPolegon = true
  var i = 0;
  while (i < leftTempList.length / 2) {
    if (leftTempList.head == rightTempList.last) {
      leftTempList = leftTempList.tail
      rightTempList = rightTempList.init
    } else
      statusPolegon = false
    i = i + 1
  }
  statusPolegon
}

isPalindrom(myList)
isPalindromCycle(myList)

//task4

def removeAtCycle(list: List[Int], k: Int): List[Int] = {
  var tempList = list
  var newList: List[Int] = List()
  var i = 0
  while(tempList.nonEmpty) {
    if(i != k) newList = newList :+ tempList.head
    tempList = tempList.tail
    i = i + 1
  }
  newList
}

print(removeAtCycle(myList, 1))

//task5

def getElementAt(list: List[Int], index: Int): Int = {
  var tempList = list
  var i: Int = 0
  var elem: Int = 0
  while(tempList.nonEmpty) {
    if (i == index)  {
      elem = tempList.head
      return elem
    }
    i = i + 1
    tempList = tempList.tail
  }
  elem
}

def randomSelect(list: List[Int], k: Int): List[Int] = {
  var tempList = list
  while(tempList.length != k) {
    var randomPosition: Int = scala.util.Random.nextInt(tempList.length)
    tempList = removeAtCycle(tempList, randomPosition)
    randomSelect(tempList, k)
  }
  tempList
}

print(randomSelect(myList, 2))

def randomSelectCycle(list: List[Int], k: Int) = {
  var tempList = list
  var newRandomList: List[Int] = List()
  var i = 0;
  while (i < k) {
    var randomPosition: Int = scala.util.Random.nextInt(tempList.length)
    newRandomList = newRandomList :+ getElementAt(tempList, randomPosition)
    i = i + 1
    tempList = removeAtCycle(tempList, randomPosition)
  }
  newRandomList
}

print(randomSelectCycle(myList, 4))

//task6

def isPrime(number: Int, Divider: Double = 2 ): Boolean = {
  if (number == 0 || number == 1) return true

  if (Divider > Math.ceil(Math.sqrt(number))) return true

  if (number % Divider == 0) return false
  else return isPrime(number, Divider + 1)
}

def isPrimeCycle(number: Int): Boolean = {
  if (number % 2 == 0) return false

  val maxDividedNumber: Double = Math.ceil(scala.math.sqrt(number))
  var i = 3
  while (i <= maxDividedNumber) {
    if (number % i == 0) return false
    else i = i + 1
  }
  true
}

print(isPrime(29))
print(isPrimeCycle(39))

//task7
def Newton(x: Double, eps: Double, iter:Int=0): Double = {
  var f = .0
  var df = .0
  var result = .0
  if (iter < 20000) {
    f = (x*x*x) + 18*x-83
    df = 3*(x*x) + 18
    result = x - f / df
    if (Math.abs(f) > eps) result
    else Newton(x, eps, iter+1)
  } else result
}

def NewtonCycle(x: Double, eps: Double) = {
  var f = .0
  var df = .0
  var iter = 0
  var result:Double = 0
  print("x0="+ x + "\n")
  do {
    f = (x*x*x) + 18*x-83
    df = 3*(x*x) + 18
    result = x - f / df
    iter += 1
  } while ( { Math.abs(f) > eps && iter < 2000000 })
  print("Final: "+ iter + " "+ "iterations" + " " )
  print("Result: "+result)
}
NewtonCycle(2.9, 0.04405)
Newton(2.9, eps = 0.04405)